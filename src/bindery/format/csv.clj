(ns bindery.format.csv
  (:use bindery.common)
  (:require [clojure.string :as string]))

(defn column-headers [resultset]
  (string/join ","
    (map #(keyword->string %) (keys (first resultset)))))

(defn csv-data [resultset]
  (str (string/join "\n" (map #(string/join "," %) (map get-values-seq resultset)))))

(defn build-csv [resultset]
  (let [headers (column-headers resultset)
        data (csv-data resultset)]
    (str headers "\n" data)))

