(ns bindery.format.excel
  (:use [[dk.aktive.docjure.spreadsheet]
         [bindery.common]]))

(defn create-xls [wb-name data]
  (let [wb (create-workbook wb-name
              [])]))

