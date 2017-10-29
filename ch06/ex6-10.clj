(defn long-calculation [num1 num2]
  (Thread/sleep 5000)
  (* num1 num2))


(defn long-run []
  (let [x (long-calculation 11 13)
        y (long-calculation 13 17)
        z (long-calculation 17 19)]
    (* x y z)))


(time (long-run))
; "Elapsed time: 15000.887777 msecs"
;=> 10207769


(defn fast-run []
  (let [x (future (long-calculation 11 13))
        y (future (long-calculation 13 17))
        z (future (long-calculation 17 19))]
    (* @x @y @z)))


(time (fast-run))
; "Elapsed time: 5001.808884 msecs"
;=> 10207769
