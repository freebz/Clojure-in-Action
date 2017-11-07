(defprotocol ExpenseCalculations
  (total-cents [e])
  (is-category? [e category]))


(extend-protocol ExpenseCalculations
  com.curry.expenses.Expense
  (total-cents [e]
    (.amountInCents e))
  (is-category? [e some-category]
    (= (.getCategory e) some-category)))


(extend-protocol ExpenseCalculations
  clojure.lang.IPersistentMap
  (total-cents [e]
    (-> (:amount-dollars e)
        (* 100)
        (+ (:amount-cents e))))
  (is-category? [e some-category]
    (= (:category e) some-category))
  com.curry.expenses.Expense
  (total-cents [e]
    (.amountInCents e))
  (is-category? [e some-category]
    (= (.getCategory e) some-category)))


(extend-type com.curry.expenses.Expense
  ExpenseCalculations
  (total-cents [e]
    (.amountInCents e))
  (is-category? [e some-category]
    (= (.getCategory e) some-category)))


(extend com.curry.expenses.Expense
  ExpenseCalculations {
                       :total-cents (fn [e]
                                      (.amountInCents e))
                       :is-category? (fn [e some-category]
                                       (= (.getCategory e) some-category))})
