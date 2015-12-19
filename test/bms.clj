(ns bms
  (:require [criterium.core :as c])
  (:use [complex.core]
        [clojure.test]))

(def c1 (complex 1 2))
(def c2 (complex 2 4))
c1
c2

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
