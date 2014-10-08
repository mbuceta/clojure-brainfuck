(ns clojure-brainfuck.eval-test
  (:require [clojure.test :refer :all]
            [clojure-brainfuck.memory :as mem]  
            [clojure-brainfuck.eval :refer :all]))

(deftest evaluate-node-p
  (testing "Evaluate node p"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) node [:p]] (is (= 
                                                                         (evaluate-node memory node)  
                                                                         (mem/make-memory [2 3 5] 8 [11 13 17])
                                                                         )))
  )
)

(deftest evaluate-node-m
  (testing "Evaluate node m"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) node [:m]] (is (= 
                                                                         (evaluate-node memory node) 
                                                                         (mem/make-memory [2 3 5] 6 [11 13 17]))))
  )
)

(deftest evaluate-node-l
  (testing "Evaluate node l"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) node [:l]] (is (=  
                                                                         (evaluate-node memory node) 
                                                                         (mem/make-memory [2 3 5 7] 11 [13 17]) )))
  )
)

(deftest evaluate-node-h
  (testing "Evaluate node h"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) node [:h]] (is (= 
                                                                         (evaluate-node memory node) 
                                                                         (mem/make-memory [2 3] 5 [7 11 13 17]))))
  )
)

(deftest evaluate-value-to-zero
  (testing "Evaluate decrement value to zero"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) tree [[:b [:m]]]] (is (= 
                                                                         (evaluate-tree memory tree) 
                                                                         (mem/make-memory [2 3 5] 0 [11 13 17]))))
  )
)
