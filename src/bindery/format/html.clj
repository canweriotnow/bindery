(ns bindery.format.html
  (:use hiccup.core)
  (:use bindery.common))

(defn create-table 
  "Create an html table for inline html email."
  [records]
  (let [records records
        column-keys (get-column-keys records)]
    (html 
      [:table {:style "border: 1px solid black;"}
        [:thead {:style "border: 2px solid black; background-color: #aaa;"}
          [:tr
            (for [k column-keys]
              [:th (name k)])]]
        [:tbody
          (for [r records]
            [:tr
              (for [v (get-values-seq r column-keys)]
                [:td {:style "border: 1px solid black"} v ])])]])))