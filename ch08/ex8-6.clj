(defn select-if [pred elements]
  (compute-across #(if (pred %2) (conj %1 %2) %1) elements []))


(defn select-into-if [container pred elements]
  (compute-across #(if (pred %2) (conj %1 %2) %1) elements container))


(def numbers [4 9 5 7 6 3 8])


(select-into-if [] #(< % 7) numbers)
;=> [4 5 6 3]


(select-into-if () #(< % 7) numbers)
;=> (3 6 5 4)


(def select-up (partial select-into-if []))


(def select-down (partial select-into-if ()))


(select-up #(< % 9) [5 3 9 6 8])
;=> [5 3 6 8]
(select-down #(< % 9) [5 3 9 6 8])
;=> (8 6 3 5)
