(ns kiooform.collapsible
  (:require [reagent.core :as r :refer [atom]]))

(defn collItemTitle [text]
  [:h3 {:style {:cursor "pointer" :margin 0}} text])

(defn collItemBody [content]
  [:div {:style {}}
   [:div {:className "CIB-wrapper"}
    content]])

(defn collItem [title content]
  [:div
   [collItemTitle title]
   [collItemBody content]])

(defn collapsible [children]
  [:div
   (for [{:keys [title content]} children]
     [collItem title content])])