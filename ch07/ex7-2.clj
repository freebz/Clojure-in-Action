(defn exhibits-oddity? [x]
  (if (odd? x)
    (println "Very odd!")))


(defn unless [test then]
  (if (not test)
    then))


(defn exhibits-oddity? [x]
  (unless (even? x)
          (println "Very odd, indeed!")))


(exhibits-oddity? 11)
; Very odd, indeed!
;=> nil


(exhibits-oddity? 10)
; Very odd, indeed!
;=> nil


(defn unless [test then-thunk]
  (if (not test)
    (then-thunk)))


(defn exhibits-oddity? [x]
  (unless (even? x)
          #(println "Rather odd!")))


(exhibits-oddity? 11)
; Rather odd!
;=> nil
(exhibits-oddity? 10)
;=> nil
