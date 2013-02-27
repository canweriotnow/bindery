(ns bindery.common
  (:require [clojure.string :as string])
  (:require [clojure.walk :as walk]))



(defn get-column-keys [recs]
  (let [recs recs]
    (cond 
      (vector? recs) (keys (first recs))
          (map? recs) (keys recs))))

(defn get-values-seq 
  "Takes a set of records and returns a seq of the values only."
  [rec]
  (let [column-keys (get-column-keys rec)]
    (-> (map #(get rec %) column-keys) vec)))

(defn keys->column-headers [recs]
  (-> (keys (walk/stringify-keys (first recs))) vec))

(defn data->nested-vec [data]
  (-> 
    (cons 
      (keys->column-headers data)
      (map get-values-seq data)) vec))
