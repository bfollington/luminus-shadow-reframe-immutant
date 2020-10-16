(ns luminus-shadow-reframe-immutant.handler-test
  (:require
    [clojure.test :refer :all]
    [ring.mock.request :refer :all]
    [luminus-shadow-reframe-immutant.handler :refer :all]
    [luminus-shadow-reframe-immutant.middleware.formats :as formats]
    [muuntaja.core :as m]
    [mount.core :as mount]))

(defn parse-json [body]
  (m/decode formats/instance "application/json" body))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'luminus-shadow-reframe-immutant.config/env
                 #'luminus-shadow-reframe-immutant.handler/app-routes)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response ((app) (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response ((app) (request :get "/invalid"))]
      (is (= 404 (:status response))))))
