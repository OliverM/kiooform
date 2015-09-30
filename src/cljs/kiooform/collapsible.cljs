(ns kiooform.collapsible
  (:require [reagent.core :as r :refer [atom]]))

(enable-console-print!)

(defn collItemTitle [text visible]
  [:h3
   {:style    {:cursor "pointer" :margin 0}
    :on-click #(do (swap! visible not)
                   (-> % .stopPropagation))} text])

(defn collItemBody [content visible]
  [:div {:style {:max-height (if (= @visible true) "100%" "0px")
                 :overflow (if (= @visible true) "visible" "hidden")}}
   [:div {:className "CIB-wrapper"}
    content]])

(defn collItem [title content]
  (let [visible (atom false)]
    [:div
     [collItemTitle title visible]
     [collItemBody content visible]]))

(defn collapsible [children]
  [:div
   (map-indexed
     (fn [i {:keys [title content]}] ^{:key i} [collItem title content])
     children)])