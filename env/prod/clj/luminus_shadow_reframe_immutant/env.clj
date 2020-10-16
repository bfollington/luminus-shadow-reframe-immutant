(ns luminus-shadow-reframe-immutant.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[luminus-shadow-reframe-immutant started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-shadow-reframe-immutant has shut down successfully]=-"))
   :middleware identity})
