;; Listing 3.4  Dynamic scope in action

(def ^:dynamic *eval-me* 10)
(defn print-the-var [label]
  (println label *eval-me*))
(print-the-var "A:")
(binding [*eval-me* 20] ;; the first binding
  (print-the-var "B:")
  (binding [*eval-me* 30] ;; the second binding
    (print-the-var "C:"))
  (print-the-var "D:"))
(print-the-var "E:")
