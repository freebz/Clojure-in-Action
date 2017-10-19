(first (list 1 2 3))
;=> 1
(rest (list 1 2 3))
;=> (2 3)
(first [1 2 3])
;=> 1
(rest [1 2 3])
;=> (2 3)
(first {:a 1 :b 2})
;=> [:b 2]
(rest {:a 1 :b 2})
;=> ([:a 1])
(first [])
;=> nil
(rest [])
;=> ()


(cons 1 [2 3 4 5])
;=> (1 2 3 4 5)


(list? (cons 1 (list 2 3)))
;=> false
