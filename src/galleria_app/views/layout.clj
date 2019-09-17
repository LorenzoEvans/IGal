(ns galleria-app.views.layout
  (:require [hiccup.page :only (html5 include-css include-js)]))

(defn application [title & content]
  (html5
   [:head
    [:title title]
    (include-css "https://unpkg.com/onsenui/css/onsenui.css")
    (include-css "https://unpkg.com/onsenui/css/onsen-css-components.min.css")
    (include-js "https://unpkg.com/onsenui/js/onsenui.min.js")
    [:body
     [:div {:class "container"} content]]]))
