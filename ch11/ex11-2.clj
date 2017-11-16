(defn some-computation [x]
  (if (even? x) false (inc x)))


(if (some-computation 11)
  (* 2 (some-computation 11)))
;=> 24


(let [computation (some-computation 11)]
  (if computation
    (* 2 computation)))


(if-let [computation (some-computation 11)]
  (* 2 computation))


(defmacro anaphoric-if [test-form then-form]
  `(if-let [~'it ~test-form]
     ~then-form))


(anaphoric-if (some-computation 11)
              (* 2 it))


(macroexpand-1 '(anaphoric-if (some-computation 11)
                              (* 2 it)))
;=> (clojure.core/if-let [it (some-computation 11)] (* 2 it))


(anaphoric-if (some-computation 12)
              (* 2 it))
;=> nil
(anaphoric-if (some-computation 11)
              (* 2 it))
;=> 24
