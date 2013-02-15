(ns bindery.format.pdf
  (:use clj-pdf.core)
  (:use bindery.common))

(defn rows->vec [recset]
  (vec (map vec (map get-values-seq recset))))

(defn keyword->placeholder [kw]
  (symbol (str "$" (keyword->string kw))))

(defn table-template [colkeys]
  (template (vec (map keyword->placeholder colkeys))))

(defn create-table [recset]
  (let [recset recset
        colkeys (get-column-keys recset)
        table-template (template (vec (map keyword->placeholder colkeys)))
        head-vec (vec (map keyword->string colkeys))]
    (pdf
      [{}
        (into [:table 
          {:header head-vec }]
          (table-template recset))] "export.pdf")))

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