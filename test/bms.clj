(require '[criterium.core :as c])

(def c1 (complex-number 1 2))
(def c2 (complex-number 2 4))
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
