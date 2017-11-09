(defn calc-x [x1 x2]
  (* x1 x2))
(defn calc-y [y1 y2]
  (/ y2 y1))
(defn some-client []
  (println (calc-x 2 3) (calc-y 3 4)))


(some-client)
; 6 4/3
;=> nil


(stubbing [calc-x 1
           calc-y 2]
          (some-client))
; 1 2
;=> nil


(macroexpand-1 '(stubbing [calc-x calc-y 2]
                          (some-client)))
;=> (clojure.core/with-redefs [calc-x (constantly 1)
;                              calc-y (constantly 2)]
;     (some-client))
