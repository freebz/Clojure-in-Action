(+ 1 1N)
;=> 2N
(+ 1 1N 1/2)
;=> 5/2
(+ 1 1N 1/2 0.5M)
;=> 3.0M
(+ 1 1N 1/2 0.5M 0.5)
;=> 3.5


(inc 9223372036854775807)
ArithmeticException integer overflow  clojure.lang.Numbers.throwIntOverflow
(Numbers.java:1424)

(inc' 9223372036854775807)
;=> 9223372036854775808





