(ns clojure_todos.controllers.tasks
  (:require [clojure.string :as str]
            [clojure_todos.models.task :as model]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.response :as ring]))

(defn index []
  (model/read-all))

(defn create
  [task]
  (when-not (str/blank? task)
    (model/create task))
  (ring/redirect "/"))

(defroutes routes
           (GET "/" [] (index))
           (POST "/" [task] (create task)))