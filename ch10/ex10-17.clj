(ns clj-in-act.ch10.expense-finders-spec
  (:require [clj-in-act.ch10.expense-finders :refer :all]
            [clojure.test :refer :all]))
(deftest test-filter-greater-than
  (let [fetched [{:amount 10.0 :date "2010-02-28"}
                 {:amount 20.0 :date "2010-02-25"}
                 {:amount 30.0 :date "2010-02-21"}]
        filtered (expenses-greater-than fetched 15.0)]
    (is (= (count filtered) 2))
    (is (= (:amount (first filtered)) 20.0))
    (is (= (:amount (last filtered)) 30.0))))


(run-tests 'clj-in-act.ch10.expense-finders-spec)
;; Testing clj-in-act.ch10.expense-finders-spec
;; Audit - called expenses-greater-than with: 15.0

;; Ran 1 tests containing 3 assertions.
;; 0 failures, 0 errors.
;=> {:test 1, :pass 3, :fail 0, :error 0, :type :summary}
