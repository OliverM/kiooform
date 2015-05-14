(ns kiooform.core
    (:require [kioo.reagent :as k]
              [reagent.core :as reagent :refer [atom]])
    (:require-macros [kioo.reagent :refer [defsnippet deftemplate]]))

;; problematic kioo-generated component takes a long time to appear in the page
(deftemplate minform "minform.html" [])

;; test reagent component to insert in render-component call below
(defn p-test []
  [:div
   [:p "Just checking all this plumbing "
    [:i "works"] "."]
   [:p
    [:span {:style {:color "red"}} "Red."]]])

(defn mount-root []
  (reagent/render-component [minform] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
