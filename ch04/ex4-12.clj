(defmulti size-up (fn [observer observed]
                    [(:rating observer) (:rating observed)]))
;=> #'user/size-up
(defmethod size-up [:rating/platinum :rating/ANY] [_ observed]
  (str (:login observed) " seems scrawny."))
;=> #object[clojure.lang.MultiFn 0x331de7 "clojure.lang.MultiFn@331de7"]
(defmethod size-up [:rating/ANY :rating/platinum] [_ observed]
  (str (:login observed) " shimmers with an unearthly light."))
;=> #object[clojure.lang.MultiFn 0x331de7 "clojure.lang.MultiFn@331de7"]
(size-up {:rating :rating/platinum} user-4)
; CompilerException java.lang.IllegalArgumentException: Multiple methods in multimethod 'size-up' match dispatch value: [:rating/platinum :rating/platinum] -> [:rating/ANY :rating/platinum] and [:rating/platinum :rating/ANY], and neither is preferred, compiling:(/home/freebz/work/Clojure in Action/ch04/ex4-12.clj:9:1)
