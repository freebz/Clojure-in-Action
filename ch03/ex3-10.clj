(+ 1 2 3 4 5)
;=> 15


(def bools [true true true false false])
;=> #'user/bools
(every? true? bools)
;=> false

(some (fn [p] (= "rob" p)) ["kyle" "siva" "rob" "celeste"])
;=> true 


(def two (constantly 2)) ; same as (def two (fn [& more] 2))
                         ; or      (defn two [& more] 2)
;=> #'user/two
(two 1)
;=> 2
(two :a :b :c)
;=> 2


(defn greater? [x y]
  (> x y))

(greater? 10 5)
;=> true
(greater? 10 20)
;=> false


(def smaller? (complement greater?))

(smaller? 10 5)
;=> false

(smaller? 10 20)
;=> true


(def opp-zero-str (comp str not zero?))

(opp-zero-str 0)
;=> "false"

(opp-zero-str 1)
;=> "true"


(defn above-threshold? [threshold number]
  (> number threshold))

(filter (fn [x] (above-threshold? 5 x)) [ 1 2 3 4 5 6 7 8 9])
;=> (6 7 8 9)

(filter (partial above-threshold? 5) [ 1 2 3 4 5 6 7 8 9])
;=> (6 7 8 9)


(defn slow-calc [n m]
  (Thread/sleep 1000)
  (* n m))

(time (slow-calc 5 7))
"Elapsed time: 1000.097 msecs"
;=> 35


(def fast-calc (memoize slow-calc))

(time (fast-calc 5 7))
"Elapsed time: 0.035 msecs"
;=> 35
