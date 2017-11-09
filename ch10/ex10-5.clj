(import '(java.util Calendar))
;=> java.util.Calendar
(.get gc Calendar/DAY_OF_MONTH)
;=> 15


(defn day-from [d]
  (.get d Calendar/DAY_OF_MONTH))


(run-tests 'clj-in-act.ch10.date-operations-spec)



