(ns clj-in-act.ch9.expense-test
  (:import [com.curry.expenses Expense]))


(def java-expenses [(Expense. "2009-8-24" 44 95 "books" "amazon.com")
                    (Expense. "2009-8-25" 29 11 "gas" "shell")])
(deftest test-java-expenses-total
  (let [total-cents (map #(.amountInCents %) java-expenses)]
    (is (= 7406 (apply + total-cents)))))


(run-tests 'clj-in-act.ch9.expense-test)
