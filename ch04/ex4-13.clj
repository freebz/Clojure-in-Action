(prefer-method size-up [:rating/ANY :rating/platinum]
               [:rating/platinum :rating/ANY])
;=> #object[clojure.lang.MultiFn 0x331de7 "clojure.lang.MultiFn@331de7"]
(size-up {:rating :rating/platinum} user-4)
;=> "celeste shimmers with an unearthly light."
(prefers size-up)
;=> {[:rating/ANY :rating/platinum] #{[:rating/platinum :rating/ANY]}}
