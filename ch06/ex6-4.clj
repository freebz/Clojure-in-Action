(def total-cpu-time (agent 0))


(deref total-cpu-time)
;=> 0


@total-cpu-time
;=> 0


(send total-cpu-time + 700)


(deref total-cpu-time)
;=> 700

