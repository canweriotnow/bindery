(ns bindery.format.excel-test
  (:use clojure.test
        bindery.format.excel
        dk.ative.docjure.spreadsheet)
  (:require [clojure.java.io :as io]))

(def test-recs [{:foo "foo" :bar "bar"} {:foo "baz" :bar "quux"}])

(defn read-generated-spreadsheet [sheet]
  (->> (load-workbook (str sheet ".xlsx"))
       (select-sheet sheet)
       (select-columns {:A :foo :B :bar})))

(defn generate-spreadsheet []
  (create-xlsx "test" test-recs))

(defn delete-spreadsheet []
  (io/delete-file "test.xlsx"))

(use-fixtures :each (fn [f] (generate-spreadsheet) (f) (delete-spreadsheet)))

(deftest create-xlsx-test
  (testing "It should output an excel spreadsheet with the proper data"
    (is (= (read-generated-spreadsheet "test") [{:bar "bar", :foo "foo"} {:bar "bar", :foo "foo"} {:bar "quux", :foo "baz"}]))))