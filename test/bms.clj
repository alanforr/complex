(ns complex.core.test-ns
  (:require [criterium.core :as c])
  (:use [complex.core :exclude [+ - * /]]
        [clojure.test]))

(def c1 (complex 1 2))
(def c2 (complex 2 4))
c1
c2

(deftest test-equals
  (is (true?
        (equals (complex 1) (complex 1))))
  (is (true?
        (equals (complex 0.0) (complex 0.0))))
  (is (true?
        (equals (complex -0.0) (complex 0.0) 0.1)))
  (is (false?
        (equals (complex -0.0) (complex 0.0)))))

  (c/bench (dotimes [_ 1000] (+ c1 c2)))
  (c/bench (dotimes [_ 1000] (+ c1 c2 2)))
  (c/bench (dotimes [_ 1000] (+ c1 c2 2 c1 c1 c1)))
  (c/bench (dotimes [_ 1000] (+ c1 c2 2 c1 c1 c1 c2 c2 c2)))
  (c/bench (dotimes [_ 1000] (+ c1 c2 2 c1 c1 c1 c2 c2 c2 c1 c1 c1)))

  (c/bench (dotimes [_ 1000] (* c1 c2)))
  (c/bench (dotimes [_ 1000] (* c1 c2 2)))
  (c/bench (dotimes [_ 1000] (* c1 c2 2 c1 c1 c1)))
  (c/bench (dotimes [_ 1000] (* c1 c2 2 c1 c1 c1 c2 c2 c2)))
  (c/bench (dotimes [_ 1000] (* c1 c2 2 c1 c1 c1 c2 c2 c2 c1 c1 c1)))

  (c/bench (dotimes [_ 1000] (- c1 c2)))
  (c/bench (dotimes [_ 1000] (- c1 c2 2)))
  (c/bench (dotimes [_ 1000] (- c1 c2 2 c1 c1 c1)))
  (c/bench (dotimes [_ 1000] (- c1 c2 2 c1 c1 c1 c2 c2 c2)))
  (c/bench (dotimes [_ 1000] (- c1 c2 2 c1 c1 c1 c2 c2 c2 c1 c1 c1)))

  (c/bench (dotimes [_ 1000] (/ c1 c2)))
  (c/bench (dotimes [_ 1000] (/ c1 c2 2)))
  (c/bench (dotimes [_ 1000] (/ c1 c2 2 c1 c1 c1)))
  (c/bench (dotimes [_ 1000] (/ c1 c2 2 c1 c1 c1 c2 c2 c2)))
  (c/bench (dotimes [_ 1000] (/ c1 c2 2 c1 c1 c1 c2 c2 c2 c1 c1 c1)))

  (c/bench (dotimes [_ 1000] (sin c1)))
  (c/bench (dotimes [_ 1000] (sin 1)))
