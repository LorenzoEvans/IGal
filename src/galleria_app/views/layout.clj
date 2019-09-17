(ns galleria-app.views.layout
  (:require [hiccup.page :refer :all]))

(defn application [title & content]
  (html5
   [:head
    [:title title]
    (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
    [:body
     [:div {:class "container"} content]]]))
