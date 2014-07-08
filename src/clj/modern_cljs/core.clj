(ns modern-cljs.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "<a href='/simple.html'>开启藏密生活</a>")
  (route/resources "/")
  (route/not-found "Page not found"))

(def handler (handler/site app-routes))
