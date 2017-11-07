(detail-modus-operandi ExpenseCalculations
   clojure.lang.IPersistentMap
  (total-cents [e]
    (-> (:amount-dollars e)
        (* 100)
        (+ (:amount-cents e))))
  (is-category? [e some-category]
    (= (:category e) some-category)))
;=> #<MuliFn clojure.lang.MultiFn@4aad8dbc>

ExpenseCalculations
;=> {:total-cents {:args [e]}, :is-category? {:args [e category]}}


(detail-modus-operandi ExpenseCalculations
  com.curry.expenses.Expense
  (total-cents [e]
    (.amountInCents e))
  (is-category? [e some-category]
    (= (.getCategory e) some-category)))
;=> #<MultiFn clojure.lang.MultiFn@4aad8dbc>

ExpenseCalculations
