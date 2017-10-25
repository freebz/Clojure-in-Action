(def myhier (make-hierarchy))
;=> #'user/myhier
myhier
;=> {:parents {}, :descendants {}, :ancestors {}}
(derive myhier :a :letter)
;=> {:parents {:a #{:letter}}, :ancestors {:a #{:letter}}, :descendants {:letter #{:a}}}
myhier
;=> {:parents {}, :descendants {}, :ancestors {}}
(def myhier (-> myhier
                (derive :a :letter)
                (derive :b :letter)
                (derive :c :letter)))
;=> #'user/myhier
(isa? myhier :a :letter)
;=> true
(parents myhier :a)
;=> #{:letter}
(defmulti letter? identity :hierarchy #'myhier)
;=> #'user/letter?
(defmethod letter? :letter [_] true)
;=> #object[clojure.lang.MultiFn 0x1de641a "clojure.lang.MultiFn@1de641a"]
(letter? :d)
; CompilerException java.lang.IllegalArgumentException: No method in multimethod 'letter?' for dispatch value: :d, compiling:(/home/freebz/work/Clojure in Action/ch04/ex4-14.clj:21:1)
(def myhier (derive myhier :d :letter))
;=> #'user/myhier
(letter? :d)
;=> true
