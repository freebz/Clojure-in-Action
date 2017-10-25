(load-file "listing 3.3.clj")

(def total-cost
  (fn [item-cost number-of-items]
    (* item-cost number-of-items)))


(map (fn [user] (user :member-since)) users)
;=> ("2009-04-16" "2009-02-01" "2009-03-30")


(map #(% :member-since) users)
;=> ("2009-04-16" "2009-02-01" "2009-03-30")


(#(vector %&) 1 2 3 4 5)
;=> [(1 2 3 4 5)]
(#(vector % %&) 1 2 3 4 5)
;=> [1 (2 3 4 5)]
(#(vector %1 %2 %&) 1 2 3 4 5)
;=> [1 2 (3 4 5)]
(#(vector %1 %2 %&) 1 2)
;=> [1 2 nil]
