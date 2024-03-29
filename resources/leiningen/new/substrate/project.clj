(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "https://github.com/FIXME/{{name}}"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/spec.alpha "0.2.176"]
                 [org.clojure/core.async "0.4.500"]
                 [org.clojure/tools.cli "0.4.2"]
                 [com.stuartsierra/component "0.4.0"]
                 [com.taoensso/timbre "4.10.0"]
                 [orchestra "2019.02.06-1"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
                   :source-paths ["dev"]}
             :uberjar {:aot :all
                       :main {{name}}.core}})
