(defn date-operator [operation field]
  (fn [d]
    (doto (.clone d)
      (.add field (operation 1)))))
(def increment-day (date-operator + Calendar/DAY_OF_MONTH))
(def increment-month (date-operator + Calendar/MONTH))
(def increment-year (date-operator + Calendar/YEAR))
(def decrement-day (date-operator - Calendar/DAY_OF_MONTH))
(def decrement-month (date-operator - Calendar/MONTH))
(def decrement-year (date-operator - Calendar/YEAR))
