(def adi (atom 0))
(defn on-change [the-key theref old-value new-value]
  (println "Hey, seeing change from" old-value "to" new-value))
(add-watch adi :adi-watcher on-change)


@adi
;=> 0
(swap! adi inc)
; Hey, seeing change from 0 to 1
;=> 1


(remove-watch adi :adi-watcher)
