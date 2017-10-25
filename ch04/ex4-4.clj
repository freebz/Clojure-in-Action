(def example-user {:login "rob" :referrer "mint.com" :salary 100000})
;=> #'user/example-user
(defn fee-amount [percentage user]
  (with-precision 16 :rounding HALF_EVEN
    (* 0.01M percentage (:salary user))))
;=> #'user/fee-amount
(defn affiliate-fee [user]
  (case (:referrer user)
    "google.com" (fee-amount 0.01M user)
    "mint.com"   (fee-amount 0.03M user)
    (fee-amount 0.02M user)))
;=> #'user/affiliate-fee
(affiliate-fee example-user)
;=> 30.0000M
