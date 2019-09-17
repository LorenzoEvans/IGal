(ns galleria-app.views.contents
  (:require [hiccup.form]
            [hiccup.element :refer [link-to]]))

(defn index []
  [:div {:id "content"}
   [:h1 {:class "text-success"} "CodeArtBeautyLogic"]])

(defn not-found []
  [:div
   [:h1 {:class "info-warning"} "There's no art here!"]
   [:p "Sorry about that :("]
   (link-to {:class "btn btn-primary"} "/" "Go back to the gallery.")])
