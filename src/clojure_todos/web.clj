(ns clojure_todos.web
  (:require [clojure_todos.controllers.tasks :as tasks]
            [clojure_todos.models.migration :as schema]
            [compojure.core :refer [defroutes]]
            [compojure.route :as route]
            [ring.adapter.jetty :as ring]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  (:gen-class))

(defroutes routes
           tasks/routes
           (route/resources "/"))

(def application (wrap-defaults routes site-defaults))

(defn start [port]
  (ring/run-jetty application {:port port
                               :join? false}))

(defn -main []
  (schema/migrate)
  (let [port (Integer. (or (System/getenv "PORT") "8082"))]
    (start port)))
