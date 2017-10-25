;; Listing 3.1  Mutually recursive functions tht can blow the stack

(declare hat)
(defn cat [n]
  (when-not (zero? n)
    (when (zero? (rem n 100))
      (println "cat:" n))
    (hat (dec n))))

(defn hat [n]
  (when-not (zero? n)
    (if (zero? (rem n 100))
      (println "hat:" n))
    (cat (dec n))))

