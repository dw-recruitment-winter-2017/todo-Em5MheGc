(ns clojure_todos.controllers.about
  (:require [compojure.core :refer [defroutes GET]]))

(defroutes routes
           (GET "/about" []))
