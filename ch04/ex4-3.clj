(defn map-type-namer [thing]
  (condp = (type thing)
    clojure.lang.PersistentArrayMap "map"
    clojure.lang.PersistentHashMap  "map"))
;=> #'user/map-type-namer
(map-type-namer (hash-map))
;=> "map"
(map-type-namer (array-map))
;=> "map"
(map-type-namer (sorted-map))
; CompilerException java.lang.IllegalArgumentException: No matching clause: class clojure.lang.PersistentTreeMap, compiling:(/home/freebz/work/Clojure in Action/ch04/ex4-3.clj:9:1)
(defn subtyping-map-type-namer [thing]
  (cond
    (instance? clojure.lang.APersistentMap thing) "map"
    :else (throw (IllegalArgumentException.
                  (str "No implementation found for ") (type thing)))))
;=> #'user/subtyping-map-type-namer
(subtyping-map-type-namer (hash-map))
;=> "map"
(subtyping-map-type-namer (array-map))
;=> "map"
(subtyping-map-type-namer (sorted-map))
;=> "map"
