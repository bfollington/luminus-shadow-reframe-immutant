(ns luminus-shadow-reframe-immutant.app
  (:require [luminus-shadow-reframe-immutant.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
