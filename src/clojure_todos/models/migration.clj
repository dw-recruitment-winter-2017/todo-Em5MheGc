(ns clojure_todos.models.migration
  (:require [clojure.java.jdbc :as sql]
            [clojure_todos.models.task :as task]))

(defn migrated? []
  (-> (sql/query task/spec
                 [(str "SELECT * FROM information_schema.tables "
                       "WHERE table_name='tasks")])
      first :count pos?))

(defn migrate []
  (when (not (migrated?))
    (print "Creating db structure") (flush)
    (sql/db-do-commands task/spec
                        (sql/create-table-ddl
                          :tasks
                          [[:id :serial "PRIMARY KEY"]
                           [:task :varchar "NOT NULL"]
                           [:complete :boolean "NOT NULL" "DEFAULT FALSE"]]))
    (println " done")))
