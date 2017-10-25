(remove-method profit-based-affiliate-fee ["mint.com" :rating/gold])
;=> #object[clojure.lang.MultiFn 0x67f392 "clojure.lang.MultiFn@67f392"]
(remove-method profit-based-affiliate-fee ["mint.com" :rating/platinum])
;=> #object[clojure.lang.MultiFn 0x67f392 "clojure.lang.MultiFn@67f392"]
(remove-method profit-based-affiliate-fee ["google.com" :rating/gold])
;=> #object[clojure.lang.MultiFn 0x67f392 "clojure.lang.MultiFn@67f392"]
(remove-method profit-based-affiliate-fee ["google.com" :rating/platinum])
;=> #object[clojure.lang.MultiFn 0x67f392 "clojure.lang.MultiFn@67f392"]
(defmethod profit-based-affiliate-fee ["mint.com" :rating/premier]
  [user] (fee-amount 0.05M user))
;=> #object[clojure.lang.MultiFn 0x67f392 "clojure.lang.MultiFn@67f392"]
(defmethod profit-based-affiliate-fee ["google.com" :rating/premier]
  [user] (fee-amount 0.03M user))
;=> #object[clojure.lang.MultiFn 0x67f392 "clojure.lang.MultiFn@67f392"]
(map profit-based-affiliate-fee [user-1 user-2 user-3 user-4])
;=> (30.0000M 32.0000M 27.0000M 14.0000M)
