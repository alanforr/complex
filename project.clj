(defproject complex "0.1.10"
  :description "A Clojure library for doing fast complex number calculations that
wraps the Java commons-math3 Complex library."
  :url "https://github.com/alanforr/complex"
  :uberjar {:aot :all}
  :profiles {:dev {:dependencies  [[criterium "0.4.3"]]}}
  :deploy-repositories [["releases"  {:sign-releases false :url "https://clojars.org/repo"}]
                        ["snapshots" {:sign-releases false :url "https://clojars.org/repo"}]]
  :scm {:name "git"
            :url "https://github.com/alanforr/complex"}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.apache.commons/commons-math3 "3.5"]]
  :main complex.core)
