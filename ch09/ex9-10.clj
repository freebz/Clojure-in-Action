(defmacro detail-modus-oerandi [mo-name data-type & fns]
  `(do
     ~@(map #(expand-method mo-name data-type %) fns)))


(defn expand-method [mo-name data-type [method-name & body]]
  `(do
     (alter-var-root (var ~mo-name) update-in
                     [(keyword '~method-name) :implementors] conj ~data-type)
     (defmethod ~method-name ~data-type ~@body)))


(doc alter-var-root)
