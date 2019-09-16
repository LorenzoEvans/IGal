(defproject Galleria "1.0.0-SNAPSHOT"
            :description "Generative design gallery in Clojure."
            :url "http://immutablegallery.herokuapp.com"
            :dependencies [[org.clojure/clojure "1.10.0"]
                           [compojure "1.6.1"]
                           [ring/ring-jetty-adapter "1.7.1"]
                           [environ "1.1.0"]
                           [hiccup "1.0.5"]]
            :min-lein-version "2.0.0"
            :plugins [[environ/environ.lein "0.3.1"]]
            :hooks [environ.leiningen.hooks]
            :uberjar-name "Galleria.jar")
