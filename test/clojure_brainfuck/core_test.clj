(ns clojure-brainfuck.core-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as jio] 
            [clojure-brainfuck.core :refer :all]))

(deftest hello-world
  (testing "Hello World"
  (is (= 
        (with-out-str (evaluate_bf_code (slurp (jio/file (jio/resource "hello.bf")))))
        "Hello World!\n"
      ))
))

(deftest fibonacci
  (testing "Fibonacci less than 100"
  (is (= 
        (with-out-str (evaluate_bf_code (slurp (jio/file (jio/resource "fibonacci.bf")))))
        "1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89"
      ))
))

(deftest sierpinski
  (testing "Sierpinski"
  (is (= 
        (with-out-str (evaluate_bf_code (slurp (jio/file (jio/resource "sierpinski.bf")))))
        (slurp (jio/file (jio/resource "sierpinski.out")))
      ))
))
