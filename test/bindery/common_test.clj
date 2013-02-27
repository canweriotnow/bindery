(ns bindery.common-test
  (:use clojure.test
        bindery.common))

(def test-recs [{:foo "foo" :bar "bar"} {:foo "baz" :bar "quux"}])


(deftest get-column-keys-test
  (testing "get-column-keys should return a vector of the keys in the first record in a set"
    (is (= (get-column-keys test-recs) [:foo :bar]))))

(deftest get-values-seq-test
  (testing "it should return a seq of the values in a map"
    (is (= (get-values-seq (first test-recs)) '("foo" "bar")))))

(deftest keys->column-headers-test
  (testing "It should take a set of maps and return the keys of the first map as vector of strings"
    (is (= (keys->column-headers test-recs) ["foo" "bar"]))))

(deftest data->nested-vec-test
  (testing "It should take a vector of maps, and return a vector of vectors with the column headers as the first vector, the data as the rest."
    (is (= (data->nested-vec test-recs) [["foo" "bar"] ["foo" "bar"] ["baz" "quux"]]))))