(defmulti affiliate-fee :referrer :default "*")
;=> nil
(ns-unmap 'user 'affiliate-fee)
;=> nil
(defmulti affiliate-fee :referrer :default "*")
;=> #'user/affiliate-fee
(defmethod affiliate-fee "*" [user]
  (fee-amount 0.02M user))
;=> #object[clojure.lang.MultiFn 0x1a658cf "clojure.lang.MultiFn@1a658cf"]
(affiliate-fee example-user)
;=> 20.0000M
