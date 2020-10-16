(ns luminus-shadow-reframe-immutant.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [luminus-shadow-reframe-immutant.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[luminus-shadow-reframe-immutant started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-shadow-reframe-immutant has shut down successfully]=-"))
   :middleware wrap-dev})
