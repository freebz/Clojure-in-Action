(def x 1)
;=> #'user/x
(cond
  (> x 0) "greater!"
  (= x 0) "zero!"
  (< x 0) "lesser!")
;=> "greater!"


(+ 1 2 3 4 5)
;=> 15
(+ 1, 2, 3, 4, 5)
;=> 15
(+ 1,2,3,4,5)
;=> 15
(+ 1,,,,,2,3 4,,5)
;=> 15


(def a-map {:a 1 :b 2 :c 3})
;=> #'user/a-map

a-map
{:a 1, :c 3, :b 2}
