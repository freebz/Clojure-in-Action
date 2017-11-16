(defmacro single-arg-fn [binding-form & body]
  `((fn [~(first binding-form)] ~@body) ~(second binding-form)))

(defmacro my-let [lettings & body]
  (if (empty? lettings)
    `(do ~@body)
    `(single-arg-fn ~(take 2 lettings)
                    (my-let ~(drop 2 lettings) ~@body))))


(my-let [x 10
         y x
         z (+ x y)]
        (* x y z))
;=> 2000


(my-let [[a b] [2 5]
         {:keys [x y]} {:x (* a b) :y 20}
         z (+ x y)]
        (println "a,b,x,y,z:" a b x y z)
        (* x y z))
; a,b,x,y,z: 2 5 10 20 30
;=> 6000
