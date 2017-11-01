(defn method-spec [sexpr]
  (let [name (keyword (second sexpr))
        body (next sexpr)]
    [name (conj body 'fn)]))

(method-spec '(method age [] (* 2 10)))
;=> [:age (fn age [] (* 2 10))]


(defn method-specs [sexprs]
  (->> sexprs
       (filter #(= 'method (first %)))
       (mapcat method-spec)
       (apply hash-map)))

(method-specs '((method age [] (* 2 10))
                (method greet [visitor] (str "Hello there, " visitor))))
;=> {:age (fn age [] (* 2 10)),
;    :greet (fn greet [visitor] (str "Hello there, " visitor))}


(defn new-class [class-name methods]
  (fn klass [command & args]
    (case command
      :name (name class-name)
      :new (new-object klass))))


(defmacro defclass [class-name & specs]
  (let [fns (or (method-specs specs) {})]
    `(def ~class-name (new-class '~class-name ~fns))))



(defclass Person
  (method age []
          (* 2 10))
  (method greet [visitor]
          (str "Hello there, " visitor)))
;=> #'user/Person

