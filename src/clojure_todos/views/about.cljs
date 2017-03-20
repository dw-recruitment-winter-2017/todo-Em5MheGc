(ns clojure_todos.views.about
  (:require [reagent.core :as r :refer [atom]]
            [secretary.core :as secretary :include-macros true]))

;; -------------------------
;; Views

(defn about-page []
  [:div [:h2 "About the app"
         :p "This project is a CRUD application written in Clojure.
         It adds todos (tasks) that are not yet complete (false) into a database."]])

;; -------------------------
;; Routes

(secretary/defroute "/about" [] (#'about-page))

;; -------------------------
;; Initialize app

(defn init! []
  (r/render [] ()))
