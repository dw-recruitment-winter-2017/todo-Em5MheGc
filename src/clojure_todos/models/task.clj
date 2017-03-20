(ns clojure_todos.models.task
  (:require [clojure.java.jdbc :as sql]))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/clojure_todos"))

(defn read-all []
  (into [] (sql/query spec ["SELECT * FROM tasks"])))

(defn create [task]
  (sql/insert! spec :tasks [:task] [task]))