(defn count-down [n]
  (when-not (zero? n)
    (when (zero? (rem n 100))
      (println "count-down:" n))
    (count-down (dec n))))


(count-down 100000)
count-down: 100000
count-down: 99900
count-down: 99800
...
count-down: 90200
StackOverflowError  clojure.lang.Numbers$LongOps.remainder  (Numbers.java:505)


(defn count-downr [n]
  (when-not (zero? n)
    (if (zero? (rem n 100))
      (println "count-down:" n))
    (recur (dec n))))
