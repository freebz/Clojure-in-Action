(import '(java.text SimpleDateFormat))
;=> java.text.SimpleDateFormat
(def f (SimpleDateFormat. "yyyy-MM-dd"))
;=> #'user/f
(.parse f "2010-08-15")
;=> #inst "2010-08-14T15:00:00.000-00:00"


(import '(java.util GregorianCalendar))
;=> java.util.GregorianCalendar
(def gc (GregorianCalendar.))
;=> #'user/gc


(def d (.parse f "2010-08-15"))
;=> #'user/d
(.setTime gc d)
;=> nil
