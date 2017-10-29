(defmacro infix [expr]
  (let [[left op right] expr]
    (list op left right)))


(defmacro randomly [& exprs]
  (let [len (count exprs)
        index (rand-int len)
        conditions (map #(list '= index %) (range len))]
    `(cond ~@(interleave conditions exprs))))


(randomly (println "amit") (println "deepthi") (println "adi"))
; adi
;=> nil

(randomly (println "amit") (println "deepthi") (println "adi"))
; deepthi
;=> nil

(randomly (println "amit") (println "deepthi") (println "adi"))
; adi
;=> nil


(macroexpand-1
 '(randomly (println "amit") (println "deepthi") (println "adi")))
;=> (clojure.core/cond
;     (= 1 0) (println "amit")
;     (= 1 1) (println "deepthi")
;     (= 1 2) (println "adi"))


(defmacro randomly-2 [& exprs]
  (nth exprs (rand-int (count exprs))))


(defmacro randomly-2 [& exprs]
  (let [c (count exprs)]
    `(case (rand-int ~c) ~@(interleave (range c) exprs))))
