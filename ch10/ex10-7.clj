(deftest test-as-string
  (let [d (date "2009-01-22")]
    (is (= (as-string d) "2009-01-22"))))


(require '[clojure.string :as str])
(defn as-string [date]
  (let [y (year-from date)
        m (month-from date)
        d (day-from date)]
    (str/join "-" [y m d])))


(def d (clj-in-act.ch10.date-operations/date "2010-12-25"))
;=> #'user/d
(as-string d)
;=> "2010-12-25"


(run-tests 'clj-in-act.ch10.date-operations-spec)
