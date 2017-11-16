(defmacro anaphoric-if [test-form then-form]
  `(if-let [~'it ~test-form]
     ~then-form))


(defmacro with-it [operator test-form & exprs]
  `(let [~'it ~test-form]
     (~operator ~'it ~@exprs)))


(with-it if (some-computation 12)
  (* 2 it))
;=> nil
(with-it if (some-computation 11)
  (* 2 it))
;=> 24


(with-it and (some-computation 11) (> it 10) (* 2 it))
;=> 24


(with-it when (some-computation 11)
  (println "Got it:" it)
  (* 2 it))
; Got it: 12
;=> 24


(defmacro anaphoric-if [test-form then-form]
  `(with-it if ~test-form ~then-form))
