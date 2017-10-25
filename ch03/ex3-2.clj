(set! *warn-on-reflection* true)
;=> true
(defn string-length [x] (.length x))
Reflection warning, reference to filed length can't be resolved.
;=> #'user/string-length
(time (reduce + (map string-length (repeat 10000 "12345"))))
"Elapsed time: 45.751 msecs"
;=> 50000
(defn fast-string-length [^String x] (.length x))
;=> #'user/fast-string-length
(time (reduce + (map fast-string-length (repeat 10000 "12345"))))
"Elasped time: 5.788 msecs"
;=> 50000
(meta #'fast-string-length)
;=> {:ns #<Namespace user>, :name fast-string-length, :file "NO_SOURCE_FILE",
     :column 1, :line 1, :arglists ([x])}
(meta (first (first {:arglists (meta #'fast-string-length)))))
;=> {:tag String}
