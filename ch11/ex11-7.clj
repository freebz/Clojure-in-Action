(declare x y)
;=> #'user/y


(make-synonym b binding)
;=> #'user/b


(b [x 10 y 20] [x y])
;=> [10 20]


(b [x 10 y 20] (println "X,Y:" x y))


(binding [x 10 y 20] (println "X,Y:" x y))


(defmacro b [& stuff]
  `(binding ~@stuff))
