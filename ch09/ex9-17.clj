(defrecord Foo [a b])
;=> user.Foo
(def foo (->Foo 1 2))
;=> #'user/foo
(assoc foo :extra-key 3)
;=> #user.Foo{:a 1, :b 2, :extra-key 3}
(dissoc (assoc foo :extra-key 3) :extra-key)
;=> #user.Foo{:a 1, :b 2}
(dissoc foo :a)
;=> {:b 2}
(foo :a)
; CompilerException java.lang.ClassCastException: user.Foo (in module: Unnamed Module) cannot be cast to clojure.lang.IFn (in module: Unnamed Module), compiling:(/home/freebz/work/Clojure in Action/ch09/expense/../ex9-17.clj:10:1)
