(defproject chinese-site-extractor "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.0"]
                 [ring/ring-jetty-adapter "1.3.0"]
                 [clj-http "1.0.0"]
                 [hickory "0.5.4"]
                 [org.clojure/data.json "0.2.5"]]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]
                 :plugins [[lein-midje "3.1.3"]]}})
