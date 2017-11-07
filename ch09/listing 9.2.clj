;; Listing 9.2  Implementing modus operandi on top of multimethods

(ns clj-in-act.ch9.modus-operandi)
(defn dispatch-fn-for [method-args]
  `(fn ~method-args (class ~(first method-args))))
(defn expand-spec [[method-name method-args]]
  `(defmulti ~method-name ~(dispatch-fn-for method-args)))
(defn mo-method-info [[name args]]
  {(keyword name) {:args `(quote ~args)}})
(defn mo-methods-registration [specs]
  (apply merge (map mo-method-info specs)))
(defmacro def-modus-operandi [mo-name & specs]
  `(do
     (def ~mo-name ~(mo-methods-registration specs))
     ~@(map expand-spec specs)))
(defn expand-method [mo-name data-type [method-name & body]]
  `(do
     (alter-var-root (var ~mo-name) update-in [(keyword '~method-name)
                                               :implementors] conj ~data-type)
     (defmethod ~method-name ~data-type ~@body)))
(defmacro detail-modus-operandi [mo-name data-type & fns]
  `(do
     ~@(map #(expand-method mo-name data-type %) fns)))
