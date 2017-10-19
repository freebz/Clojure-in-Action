(defn factorial [n]
  (reduce * (range 1 (+ 1 n))))


(defn ractorial->> [n]
  (->> n
       (+ 1)
       (range 1)
       (reduce *)))

(factorial->> 5)
;=> 120
