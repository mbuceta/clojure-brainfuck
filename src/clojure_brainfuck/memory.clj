; The initial memory. The tape is represented by one left list :l, the current position
; :v and one right list :r
(ns clojure-brainfuck.memory
    (require [clojure-brainfuck.arith :as arith])
  )

(defn make-memory [l v r]  {:l (map arith/fit (reverse l))   :v (arith/fit v) :r (map arith/fit r)})

(def empty-memory (make-memory '() 0 '()))

(defn increment  [memory] (update-in memory [:v] (arith/fit-comp inc)))

(defn decrement  [memory] (update-in memory [:v] (arith/fit-comp dec)))

(defn move-left  [memory] (let [{:keys [l r v]} memory] {:l (rest l)   :r (cons v r) :v (arith/fit (first l))}))

(defn move-right [memory] (let [{:keys [l r v]} memory] {:l (cons v l) :r (rest r)   :v (arith/fit (first r))}))

(defn read-out   [memory] (:v memory))

(defn write-in   [memory ch] (assoc memory :v (arith/fit ch)))

(defn to-string [memory] (str (if (empty? (:l memory)) "()" (reverse (:l memory))) " " (:v memory) " " (if (empty? (:r memory)) "()" (:r memory))))

(defn filter-last-zeros [s] (reverse (drop-while zero? (reverse s))))

(defn normalize  [memory] (let [{:keys [l r v]} memory] {:l (filter-last-zeros l)   :r (filter-last-zeros r) :v v}))
