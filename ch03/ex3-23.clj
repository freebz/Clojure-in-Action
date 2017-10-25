(defn print-amounts [[amount-1 amount-2]]
  (println "amounts are:" amount-1 "and" amount-2))
(print-amounts [10.95 31.45])
; amounts are: 10.95 and 31.45


(defn print-amounts-multiple [[amount-1 amount-2 & remaining]]
  (println "Amounts are:" amount-1 "," amount-2 "and" remaining))

(print-amounts-multiple [10.95 31.45 22.36 2.95])
; Amounts are: 10.95 , 31.45 and (22.36 2.95)


(defn print-all-amounts [[amount-1 amount-2 & remaining :as all]]
  (println "Amounts are:" amount-1 "," amount-2 "and" remaining)
  (println "Also, all the amounts are:" all))

(print-all-amounts [10.95 31.45 22.36 2.95])
; Amounts are: 10.95 , 31.45 and (22.36 2.95)
; Also, all the amounts are: [10.95 31.45 22.36 2.95]


(defn print-first-category [[[category amount] & _ ]]
  (println "First category was:" category)
  (println "First amount was:" amount))

(def expenses [[:books 49.95] [:coffee 4.95] [:caltrain 2.25]])
(print-first-category expenses)
; First category was: :books
; First amount was: 49.95
