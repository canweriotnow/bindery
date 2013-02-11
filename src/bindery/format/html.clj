(ns bindery.formatters.html
  (:use hiccup.core)
  (:use bindery.common))




(defn create-table 
  "Create an html table to send to the lusers."
  [records column-keys header-content & count-string]
  (let [records records
        my-keys column-keys
        header-content header-content
        ent-count (or count-string (str "There are " (count records) " records to display."))]
    (html [:h2 header-content]
          [:h6 ent-count]
          [:table {:style "border: 1px solid black;"}
            [:thead {:style "border: 2px solid black; background-color: #aaa;"}
              [:tr
                (for [k my-keys]
                  [:th (desym k)])]]
            [:tbody
              (for [r records]
                [:tr
                  (for [v (get-values-seq r my-keys)]
                    [:td {:style "border: 1px solid black"} v ])])]])))