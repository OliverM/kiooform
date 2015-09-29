(ns kiooform.core
    (:require [kioo.reagent :as k]
              [reagent.core :as reagent :refer [atom]]
              [kiooform.collapsible :refer [collapsible]]
              )
    (:require-macros [kioo.reagent :refer [defsnippet deftemplate]]))

(def collapsible-data [{:title "Title 1" :content [:p "First piece of content."]}
                       {:title "Title 2" :content [:p "Second piece of content."]}
                       {:title "Title 3" :content [:p "Third piece of content."]}])

(deftemplate minform "minform.html" []
             {[:div#c-target] (k/content [collapsible collapsible-data])
              })

(defn mount-root []
  (reagent/render-component [minform]
                            (.getElementById js/document "app")))

(defn init! []
  (mount-root))
