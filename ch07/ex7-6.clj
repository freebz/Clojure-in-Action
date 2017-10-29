(defmacro unless [test & exprs]
  `(if (not ~test)
     (do ~exprs)))


(defn exhibits-oddity? [x]
  (unless (even? x)
          (println "Odd!")
          (println "Very odd!")))


;(exhibits-oddity? 11)
; Odd!
; Very odd!
; CompilerException java.lang.NullPointerException, compiling:(/home/freebz/work/Clojure in Action/ch07/ex7-6.clj:12:1)


(macroexpand-1 '(unless (even? x)
                        (println "Odd!")
                        (println "Very odd!")))
;=> (if (clojure.core/not (even? x))
;     (do ((println "Odd!") (println "Very odd!"))))


(defmacro unless [test & exprs]
  `(if (not ~test)
     (do ~@exprs)))
