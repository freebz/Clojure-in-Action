(defn all-lesser-than [threshold numbers]
  (compute-across #(if (< %2 threshold) (conj %1 %2) %1) numbers []))

(all-lesser-than 5 [5 7 9 3 4 1 2 8])
;=> [3 4 1 2]


(defn select-if [pred elements]
  (compute-across #(if (pred %2) (conj %1 %2) %1) elements []))

(select-if odd? [5 7 9 3 4 1 2 8])
;=> [5 7 9 3 1]


(defn all-lesser-than [threshold numbers]
  (select-if #(< % threshold) numbers))

(filter odd? [5 7 9 3 4 1 2 8])
;=> (5 7 9 3 1)
