(defrecord NewExpense [date amount-dollars amount-cents category
                       merchant-name]
  ExpenseCalculations
  (total-cents [this]
    (-> amount-dollars
        (* 100)
        (+ amount-cents)))
  (is-category? [this some-category]
    (= category some-category)))
