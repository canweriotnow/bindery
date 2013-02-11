(ns bindery.common
  (:require [clojure.string :as string]))

(defn desym [sym]
  (string/replace-first (str sym) #":" ""))

(defn get-values-seq 
  "Takes a set of records and returns a seq of the values only."
  [recs ks]
  (map #(get recs %) ks))