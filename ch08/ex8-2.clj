(defn total-of [numbers]
  (loop [nums numbers sum 0]
    (if (empty? nums)
      sum
      (recur (rest nums) (+ sum (first nums))))))


(total-of [5 7 9 3 4 1 2 8])
;=> 39


(defn larger-of [x y]
  (if (> x y) x y))


(defn largest-of [numbers]
  (loop [l numbers candidate (first numbers)]
    (if (empty? l)
      candidate
      (recur (rest l) (larger-of candidate (first l))))))


(largest-of [5 7 9 3 4 1 2 8])
;=> 9
(largest-of [])
;=> nil


(defn compute-across [func elements value]
  (if (empty? elements)
    value
    (recur func (rest elements) (func value (first elements)))))


(defn total-of [numbers]
  (compute-across + numbers 0))
(defn largest-of [numbers]
  (compute-across larger-of numbers (first numbers)))


(total-of [5 7 9 3 4 1 2 8])
;=> 39
(largest-of [5 7 9 3 4 1 2 8])
;=> 9


(defn all-greater-than [threshold numbers]
  (compute-across #(if (> %2 threshold) (conj %1 %2) %1) numbers []))

(all-greater-than 5 [5 7 9 3 4 1 2 8])
;=> [7 9 8]


(defn all-greater-than [threshold numbers]
  (reduce #(if (> %2 threshold) (conj %1 %2) %1) [] numbers))

(all-greater-than 5 [5 7 9 3 4 1 2 8])
;=> [7 9 8]
