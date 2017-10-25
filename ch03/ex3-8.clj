(defn function-name
  ;; Note that each argument+body pair is enclosed in a list.
  ([arg1]      body-executed-for-one-argument-call)
  ([arg1 arg2] body-executed-for-two-argument-call)
  ;; MOre cases my follow.
  )


(defn total-cost
  ([item-cost number-of-items]
   (* item-cost number-of-items))
  ([item-cost]
   (total-cost item-cost 1)))


(defn many-arities
  ([]             0)
  ([a]            1)
  ([a b c]        3)
  ([a b c & more] "variadic"))
;=> #'user/many-arities
(many-arities)
;=> 0
(many-arities "one argument")
;=> 1
(many-arities "two" "arguments")
ArityException Wrong number of args (2) passed to: user/many-arities  clojure.lang.AFn.throwArity (AFn.java:429)
(myfn-attr-map "three" "argu-" "ments")
;=> 3
(many-arities "many" "more" "argu-" "ments")
;=> "variadic"
