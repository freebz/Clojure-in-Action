(defn average [numbers]
  (let [total (apply + numbers)]
    (/ total (count numbers))))


(average [])
ArithmeticException Divide by zero  clojure.lang.Numbers.divides
     (Numbers.java:156)


(defn safe-average [numbers]
  (let [total (apply + numbers)]
    (try
      (/ total (count numbers))
      (catch ArithmeticException e
        (println "Divided by zero!")
        0))))
;=> #'user/safe-average


(safe-average [])
Divided by zero!
;=> 0


(try
  (print "Attempting division... ")
  (/ 1 0)
  (catch RuntimeException e "Runtime exception!")
  (catch ArithmeticException e "DIVIDE BY ZERO!")
  (catch Throwable e "Unknown exception encountered!")
  (finally
    (println "done.")))
Attempting division... done.
;=> "Runtime exception!"
(try
  (print "Attempting division... ")
  (/ 1 0)
  (finally
    (println "done.")))
Attempting division... done.
ArithmeticException Divide by zero  clojure.lang.Numbers.divide (Numbers.java:158)


(throw (Exception. "this is an error!"))
Exception this is an error!  user/eval1335 (form-init8727719828158329834.clj:1)
