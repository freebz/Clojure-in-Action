(defn pad [n]
  (if (< n 10) (str "0" n) (str n)))
(defn as-string [date]
  (let [y (year-from date)
        m (pad (month-from date))
        d (pad (day-from date))]
    (str/join "-" [y m d])))


(run-tests 'clj-in-act.ch10.date-operations-spec)
