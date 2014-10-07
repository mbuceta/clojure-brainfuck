(ns clojure-brainfuck.memory-test
  (:require [clojure.test :refer :all]
            [clojure-brainfuck.memory :refer :all]))


(deftest empty-memory-invariant-after-move-left
  (testing "Empty memory do not change after move left"
    (is (= empty-memory (normalize (move-left empty-memory))))))

(deftest empty-memory-invariant-after-move-right
  (testing "Empty memory do not change after move right"
    (is (= empty-memory (normalize (move-right empty-memory))))))

(deftest empty-memory-invariant-after-many-moves
  (testing "Empty memory do not change after many moves"
    (is (= empty-memory (normalize (-> empty-memory move-right move-right move-right move-left)) ))
  )
)

(deftest increment-and-move-right-pattern
  (testing "Increment and move right"
    (is (= (make-memory [2 1] 0 []) (-> empty-memory increment increment move-right increment move-right)))
  )
)

(deftest increment-and-move-left-pattern
  (testing "Increment and move left"
    (is (= (make-memory [] 0 [1 2]) (-> empty-memory increment increment move-left increment move-left)))
  )
)

(deftest decrement-and-move-right-pattern
  (testing "Decrement and move right"
    (is (= (make-memory [254 255] 0 []) (-> empty-memory decrement decrement move-right decrement move-right)))
  )
)

(deftest decrement-and-move-left-pattern
  (testing "Decrement and move left"
    (is (= (make-memory [] 0 [255 254]) (-> empty-memory decrement decrement move-left decrement move-left)))
  )
)

(deftest read-out-return-current-value
  (testing "Read out return current value"
    (is (= (read-out (make-memory [2 3 5] 7 [11 13])) 7))
  )
)

(deftest write-in-set-current-value
  (testing "Write in set current value and return memory"
    (is (= (write-in (make-memory [2 3 5] 7 [11 13]) 17) (make-memory [2 3 5] 17 [11 13])))
  )
)
