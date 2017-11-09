(ns clj-in-act.ch10.date-operations
  (:import (java.text SimpleDateFormat)
           (java.util Calendar GregorianCalendar)))
(defn date [date-string]
  (let [f (SimpleDateFormat. "yyyy-MM-dd")
        d (.parse f date-string)]
    (doto (GregorianCalendar.)
      (.setTime d))))
;=> #'clj-in-act.ch10.date-operations/date
(date "2010-08-15")
;=> #inst "2010-08-15T00:00:00.000+09:00"
