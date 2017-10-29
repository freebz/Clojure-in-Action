(defmacro assert-true [test-expr]
  (let [[operator lhs rhs] test-expr]
    `(let [rhsv# ~rhs ret# ~test-expr]
       (if-not ret#
         (throw (RuntimeException.
                 (str '~lhs " is not " '~operator " " rhsv#)))
         true))))


(assert-true (= (* 2 4) (/ 16 2)))
;=> true
(assert-true (< (* 2 4) (/ 18 2)))
;=> true

;(assert-true (>= (* 2 4) (/ 18 2)))
; CompilerException java.lang.RuntimeException: (* 2 4) is not >= 9, compiling:(/home/freebz/work/Clojure in Action/ch07/ex7-12.clj:13:1)

(macroexpand-1 '(assert-true (>= (* 2 4) (/ 18 2))))
;=> (clojure.core/let [rhsv__2071__auto__ (/ 18 2)
;                      ret__2072__auto__ (>= (* 2 4) (/ 18 2))]
;     (clojure.core/if-not ret__2072__auto__
;       (throw (java.lang.RuntimeException.
;         (clojure.core/str (quote (* 2 4))
;             " is not " (quote >=) " " rhsv__2071__auto__)))
;       true))


(defmacro assert-true [test-expr]
  (if-not (= 3 (count test-expr))
    (throw (RuntimeException.
            "Argument must be of the form
                  (operator test-expr expected-expr)")))
  (if-not (some #{(first test-expr)} '(< > <= >= = not=))
    (throw (RuntimeException.
            "operator must be one of < > <= >= = not=")))
  (let [[operator lhs rhs] test-expr]
    `(let [rhsv# ~rhs ret# ~test-expr]
       (if-not ret#
         (throw (RuntimeException.
                 (str '~lhs " is not " '~operator " " rhsv#)))
         true))))


(assert-true (<> (* 2 4) (/ 16 2)))
; CompilerException java.lang.RuntimeException: operator must be one of < > <= >= = not=, compiling:(/home/freebz/work/Clojure in Action/ch07/ex7-12.clj:44:1)
