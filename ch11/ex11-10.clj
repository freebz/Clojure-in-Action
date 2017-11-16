(defmacro defsegment [segment-name & body])


(defsegment googling-clojurians
  (and
   (> (count $search-terms) 0)
   (matches? $url-referrer "google")))


(defsegment loyal-safari
  (and
   (empty? $url-referrer)
   (= :safari $user-agent)))
