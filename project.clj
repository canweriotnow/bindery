(defproject bindery "0.1.0-SNAPSHOT"
  :description "Report formatting for great justice."
  :url "https://github.com/canweriotnow/bindery"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [hiccup "1.0.1"]
                 [dk.ative/docjure "1.6.0"]
                 [clj-pdf "1.0.5"]]
  :dev-dependencies [[lein-marginalia "0.7.1"]]
  :jar-name "bindery-0.1.0-SNAPSHOT.jar"
  :uberjar-name "bindery-0.1.0-SNAPSHOT-standalone.jar"
  :scm {:name "git"
        :url "https://github.com/canweriotnow/bindery"})
