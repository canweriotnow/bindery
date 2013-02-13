(ns bindery.format.csv
  (:use bindery.common)
  (:require [clojure.string :as string]))

(defn column-headers [resultset]
  (string/join ","
    (map #(desym %) (keys (first resultset)))))

(defn csv-data [resultset]
  (str (string/join (get-values-seq resultset)) "\n"))

(defn build-csv [resultset]
  (let [headers (column-headers resultset)
        data (csv-data resultset)]
    (str headers "\n" data)))

