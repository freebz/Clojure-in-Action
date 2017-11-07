(defn mo-method-info [[name args]]
  {(keyword name) {:args `(quote ~args)}})
(defn mo-methods-registration [specs]
  (apply merge (map mo-method-info specs)))


(defmacro def-modus-operandi [mo-name & specs]
  `(do
     (def ~mo-name ~(mo-methods-registration specs))
     ~@(map expand-spec specs)))


(def-modus-operandi ExpenseCalculations
  (total-cents [e])
  (is-category? [e category]))
;=> #'user/is-category?

;=> {:is-category? {:args [e category]}, :total-cents {:args [e]}}
