(vector 10 20 30 40 50)
;=> [10 20 30 40 50]
(def the-vector [10 20 30 40 50])
;=> #'user/the-vector


(get the-vector 2)
;=> 30
(nth the-vector 2)
;=> 30
(get the-vector 10)
;=> nil
(nth the-vector 10)
IndexOutOfBoundsException   clojure.lang.PersistentVector.arrayFor (Persis-
tentVector.java:107)                                                                    


(assoc the-vactor 2 25)
;=> [10 20 25 40 50]
(assoc the-vector 5 60)
;=> [10 20 30 40 50 60]
(assoc the-vector 6 70)
IndexOutOfBoundsException   clojure.lang.PersistentVector.assocN
(PersistentVector.java:137)


(conj [1 2 3 4 5] 6)
;=> [1 2 3 4 5 6]


(peek [1 2])
;=> 2
(pop [1 2])
;=> [1]
(peek [])
;=> nil
(pop [])
IllegalStateException Can't pop empty vector
clojure.lang.PersistentVector.pop (PersistentVector.java:381)


(the-vector 3)
;=> 40
