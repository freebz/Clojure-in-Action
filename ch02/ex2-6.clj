(list 1 2 3 4 5)
;=> (1 2 3 4 5)
(list? *1)
;=> true


(conj (list 1 2 3 4 5) 6)
;=> (6 1 2 3 4 5)


(conj (list 1 2 3) 4 5 6)
;=> (6 5 4 1 2 3)
(conj (conj (conj (list 1 2 3) 4) 5) 6)
;=> (6 5 4 1 2 3)


(peek (list 1 2 3))
;=> 1
(pop (list 1 2 3))
;=> (2 3)
(peek (list))
;=> nil
(pop (list))
IllegalStateException Can't pop empty list
clojure.lang.PersistentList$EmptyList.pop (PersistentList.java:183)


(count (list))
;=> 0
(count (list 1 2 3 4))
;=> 4


(+ 1 2 3)


(def three-numbers (1 2 3))
; CompilerException java.lang.ClassCastException: java.lang.Long cannot be
cast to clojure.lang.IFn,  compiling:(NO_SOURCE_FILE:1)



(def three-numbers '(1 2 3))
;=> #'user/three-numbers
