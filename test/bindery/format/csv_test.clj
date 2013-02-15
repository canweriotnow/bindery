(ns bindery.format.csv-test
  (use clojure.test
       bindery.format.csv))

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