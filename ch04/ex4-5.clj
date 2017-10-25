(defmulti affiliate-fee (fn [user] (:referrer user)))
;=> #'user/affiliate-fee
(defmethod affiliate-fee "mint.com" [user]
  (fee-amount 0.03M user))
;=> #object[clojure.lang.MultiFn 0x4c41ee "clojure.lang.MultiFn@4c41ee"]
(defmethod affiliate-fee "google.com" [user]
  (fee-amount 0.01M user))
;=> #object[clojure.lang.MultiFn 0x986b73 "clojure.lang.MultiFn@986b73"]
(defmethod affiliate-fee :default [user]
  (fee-amount 0.02M user))
;=> #object[clojure.lang.MultiFn 0xe78574 "clojure.lang.MultiFn@e78574"]
(affiliate-fee example-user)
;=> 30.0000M
