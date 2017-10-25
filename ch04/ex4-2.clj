(def type-namer-implementations
  {java.lang.String              (fn [thing] "string")
   clojure.lang.PersistentVector (fn [thing] "vector")})
;=> #'user/type-namer-implementations
(defn open-ad-hoc-type-namer [thing]
  (let [dispatch-value (type thing)]
    (if-let [implementation
             (get type-namer-implementations dispatch-value)]
      (implementation thing)
      (throw (IllegalArgumentException.
              (str "No implementation found for " dispatch-value))))))
;=> #'user/open-ad-hoc-type-namer
(open-ad-hoc-type-namer "I'm a string")
;=> "string"
(open-ad-hoc-type-namer [])
;=> "vector"
(open-ad-hoc-type-namer {})
; CompilerException java.lang.IllegalArgumentException: No implementation found for class clojure.lang.PersistentArrayMap, compiling:(/home/freebz/work/Clojure in Action/ch04/ex4-2.clj:16:1)
(def type-namer-implementations
  (assoc type-namer-implementations
         clojure.lang.PersistentArrayMap (fn [thing] "map")))
(open-ad-hoc-type-namer {})
;=> "map"
