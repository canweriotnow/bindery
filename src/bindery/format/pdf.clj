(ns bindery.format.pdf
  (:use clj-pdf.core)
  (:use bindery.common))

(defn rows->vec [recset]
  (vec (map vec (map get-values-seq recset))))

(def table-template
  (template 
    [:table 
      {:header $head-vector :width 50 :border true :cell-border true}
      $rows]))

(defn create-table [recset]
  (let [table table-template
        records recset
        colkeys (get-column-keys records)
        head-vector (vec (map keyword->string colkeys))
        rows (rows->vec records)]
    (table {:head-vector head-vector :rows rows })))

(defn gen-pdf [heading ]
  )

(defn new-table [recset]
  (let [recset recset
        colkeys (get-column-keys recset)
        head (vec (map keyword->string colkeys))
        table [:table {:header head}]]
    (pdf [{}
          (for [row recset] 
            (conj table
              (vec (get-values-seq row))))]
    "test.pdf")))