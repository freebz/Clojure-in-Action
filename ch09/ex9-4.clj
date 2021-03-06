(ns clj-in-act.ch9.expense-test)


(def mixed-expenses (concat clj-expenses java-expenses))
(deftest test-mixed-expenses-total
  (is (= 49983 (total-amount mixed-expenses)))
  (is (= 8258 (total-amount (category-is "books") mixed-expenses))))


(run-tests 'clj-in-act.ch9.expense-test)
