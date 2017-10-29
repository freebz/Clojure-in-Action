(defmacro unless [test then]
  `(if (not ~test)
     ~then))


(defn exhibits-oddity? [x]
  (unless (even? x)
          (println "Odd!")
          (println "Very odd!")))


(defn exhibits-oddity? [x]
  (unless (even? x)
          (do
            (println "Odd!")
            (println "Very odd!"))))
