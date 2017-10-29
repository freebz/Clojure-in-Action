(def total-rows (atom 0))

(deref total-rows)
;=> 0

@total-rows
;=> 0

(swap! total-rows + 100)
