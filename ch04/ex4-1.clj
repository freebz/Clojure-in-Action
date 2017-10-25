(defn ad-hoc-type-namer [thing]
  (condp = (type thing)
    java.lang.String              "string"
    clojure.lang.PersistentVector "vector"))
;=> #'user/ad-hoc-type-namer
(ad-hoc-type-namer "I'm a string")
;=> "string"
(ad-hoc-type-namer [])
;=> "vector"
(ad-hoc-type-namer {})
; IllegalArgumentException: No matching clause: class clojure.lang.PersistentArrayMap, compiling:(/home/freebz/work/Clojure in Action/ch04/ex4-1.clj:9:1)
