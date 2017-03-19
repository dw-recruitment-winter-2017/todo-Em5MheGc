(defproject clojure_todos "0.1.0-SNAPSHOT"
  :description "Todo App in Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[compojure "1.6.0-beta3"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/java.jdbc "0.7.0-alpha2"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [reagent "0.6.1"]
                 [ring/ring-defaults "0.2.3"]
                 [ring/ring-jetty-adapter "1.6.0-RC1"]]
  :main ^:skip-aot clojure_todos.web
  :uberjar-name "clojure_todos-standalone.jar"
  :plugins [[lein-ring "0.11.0"]]
  :ring {:handler clojure_todos.web/application
         :init clojure_todos.models.migration/migrate}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}
             :uberjar {:aot :all}})
