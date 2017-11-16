(doc postwalk)


(defn transform-lookups [dollar-attribute]
  (let [prefixed-string (str dollar-attribute)]
    (if-not (.staratsWith prefixed-string "$")
      dollar-attribute
      (session-lookup prefixed-string))))


(defn drop-first-char [name]
  (apply str (rest name)))
(defn session-lookup [dollar-name]
  (->> (drop-first-char dollar-name)
       (keyword)
       (list '*session*)))


(transform-lookups '$user-agent)
;=> (*session* :user-agent)


(postwalk transform-lookups '(> (count $search-terms) 0))
;=> (> (count (*session* :search-terms)) 0)


(defmacro defsegment [segment-name & body]
  (let [transformed (postwalk transform-lookups body)]))


(postwalk transform-lookups '(and
                              (> (count $search-terms) 0)
                              (= :safari $user-agent)))
;=> (and
;     (> (count (*session* :search-terms)) 0)
;     (= :safari (*sesstion* :user-agent)))
