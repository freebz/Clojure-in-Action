(if (> 5 2)
  "yes"
  "no")
;=> "yes"


(if-not (> 5 2) "yes" "no")
;=> "no"


(def x 1)
;=> #'user/x
(cond
  (> x 0)  "greater!"
  (= x 0)  "zero!"
  :default "lesser!")
;=> "greater!"


(when (> 5 3)
  (println "five")
  (println "is")
  (println "greater")
  "done")
five
is
greater
;=> "done"


(when-not (< 5 2)
  (println "two")
  (println "is")
  (println "smaller")
  "done")
two
is
smaller
;=> "done"
