;; Listing 3.2  Mutually recursive functions that can be called with trampoline

(declare hatt)
(defn catt [n]
  (when-not (zero? n)
    (when (zero? (rem n 100))
      (println "catt:" n))
    (fn [] (hatt (dec n)))))

(defn hatt [n]
  (when-not (zero? n)
    (when (zero? (rem n 100))
      (println "hatt:" n))
    (fn [] (catt (dec n)))))
