(ns bindery.format.csv-test
  (use clojure.test
       bindery.format.csv)
  (:require [clojure.java.io :as io]))

(def test-recs [{:foo "foo" :bar "bar"} {:foo "baz" :bar "quux"}])

(deftest column-headers-test
  (testing "It should grab the keys to form the column headers"
    (is (= (column-headers test-recs) "foo,bar"))))

(deftest csv-data-test
  (testing "It should build CSV data from the values in the recset"
    (is (= (csv-data test-recs) "foo,bar\nbaz,quux"))))

(deftest build-csv-test
  (testing "It should build a complete csv string complete with headers and data"
    (is (= (build-csv test-recs) "foo,bar\nfoo,bar\nbaz,quux"))))

(defn generate-csv []
  (create-csv-file test-recs "test.csv"))

(defn delete-csv []
  (io/delete-file "test.csv"))

(use-fixtures :once (fn [f] (generate-csv) (f) (delete-csv)))


(deftest create-csv-file-test
  (testing "It should create a file" 
    (is (= (build-csv test-recs) (slurp "test.csv")))))