(ns clojure-brainfuck.arith)

; fits a integer o null into (0..255) allowed values.
; Null value is mapped to 0 and integers into its
; congruent one, modulo 256
(defn fit [v] (if v (mod v 256) 0))

; Creates a new function from a function f, which fits the result
; of f using the fit fuction
(defn fit-comp [f] (fn [& args] (fit (apply f args))))
