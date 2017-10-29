(ref-set all-users {})
; CompilerException java.lang.IllegalStateException: No transaction running, compiling:(/home/freebz/work/Clojure in Action/ch06/ex6-2.clj:1:1)


(dosync
 (ref-set all-users {}))
;=> {}
