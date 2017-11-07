(class nil)
;=> nil

(extend-protocol ExpenseCalculations nil
                 (total-cents [e] 0))


(extends? ExpenseCalculations com.curry.expenses.Expense)
;=> true
(extends? ExpenseCalculations clojure.lang.IPersistentMap)
;=> true
(extends? ExpenseCalculations java.util.Date)
;=> false


(extenders ExpenseCalculations)
;=> (com.curry.expenses.Expense clojure.lang.IPersistentMap)


(satisfies? ExpenseCalculations (com.curry.expenses.Expense. "10-10-2010" 20 95 "books" "amzn"))
;=> true
(satisfies? ExpenseCalculations (new-expense "10-10-2010" 20 95 "books" "amzn"))
;=> true
(satisfies? ExpenseCalculations (java.util.Random.))
;=> false
