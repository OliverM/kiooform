(ns kiooform.core
    (:require [kioo.reagent :as k]
              [reagent.core :as reagent :refer [atom]]
              [hickory.core :as h])
    (:require-macros [kioo.reagent :refer [defsnippet deftemplate]]))

(def collapsible (reagent/adapt-react-class "CommentBox"))

(deftemplate minform "minform.html" []
             {[:div#c-target] (k/content [collapsible #js {:comment "I'm a plain React component"}])
              })

;; test reagent component to insert in render-component call below
(defn p-test []
  [:div
   [:p "Just checking all this plumbing "
    [:i "works"] "."]
   [:p
    [:span {:style {:color "red"}} "Red."]]
   [collapsible #js {:comment "I'm a plain React component"}]])

(defn mount-root []
  (reagent/render-component [minform]
                            (.getElementById js/document "app")))

(defn init! []
  (mount-root))
