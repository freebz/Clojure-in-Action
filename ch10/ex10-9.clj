(deftest test-incrementing-date
  (let [d (date "2009-10-31")
        n-day (increment-day d)]
    (is (= (as-string n-day) "2009-11-01"))))


(def d (date "2009-10-31"))
;=> #'user/d
(.add d Calendar/DAY_OF_MONTH 1)
;=> nil
(as-string d)
;=> "2009-11-01"


(deftest test-incrementing-date
  (let [d (date "2009-10-31")
        n-day (increment-day d)
        n-month (increment-month d)
        n-year (increment-year d)]
    (is (= (as-string n-day) "2009-11-01"))
    (is (= (as-string n-month) "2009-11-30"))
    (is (= (as-string n-year) "2010-10-31"))))


(defn increment-month [d]
  (doto d
    (.add Calendar/MONTH 1)))
(defn increment-year [d]
  (doto d
    (.add Calendar/YEAR 1)))


(run-tests 'clj-in-act.ch10.date-operations-spec)


