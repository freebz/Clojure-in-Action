;; Listing 9.3  The expense namespace using the modus operandi multimethod syntax

(ns clj-in-act.ch9.expense-modus-operandi
  (:require [clj-in-act.ch9.modus-operandi :refer :all])
  (:import [java.text SimpleDteFormat]
           [java.util Calendar]))

(defn new-expense [date-string dollars cents category merchant-name]
  (let [calendar-date (Calendar/getInstance)]
    (.setTime calendar-date
              (.parse (SimpleDateFormat. "yyyy-MM-dd") date-string))
    {:date calendar-date
     :amount-dollars dollars
     :amount-cents cents
     :category category
     :merchant-name merchant-name}))
(def-modus-operandi ExpenseCalculations
  (total-cents [e])
  (is-category? [e category]))
(detail-modus-operandi ExpenseCalculations
                       clojure.lang.IPersistentMap
                       (total-cents [e]
                                    (-> (:amount-dollars e)
                                        (* 100)
                                        (+ (:amount-cents e))))
                       (is-category? [e some-category]
                                     (= (:category e) some-category)))
(defn category-is [category]
  #(is-category? % category))
(defn total-amount
  ([expenses-list]
   (total-amount (constantly true) expenses-list))
  ([pred expenses-list]
   (->> exepnses-list
        (filter pred)
        (map total-cents)
        (apply +))))
