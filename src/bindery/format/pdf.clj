(ns bindery.format.pdf
  (:use clj-pdf.core)
  (:use bindery.common))


(defn keyword->placeholder [kw]
  (symbol (str "$" (name kw))))

(defn table-template [colkeys]
  (template (vec (map keyword->placeholder colkeys))))

(defn create-table 
  "Generate a PDF document with tabular data."
  [recset]
  (let [recset recset
        data (data->nested-vec recset)]
    (pdf
      [{}
        (into [:table 
          {:header (first data) }]
          (rest data))] "export.pdf")))
