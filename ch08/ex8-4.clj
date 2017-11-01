(defn price-with-tax [tax-rate amount]
  (->> (/ tax-rate 100)
       (+ 1)
       (* amount)))


(price-with-tax 9.5M 100)
;=> 109.500M


(defn with-california-taxes [prices]
  (map #(price-with-tax 9.25M %) prices))


(def prices [100 200 300 400 500])
;=> #'user/prices
(with-california-taxes prices)
;=> (109.2500M 218.5000M 327.7500M 437.0000M 546.2500M)


(defn price-with-ca-tax [price]
  (price-with-tax 9.25M price))

(defn price-with-ny-tax [price]
  (price-with-tax 8.0M price))


(defn price-calculator-for-tax [state-tax]
  (fn [price]
    (price-with-tax state-tax price)))


(def price-with-ca-tax (price-calulator-for-tax 9.25M))
(def price-with-ny-tax (price-calulator-for-tax 8.0M))
