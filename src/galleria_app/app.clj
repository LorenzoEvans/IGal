(ns galleria-app.app
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]
            [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [hiccup.core :refer :all]))

(defn welcome []
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (html [:h1 "Welcome To The Immutable Gallery"])})

(defroutes app-routes
           (GET "/" []
                (welcome))
           (ANY "*" []
                (route/not-found (slurp (io/resource "404.html")))))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 500))]
    (jetty/run-jetty (site #'app-routes) {:port port :join? false})))
