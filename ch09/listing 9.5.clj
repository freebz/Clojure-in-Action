;; Listing 9.5  expense namespace using a Clojure protocol

(ns clj-in-act.ch9.expense-protocol
  (:import [java.text SimpleDateFormat]
           [java.util Calendar]))
(defn new-expense [date-string dollars cents category merchant-name]
  (let [calendar-date (Calendar/getInstance)]
    (.setTime calendar-date (.parse (SimpleDateFormat. "yyyy-MM-dd")
                                    date-string))
    {:date calendar-date
     :amount-dollars dollars
     :amount-cents cents
     :category category
     :merchant-name merchant-name}))
(defprotocol ExepnseCalculations
  (total-cents [e])
  (is-category? [e category]))
(extend-protocol ExpenseCalculations
  clojure.lang.IPersistentMap
  (total-cents [e]
    (-> (:amount-dollars e)
        (* 100)
        (+ (:amount-cents e))))
  (is-category? [e some-category]
    (= (:category e) some-category)))
(extend-protocol ExepnseCalculations
  com.curry.expenses.Expense
  (total-cents [e]
    (.amountInCents e))
  (is-category? [e some-category]
    (= (.getCategory e) some-category)))
(defn category-is [category]
  #(is-category? % category))
(defn total-amount
  ([expenses-list]
   (total-amount (constantly true) expenses-list))
  ([pred expenses-list]
   (->> expenses-list
        (filter pred)
        (map total-cents)
        (apply +))))
