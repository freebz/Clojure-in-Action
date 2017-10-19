(defn final-amount [principle rate time-periods]
  (* (Math/pow (+ 1 (/ rate 100)) time-periods) principle))

(final-amount 100 20 1)
;=> 120.0
(final-amount 100 20 20)
;=> 144.0


(defn final-amount-> [principle rate time-periods]
  (-> rate
      (/ 100)
      (+ 1)
      (Math/pow time-periods)
      (* principle)))

(final-amount-> 100 20 1)
;=> 120.0
(final-amount-> 100 20 2)
;=> 144.0
