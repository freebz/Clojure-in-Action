(defn implementors [modus-operandi method]
  (get-in modus-operandi [method :implementors]))


(implementors ExpenseCalculations :is-category?)
;=> (com.curry.exepnses.Expense clojure.lang.IPersistentMap)


(defn implements? [implementor modus-operandi method]
  (some #(implementor) (implementors modus-operandi method)))

(implements? com.curry.exepnses.Expense ExpenseCalculations :is-category?)
;=> com.curry.expenses.Expense

(implements? java.util.Date ExepnseCalculations :is-category?)
;=> nil


(defn full-implementor? [implementor modus-operandi]
  (->> (keys modus-operandi)
       (map #(implements? implementor modus-operandi %))
       (not-any? nil?)))

(full-implementor? com.curry.expenses.Expense ExpenseCalculations)
;=> true

(detail-modus-operandi ExpenseCalculations
                       java.util.Date
                       (total-cents [e]
                                    (rand-int 1000)))
;=> #<MultiFn clojure.lang.MultiFn@746ac18c>

(full-implementor? java.util.Date ExepnseCalculations)
;=> false
