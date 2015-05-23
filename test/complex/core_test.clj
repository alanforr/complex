(ns complex.core-test
  (:require [clojure.test :refer :all]
            [complex.core :refer :all]))

(def c1 (complex-number 1 2))

(def c2 (complex-number 3 4))

(def c3 (complex-number 3 2))

(def c4 (complex-number 4 6))

(deftest abs-test
 (is  (= (Math/sqrt 5) (abs c1))))

(deftest +test
  (are [x y] (= x y)
       c3 (+ c1 2)
       c3 (+ 2 c1)
       (complex-number 3) (+ 1 2)
       c4 (+ c1 c2)))

(def c5 (complex-number 2 4))

(def c6 (complex-number -5 10))

(deftest *test
  (are [x y] (= x y)
       c5 (* c1 2)
       c5 (* 2 c1)
       c6 (* c1 c2)))

(def c7 (complex-number 0 2))

(def c8 (complex-number 1 -2))

(def c9 (complex-number 2 2))

(deftest -test
  (are [x y] (= x y)
       (complex-number 1) (- 2 1)
       c7 (- c1 1)
       c8 (- 2 c1)
       c9 (- c2 c1)))

(def c10 (complex-number 1/2 1))

(deftest divtest
  (are [x y] (= x y)
       (complex-number 1/2) (/ 1 2)
       c10 (/ c1 2)
       (complex-number 2 0) (* c1 (/ 2 c1))
       c2 (* c1 (/ c2 c1))))

(deftest reciprocal-test
  (is (= (complex-number 1 0) (* c1 (reciprocal c1)))))

(deftest conjugate-test
  (is (= (complex-number 1 -2) (conjugate c1))))

(deftest equalstest
  (are [x y] (= x y)
       true (equals c1 c1)
       true (equals (/ c1 2) c10)))

(deftest imaginary-part-test
  (is (= 2.0 (imaginary-part c1))))

(deftest real-part-test
  (is (= 1.0 (real-part c1))))

(deftest negate-test
  (is (= (complex-number 0 0) (+ c1 (negate c1)))))

(deftest powtest
  (are [x y] (= x y)
       4.0 (pow 2 2)
       (complex-number -3 4.000000000000002) (pow c1 2)))
