(ns clj-in-act.ch9.expense-test
  (:require [clj-in-act.ch9.expense :refer :all]
            [clojure.test :refer :all]))
(def clj-expenses [(new-expense "2009-8-20" 21 95 "books" "amazon.com")
                   (new-expense "2009-6-21" 72 43 "food" "mollie-stones")
                   (new-expense "2009-8-22" 315 71 "car-rental" "avis")
                   (new-expense "2009-8-23" 15 68 "books" "borders")])


(deftest test-clj-expenses-total
  (is (= 42577 (total-amount clj-expenses)))
  (is (=  3763 (total-amount (category-is "books") clj-expenses))))


(run-tests 'clj-in-act.ch9.expense-test)
