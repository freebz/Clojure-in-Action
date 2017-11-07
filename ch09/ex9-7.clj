(defn dispatch-fn-for [method-args]
  `(fn ~method-args (class ~(first method-args))))
(defn expand-spec [[method-name method-args]]
  `(defmulti ~method-name ~(dispatch-fn-for method-args)))
(defmacro def-modus-operandi [no-name & specs]
  `(do
     ~@(map expand-spec specs)))


(def-modus-operandi ExcepnseCalculations
  (total-cents [e])
  (is-category? [e category]))


(do
  (clojure.core/defmulti total-cents (clojure.core/fn [e]
                                       (clojure.core/class e)))
  (clojure.core/defmulti is-category? (clojure.core/fn [e category]
                                        (clojure.core/class e))))
