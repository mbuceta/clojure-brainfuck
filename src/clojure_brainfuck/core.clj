(ns clojure-brainfuck.core
    (use [clojure-brainfuck.memory :as mem])
    (use [clojure-brainfuck.parser :as parser])
    (use [clojure-brainfuck.eval   :as evaluator])
  )

; Reads input file from command line and filter everything but
; the brainfuck operators.
; (def input (apply str (filter #(#{ \[ \] \+ \- \. \, \> \<} %) (slurp (nth clojure.core/*command-line-args* 1)))))

; Parses the input file using parser, and generate the parsed tree

; filter everything but the brainfuck operators.
; In this first version the parser doesn't support any other character
(defn clean_bf_code [sc] (apply str (filter #(#{ \[ \] \+ \- \. \, \> \<} %) sc)))

(defn evaluate_bf_code [sc] (evaluator/evaluate_tree mem/empty-memory (parser/bf-parser (clean_bf_code sc))))


(defn -main
  "Executes brainfuck code from the file passed as the first argument"
  [& args]
  (evaluate_bf_code (slurp (first args)))
)
