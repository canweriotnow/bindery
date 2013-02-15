(ns bindery.format.excel
  (:use dk.ative.docjure.spreadsheet)
  (:use bindery.common))

(defn create-xlsx [wb-name data]
  (let [
        wb (create-workbook wb-name
              (data->nested-vec data))
        sheet (select-sheet wb-name wb)
        header-row (first (row-seq sheet))]
    (do 
      (set-row-style! header-row (create-cell-style! wb {:background :yellow, :font {:bold true}}))
      (save-workbook! (str wb-name ".xlsx") wb))))

