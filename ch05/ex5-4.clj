(import '(java.util Calendar TimeZone))
;=> java.util.TimeZone
(. (. (Calendar/getInstance) (getTimeZone)) (getDisplayName))
;=> "Pacific Standard Time"

(. (. (Calendar/getInstance) getTimeZone) getDisplayName)


(.. (Calendar/getInstance) (getTimeZone) (getDisplayName))


(.. (Calendar/getInstance) getTimeZone getDisplayName)


(.. (Calendar/getInstance)
    getTimeZone
    (getDisplayName true TimeZone/SHORT))
