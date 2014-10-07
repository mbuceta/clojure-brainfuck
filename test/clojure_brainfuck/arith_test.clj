(ns clojure-brainfuck.arith-test
  (:require [clojure.test :refer :all]
            [clojure.data.generators :as gen]
            [clojure-brainfuck.arith :refer :all]))

(deftest fit-map-nil-into-zero
  (testing "Fit must map nil into zero"
    (is (= 0 (fit nil)))))

(deftest fit-map-0-255-into-itself
  (testing "Fit must map a number from 0 to 255 into itself"
    (let [number (gen/uniform  0 256)] (is (= number (fit number))))
    ))

(deftest fit-map-more-than-255-into-mod256
  (testing "Fit must map a number 257 into 1"
    (is (= 1 (fit 257)))
    ))

(deftest fit-comp-to-inc
  (testing "Calling fit comp with inc is the same that calling inc and then calling fit"
    (let [number (gen/int) fit-inc (fit-comp inc)] (is (= (fit-inc number) (fit (inc number)))))
    ))
