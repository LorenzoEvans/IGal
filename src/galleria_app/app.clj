(ns galleria-app.app
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]))

(defn welcome []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello from the Immutable Galleria"})

(defroutes app-routes
           (GET "/" []
                (welcome))
           (ANY "*" []
                (route/not-found (slurp (io/resource "404.html")))))

(defn main [& [port]]
  (let [port (Integer. (or port (env :port) 500))]
    (jetty/run-jetty (site #'app-routes) {:port port :join? false})))
