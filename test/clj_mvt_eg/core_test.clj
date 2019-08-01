(ns ^:eftest/synchronized clj-mvt-eg.core-test
  (:require [clojure.test :refer :all]
            [clj-mvt-eg.core :refer :all]))

(deftest pass-test
  (is (= (str (clj-mvt-eg.core/make-date 1944 2 28)) "1944-02-28")))

(deftest fail-test
  (is (= (str (clj-mvt-eg.core/make-date 1944 2 28)) "1945-02-28")))

(deftest pass-thrown-test
  (is (thrown?
       clojure.lang.ExceptionInfo
       (clj-mvt-eg.core/make-date 1945 02 29))))

