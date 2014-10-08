(ns clojure-brainfuck.core
    (use [clojure-brainfuck.memory :as mem])
    (use [clojure-brainfuck.parser :as parser])
    (use [clojure-brainfuck.eval   :as evaluator])
  )


; Filter everything but the brainfuck operators.
; In this first version the parser doesn't support any other character
(defn clean-bf-code [sc] (apply str (filter #(#{ \[ \] \+ \- \. \, \> \<} %) sc)))

; Excute brainfuck code. Before parsing clean brainkfuck code using clean-bf-code
(defn execute-bf-code [sc] (evaluator/evaluate-tree mem/empty-memory (parser/bf-parser (clean-bf-code sc))))


; Execute the brainfuck code of the file passing as the first argument.
(defn -main
  "Executes brainfuck code from the file passed as the first argument"
  [& args]
  (execute-bf-code (slurp (first args)))
)
