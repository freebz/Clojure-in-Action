(defmethod affiliate-fee "mint.com" [user]
  (fee-amount 0.03M user))
;=> #object[clojure.lang.MultiFn 0x977360 "clojure.lang.MultiFn@977360"]
(defmethod affiliate-fee "google.com" [user]
  (fee-amount 0.01M user))
;=> #object[clojure.lang.MultiFn 0x119bedd "clojure.lang.MultiFn@119bedd"]
(methods affiliate-fee)
;=> {"mint.com" #object[user$eval1895$fn__1896 0x1ee5c77 "user$eval1895$fn__1896@1ee5c77"], "*" #object[user$eval1889$fn__1890 0x566e16 "user$eval1889$fn__1890@566e16"], "google.com" #object[user$eval1899$fn__1900 0x12febfc "user$eval1899$fn__1900@12febfc"]}
(get-method affiliate-fee "mint.com")
;=> #object[user$eval1948$fn__1949 0xb0de83 "user$eval1948$fn__1949@b0de83"]
(get (methods affiliate-fee) "example.org")
;=> nil
(get-method affiliate-fee "example.org")
;=> #object[user$eval2054$fn__2055 0x450bb9 "user$eval2054$fn__2055@450bb9"]
((get-method affiliate-fee "mint.com") example-user)
;=> 30.0000M
