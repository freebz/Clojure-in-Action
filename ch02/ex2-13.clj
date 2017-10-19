(defn fact-loop [n]
  (loop [current n fact 1]
    (if (= current 1)
      fact
      (recur (dec current) (* fact current) ))))


(defn fact-loop-invalid [n]
  (loop [current n fact 1]
    (if (= current 1)
      fact
      (recur (dec current) (* fact current)))
    (println "Done, current value:" current)))
CompilerException java.lang.UnsupportedOperationException: Can only recur
from tail position. compiling: (NO_SOURCE_PATH:5:7)


(defn run-report [user]
  (println "Running report for" user))

(defn dispatch-reporting-jobs [all-users]
  (doseq [user all-users]
    (run-report user)))

(dotimes [x 5]
  (println "x is" x))


(map inc [0 1 2 3])
;=> (1 2 3 4)

(map + [0 1 2 3] [0 1 2 3])
;=> (0 2 4 6)
(map + [0 1 2 3] [0 1 2])
;=> (0 2 4)


(defn non-zero-expenses [expenses]
  (let [non-zero? (fn [e] (not (zero? e)))]
    (filter non-zero? expenses)))
;=> #'user/non-zero-expenses
(non-zero-expenses [-2 -1 0 1 2 3])
;=> (-2 1 1 2 3)


(defn non-zero-expenses [expenses]
  (remove zero? expenses))
;=> #'user/non-zero-expenses
(non-zero-expenses [-2 -1 0 1 2 3])
;=> (-2 1 1 2 3)


(defn factorial [n]
  (let [numbers (range 1 (+ n 1)) ]
    (reduce * numbers)))

(range 10)
;=> (0 1 2 3 4 5 6 7 8 9)

(factorial 5)
;=> 120

(defn factorial-steps [n]
  (let [numbers (range 1 (+ n 1))]
    (reductions * numbers)))
;=> #'user/factorial-steps
(factorial-steps 5)
;=> (1 2 6 24 120)
(factorial 1)
;=> 1
(factorial 2)
;=> 2
(factorial 3)
;=> 6
(factorial 4)
;=> 24
(factorial 5)
;=> 120 #A
(map factorial (range 1 6))
;=> (1 2 6 24 120)


(def chessboard-labels
  (for [alpha "abcdefgh"
        num (range 1 9)]
    (str alpha num)))

chessboard-labels
;=> ("a1" "a2" "a3" "a4" "a5" ... "h6" "h7" "h8")


(defn prime? [x]
  (let [divisors (range 2 (inc (Math/sqrt x)))
        remainders (map (fn [d] (rem x d)) divisors)]
    (not (some zero? remainders))))

(defn primes-less-than [n]
  (for [x (range 2 (inc n))
        :when (prime? x)]
    x))

(primes-less-than 50)
;=> (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)

(defn paris-for-primes [n]
  (let [z (range 2 (inc n))]
    (for [x z y z :when (prime? (+ x y))]
      (list x y))))

(paris-for-primes 5)
;=> ((2 3) (2 5) (3 2) (3 4) (4 3) (5 2))
