(ns clojure_todos.views.tasks
  (:require [clojure_todos.controllers.tasks :as tasks]
            [clojure_todos.models.task :as model]
            [reagent.core :as r])
  )

(def app-state
  (r/atom {tasks/index}))

(defn add-task []
  (let [val (r/atom "")]
    (fn []
      [:form
       [:input {:type "text"
                :value @val}]
       [:input {:type "submit"
                :value "Add task"
                :on-submit #(model/create [@val])}]])))

;; Render the root component
(defn start []
  (r/render-component
    [add-task] ()))