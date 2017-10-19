(and)
;=> true
(and :a :b :c)
;=> :c
(and :a nil :c)
;=> nil
(and :a false :c)
;=> false
(and 0 "")
;=> ""


(or)
;=> nil
(or :a :b :c)
;=> :a
(or :a nil :c)
;=> :a
(or nil false)
;=> false
(or false nil)
;=> nil


(not true)
;=> false
(not 1)
;=> false
(not nil)
;=> true


(< 2 4 6 8)
;=> true

(< 2 4 3 8)
;=> false


(= 1 1N 1/1)
;=> true
(= 0.5 1/2)
;=> false
(= 0.5M 0.5)
;=> false
(= 0.5M 1/2)
;=> false


(== 1 1N 1/1)
;=> true
(== 1/2 0.5M 0.5)
;=> true
1.9999999999999999
;=> 2.0
(== 2.0M 1.9999999999999999)
;=> true
(== :a 1)
ClassCastException clojure.lang.Keyword cannot be cast to
java.lang.Number  clojure.lang.Numbers.equiv  (Numbers.java:206)
(== nil 1)
NullPointerException   clojure.lang.Numbers.ops (Numbers.java:961)
