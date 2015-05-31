(defproject complex "0.1.0"
  :description "A Clojure library for doing fast complex number calculations that
wraps the Java commons-math3 Complex library."
  :url "https://github.com/alanforr/complex"
  :scm {:name "git"
            :url "https://github.com/alanforr/complex"}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.apache.commons/commons-math3 "3.5"]
                 [criterium "0.4.3"]]
  :main complex.core)
