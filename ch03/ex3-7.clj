(defn item-total [price quantity discount-percentage]
  {:pre [(> price 0) (> quantity 0)]
   :post [(> % 0)]}
  (->> (/ discount-percentage 100)
       (- 1)
       (* price quantity)
       float))


(item-total 100 2 0)
;=> 200.0
(item-total 100 2 10)
;=> 180.0


(item-total 100 -2 10)
AssertionError Assert failed: (> quantity 0)  user/item-total (form-init3309134914927218291.clj:1)


(item-total 100 2 110)
