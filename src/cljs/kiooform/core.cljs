(ns kiooform.core
    (:require [kioo.reagent :as k]
              [reagent.core :as reagent :refer [atom]]
              [hickory.core :as h])
    (:require-macros [kioo.reagent :refer [defsnippet deftemplate]]))

;; try parsing html via hickory then inserting into reagent component
(defn h-test []
  (->> "<div class=\"outcomes\">\n    <h2>Outcomes</h2>\n    <form>\n        <fieldset>\n            <legend>Outcomes assessment</legend>\n            <div>\n                <div>\n                    <label for=\"outcomescompletiondate\">Outcomes for month ending</label>\n                    <input id=\"outcomescompletiondate\" type=\"date\">\n                </div>\n            </div>\n        </fieldset>\n    </form>\n</div>"
      h/parse-fragment
      (map h/as-hiccup)
       first
       ))

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
  (reagent/render-component [h-test]
                            (.getElementById js/document "app")))

(defn init! []
  (mount-root))
