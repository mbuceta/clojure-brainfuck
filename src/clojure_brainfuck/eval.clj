(ns clojure-brainfuck.eval
    (use [clojure-brainfuck.memory :as mem])
  )

(declare evaluate_tree)


;(defn evaluate_nodex [memory c]
;  (let [{:keys [l r v]} memory]
;    (cond
;      (= (first c) :p ) (update-in memory [:v] (fit-comp inc))
;      (= (first c) :m ) (update-in memory  [:v] (fit-comp dec))
;      (= (first c) :h ) {:l (rest l)   :r (cons v r) :v (fit (first l))}
;      (= (first c) :l ) {:l (cons v l) :r (rest r)   :v (fit (first r))}
;      (= (first c) :r ) (let [ch (.read *in*)] (assoc memory :v (fit ch)))
;      (= (first c) :w ) (do (print (str (char v))) (flush) memory)
;      (= (first c) :b ) (if (= (:v memory) 0) memory (evaluate_node (evaluate_tree memory (rest c) ) c))
;      :else memory ; Ignore everything else
;    )
;  )
;)

; Evaluates only one operation.
; p : increment the byte at the data pointer
; m : decrement the byte at the data pointer
; l : move the data pointer to point to the next cell to the right
; h : move the data pointer to point to the next cell to the left
; w : output the byte at the data pointer.
; r : accept one byte of input, storing its value in the byte at the data pointer
; b : evaluate the inner code unless the byte at the data pointer is zero 
(defn evaluate_node [memory c]
  (cond
    (= (first c) :p ) (mem/increment  memory)
    (= (first c) :m ) (mem/decrement  memory)
    (= (first c) :h ) (mem/move-left  memory)
    (= (first c) :l ) (mem/move-right memory)
    (= (first c) :r ) (let [ch (.read *in*)] (mem/write-in memory ch))
    (= (first c) :w ) (do (print (str (char (mem/read-out memory)))) (flush) memory)
    (= (first c) :b ) (if (= (mem/read-out memory) 0) memory (evaluate_node (evaluate_tree memory (rest c) ) c))
    :else memory ; Ignore everything else
  )
)


; Evaluates parsed code calling evaluate_node for each single intruction
(defn evaluate_tree [memory tree] (reduce (fn [memory node] (evaluate_node memory node)) memory tree))
