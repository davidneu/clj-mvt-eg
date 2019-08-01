(ns clj-mvt-eg.core
  (:require
   [clojure.java.io :as io]
   [clojure.pprint :as pprint]
   [clojure.set :as set]   
   [clojure.string :as str]
   [java-time :as jt]
   [clj-mvt.breakpoint :refer [break]])
  (:import (java.io FileInputStream)))

(defn make-date [year month day]
  (jt/local-date year month day))

(defn make-new-years-day
  ([]
   (make-new-years-day (jt/as (jt/local-date) :year)))
  ([year]
   (make-date year 12 31)))

(defn stacktrace-example []
  (make-date 1945 2 29))

(defn break-example []
  ;; d is randomly set to 0 or 1.
  (let [n 5
        d (rand-int 2)]
    (break)
    (/ n d)))
 
(defn break-loop-example []
  (dotimes [n 5]
    ;; d is randomly set to 0 or 1.
    (let [d (rand-int 2)]
      (break)
      (/ n d))))

;; (defn compile-syntax-check-phase-error-example []
;;     "Unable to resolve symbol"
;;     (let [x 1
;;           y z]
;;       (println x)))

;; (defn macro-syntax-check-phase-error-example []
;;     "Even number of forms"
;;     (let [x 1
;;           y]
;;       (println x)))

(defn -main [& args]
  (println (format "Today is %s" (java-time/format "MMMM dd, yyyy" (java-time/local-date)))))

