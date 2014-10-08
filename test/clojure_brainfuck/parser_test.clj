(ns clojure-brainfuck.parser-test
  (:require [clojure.test :refer :all]
            [clojure-brainfuck.parser :refer :all]))

(deftest code-without-brackets
  (testing "Parser a simple code without any bracket"
    (is  (= (bf-parser ">-<+,." ) [[:l] [:m] [:h] [:p] [:r] [:w]]))
  )
)

(deftest invalid-character
  (testing "Parser must fail with invalid characters"
    (let [{line :line column :column} (bf-parser ">><<++--[...@,,]")] (do (is (= line 1)) (is (= column 13))))
  )
)

(deftest open-unbalance-bracket
  (testing "Parser must fail with unbalance brackets"
    (let [{line :line column :column} (bf-parser ">><--[++--<<>>...")] (do (is (= line 1)) (is (= column 18))))
  )
)

(deftest closed-unbalance-bracket
  (testing "Parser must fail with unbalance brackets"
    (let [{line :line column :column} (bf-parser "+>><-++-,]++--<<>>...")] (do (is (= line 1)) (is (= column 10))))
  )
)

(deftest empty-brackets
  (testing "Parser must fail with empty brackets"
    (let [{line :line column :column} (bf-parser ">><--[]++--<<>>...")] (do (is (= line 1)) (is (= column 7))))
  )
)

(deftest simple-brackets-recursion
  (testing "Parser is recursive in bracket. Inner bracket code parser result must be equal to the bracket part of the full code result"
    (let [before_code "<>..+-" after_code "++---" inner_code "<<<>>++<>-,."] (is (= 
      (rest (nth (bf-parser (str before_code  "[" inner_code "]" after_code )) (count before_code)))
      (bf-parser inner_code)
                                                                              ))
    )
  )
)
