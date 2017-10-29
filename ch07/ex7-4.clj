(defmacro unless [test then]
  (list 'if (list 'not test)
        then))


(defmacro unless [test then]
  `(if (not ~test)
     ~then))

(defmacro unless [test then]
  `(if (not ~test)
     then))


(macroexpand '(unless (even? x) (println "Very odd, indeed!")))
;=> (if (clojure.core/not (even? x)) user/then)
