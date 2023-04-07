(ns ring-app.core
  (:require [ring.adapter.jetty :as jetty]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn handler [request-map]
  (println "got a request to process ...")
  {:status 200
   :headers {"Content-Type" "text/html"}}
   :body (str "<html><body> Your IP is : " (:remote-addr request-map) "</body></html>"))


(defn -main []
  (println "starting handler...")
  (jetty/run-jetty handler  {:port 3000 :join? false}))
