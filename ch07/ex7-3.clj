(defmacro unless [test then]
  (list 'if (list 'not test)
        then))


(defn exhibits-oddity? [x]
  (unless (even? x)
          (println "Very odd, indeed!")))


(macroexpand
 '(unless (even? x) (println "Very odd, indeed!")))
;=> (if (not (even? x)) (println "Very odd, indeed!"))
