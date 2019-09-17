(ns galleria-app.app
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :as handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]
            [hiccup.core :refer :all]
            [galleria-app.views.layout :as layout]
            [galleria-app.views.contents :as contents]))

(defn welcome []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (html [:h1 "Welcome To The Immutable Gallery"])})

(defroutes app-routes
           (GET "/" []
                (layout/application "Home" (contents/index)))
           (route/resources "/")
           (ANY "*" []
                (route/not-found (layout/application "Page Not Found" (contents/not-found)))))

(def application  (handler/site app-routes))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 500))]
    (jetty/run-jetty application {:port port :join? false})))
