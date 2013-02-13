(ns bindery.common
  (:require [clojure.string :as string]))

(defn desym [sym]
  (string/replace-first (str sym) #":" ""))

(defn get-column-keys [recs]
  (let [recs recs]
    (cond 
      (vector? recs) (keys (first recs))
          (map? recs) (keys recs))))

(defn get-values-seq 
  "Takes a set of records and returns a seq of the values only."
  [rec]
  (let [column-keys (get-column-keys rec)]
    (map #(get rec %) column-keys)))
  