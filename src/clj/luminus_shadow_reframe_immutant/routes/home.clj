(ns luminus-shadow-reframe-immutant.routes.home
  (:require
   [luminus-shadow-reframe-immutant.layout :as layout]
   [luminus-shadow-reframe-immutant.routes.ws :as ws]
   [clojure.java.io :as io]
   [luminus-shadow-reframe-immutant.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/ws" {:get  (:ajax-get-or-ws-handshake-fn ws/connection)
           :post (:ajax-post-fn ws/connection)}]
   ["/docs" {:get (fn [_]
                    (-> (response/ok (-> "docs/docs.md" io/resource slurp))
                        (response/header "Content-Type" "text/plain; charset=utf-8")))}]])

