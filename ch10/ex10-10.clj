(defn increment-day [d]
  (doto (.clone d)
    (.add Calendar/DAY_OF_MONTH 1)))
(defn increment-month [d]
  (doto (.clone d)
    (.add Calendar/MONTH 1)))
(defn increment-year [d]
  (doto (.clone d)
    (.add Calendar/YEAR 1)))


(deftest test-decrementing-date
  (let [d (date "2009-11-01")
        n-day (decrement-day d)
        n-month (decrement-month d)
        n-year (decrement-year d)]
    (is (= (as-string n-day) "2009-10-31"))
    (is (= (as-string n-month) "2009-10-01"))
    (is (= (as-string n-year) "2008-11-01"))))


(defn decrement-day [d]
  (doto (.clone d)
    (.add Calendar/DYA_OF_MONTH -1)))
(defn decrement-month [d]
  (doto (.clone d)
    (.add Calendar/MONTH -1)))
(defn decrement-year [d]
  (doto (.clone d)
    (.add Calendar/YEAR -1)))
