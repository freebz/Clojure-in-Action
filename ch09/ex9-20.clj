(defn new-expense [date-string dollars cents category merchant-name]
  (let [calendar-date (Calendar/getInstance)]
    (.setTime calendar-date
              (.parse (SimpleDateFormat. "yyyy-MM-dd") date-string))
    (reify ExpenseCalculations
      (total-cents [this]
        (-> dollars
            (* 100)
            (+ cents)))
      (is-category? [this some-category]
        (= category some-category)))))
