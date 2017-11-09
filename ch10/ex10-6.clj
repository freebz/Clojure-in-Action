(deftest test-simple-data-parsing
  (let [d (date "2009-01-22")]
    (is (= (month-from d) 1))
    (is (= (day-from d) 22))
    (is (= (year-from d) 2009))))


(defn month-from [d]
  (inc (.get d Calendar/MONTH)))
(defn year-from [d]
  (.get d Calendar/YEAR))

(run-tests 'clj-in-act.ch10.date-operations-spec)
