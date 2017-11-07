(defn expand-method [data-type [name & body]]
  `(defmethod ~name ~data-type ~@body))
(defmacro detail-modus-operandi [mo-name data-type & fns]
  `(do
     ~@(map #(expand-method data-type %) fns)))


(detail-modus-operandi ExpenseCalculations
  clojure.lang.IPersistentMap
  (total-cents [e]
    (-> (:amount-dollars e)
        (* 100)
        (+ (:amount-cents e))))
  (is-category? [e some-category]
    (= (:category e) some-category)))


(do
  (clojure.core/defmethod total-cents clojure.lang.IPersistentMap [e]
    (-> (:amount-dollars e)
        (* 100)
        (+ (:amount-cents e))))
  (clojure.core/defmethod is-category?
      clojure.lang.IPersistentMap [e some-category]
    (= (:category e) some-category)))
