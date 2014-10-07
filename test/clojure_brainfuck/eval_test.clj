(ns clojure-brainfuck.eval-test
  (:require [clojure.test :refer :all]
            [clojure-brainfuck.memory :as mem]  
            [clojure-brainfuck.eval :refer :all]))

(deftest evaluate_node_p
  (testing "Evaluate node p"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) node [:p]] (is (= 
                                                                         (evaluate_node memory node)  
                                                                         (mem/make-memory [2 3 5] 8 [11 13 17])
                                                                         )))
  )
)

(deftest evaluate_node_m
  (testing "Evaluate node m"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) node [:m]] (is (= 
                                                                         (evaluate_node memory node) 
                                                                         (mem/make-memory [2 3 5] 6 [11 13 17]))))
  )
)

(deftest evaluate_node_l
  (testing "Evaluate node l"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) node [:l]] (is (=  
                                                                         (evaluate_node memory node) 
                                                                         (mem/make-memory [2 3 5 7] 11 [13 17]) )))
  )
)

(deftest evaluate_node_h
  (testing "Evaluate node h"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) node [:h]] (is (= 
                                                                         (evaluate_node memory node) 
                                                                         (mem/make-memory [2 3] 5 [7 11 13 17]))))
  )
)

(deftest evaluate_value_to_zero
  (testing "Evaluate decrement value to zero"
    (let [memory (mem/make-memory [2 3 5] 7 [11 13 17]) tree [[:b [:m]]]] (is (= 
                                                                         (evaluate_tree memory tree) 
                                                                         (mem/make-memory [2 3 5] 0 [11 13 17]))))
  )
)
