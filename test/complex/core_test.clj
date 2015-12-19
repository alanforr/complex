(ns complex.core-test
  (:use [complex.core]
        [clojure.test]))

(def c1 (complex 1 2))

(def c2 (complex 3 4))

(def c3 (complex 3 2))

(def c4 (complex 4 6))

(deftest abs-test
 (is  (= (Math/sqrt 5) (abs c1))))

(deftest +test
  (are [x y] (= x y)
       c3 (+ c1 2)
       c3 (+ 2 c1)
       (complex 3) (+ 1 2)
       c4 (+ c1 c2)))

(def c5 (complex 2 4))

(def c6 (complex -5 10))

(deftest *test
  (are [x y] (= x y)
       c5 (* c1 2)
       c5 (* 2 c1)
       c6 (* c1 c2)))

(def c7 (complex 0 2))

(def c8 (complex 1 -2))

(def c9 (complex 2 2))

(deftest -test
  (are [x y] (= x y)
       (complex 1) (- 2 1)
       c7 (- c1 1)
       c8 (- 2 c1)
       c9 (- c2 c1)))

(def c10 (complex 1/2 1))

(deftest divtest
  (are [x y] (= x y)
       (complex 1/2) (/ 1 2)
       c10 (/ c1 2)
       (complex 2 0) (* c1 (/ 2 c1))
       c2 (* c1 (/ c2 c1))))

(deftest reciprocal-test
  (is (= (complex 1 0) (* c1 (reciprocal c1)))))

(deftest conjugate-test
  (is (= (complex 1 -2) (conjugate c1))))

(deftest equalstest
  (are [x y] (= x y)
       true (equals c1 c1)
       true (equals (/ c1 2) c10)))

(deftest equals-eps-test
  (is (true?
        (equals (complex 1) (complex 1))))
  (is (true?
        (equals (complex 0.0) (complex 0.0))))
  (is (true?
        (equals (complex -0.0) (complex 0.0) 0.000000001)))
  (is (false?
        (equals (complex -0.0) (complex 0.0)))))

(deftest imaginary-part-test
  (is (= 2.0 (imaginary-part c1))))

(deftest real-part-test
  (is (= 1.0 (real-part c1))))

(deftest negate-test
  (is (= (complex 0 0) (+ c1 (negate c1)))))

(deftest powtest
  (are [x y] (= x y)
       (complex 4) (pow 2 2)
       (complex -3 4.000000000000002) (pow c1 2)))