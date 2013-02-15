(ns bindery.format.csv
  (:use bindery.common)
  (:require [clojure.string :as string]))

(defn column-headers 
  "Create the CSV column headers"
  [resultset]
  (string/join ","
    (map #(keyword->string %) (keys (first resultset)))))

(defn csv-data 
  "Create teh CSV (data) body"
  [resultset]
  (str (string/join "\n" (map #(string/join "," %) (map get-values-seq resultset)))))

(defn build-csv 
  "Put it all together."
  [resultset]
  (let [headers (column-headers resultset)
        data (csv-data resultset)]
    (str headers "\n" data)))

(defn create-csv-file [resultset filename]
  (let [data (build-csv resultset)
        file filename]
    (spit file data)))

