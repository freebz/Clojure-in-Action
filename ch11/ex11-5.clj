(def ALPHABETS [\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z])


(def NUM-ALPHABETS (count ALPHABETS))
(def INDICES (range 1 (inc NUM-ALPHABETS)))
(def lookup (zipmap INDICES ALPHABETS))


(defn shift [shift-by index]
  (let [shifted (+ (mod shift-by NUM-ALPHABETS) index)]
    (cond
      (<= shifted 0) (+ shifted NUM-ALPHABETS)
      (> shifted NUM-ALPHABETS) (- shifted NUM-ALPHABETS)
      :default shifted)))


(shift 10 13)
;=> 23
(shift 20 13)
;=> 7


(defn shifted-tableau [shift-by]
  (->> (map #(shift shift-by %) INDICES)
       (map lookup)
       (zipmap ALPHABETS)))


(shifted-tableau 13)
;=> {\a \n, \b \o, \c \p, \d \q, \e \r, \f \s, \g \t, \h \u, \i \v, \j \w, \k \x, \l \y, \m \z, \n \a, \o \b, \p \c, \q \d, \r \e, \s \f, \t \g, \u \h, \v \i, \w \j, \x \k, \y \l, \z \m}


(defn encrypt [shift-by plaintext]
  (let [shifted (shifted-tableau shift-by)]
    (apply str (map shifted plaintext))))


(encrypt 13 "abracadabra")
;=> "noenpnqnoen"


(encrypt 13 "noenpnqnoen")
;=> "abracadabra"


(defn decrypt [shift-by encrypted]
  (encrypt (- shift-by) encrypted))


(decrypt 13 "noenpnqnoen")
;=> "abracadabra"


(def encrypt-with-rot13 (partial encrypt 13))
(def decript-with-rot13 (partial decrypt 13))


(decript-with-rot13 (encrypt-with-rot13 "abracadabra"))
;=> "abracadabra"
