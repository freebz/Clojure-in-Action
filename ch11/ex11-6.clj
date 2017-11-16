(defn encrypt-with-rot13 [plaintext]
  (apply str (map {\a \n \b \o \c \p} plaintext)))


(defmacro def-rot-encrypter [name shift-by]
  (let [tableau (shifted-tableau shift-by)]
    `(defn ~name [~'message]
       (apply str (map ~tableau ~'message)))))


(macroexpand-1 '(def-rot-encrypter encrypt13 13))
;=> (clojure.core/defn encrypt13 [message] (clojure.core/apply clojure.core/str (clojure.core/map {\a \n, \b \o, \c \p, \d \q, \e \r, \f \s, \g \t, \h \u, \i \v, \j \w, \k \x, \l \y, \m \z, \n \a, \o \b, \p \c, \q \d, \r \e, \s \f, \t \g, \u \h, \v \i, \w \j, \x \k, \y \l, \z \m} message)))


(def-rot-encrypter encrypt13 13)
;=> #'user/encrypt13
(encrypt13 "abracadabra")
;=> "noenpnqnoen"


(defmacro define-rot-encryption [shift-by]
  `(do
     (def-rot-encrypter ~(symbol (str "encrypt" shift-by)) ~shift-by)
     (def-rot-encrypter ~(symbol (str "decrypt" shift-by)) ~(- shift-by))))


(define-rot-encryption 15)
;=> #'user/decrypt15


(encrypt15 "abracadabra")
;=> "pqgprpspqgp"
(decrypt15 "pqgprpspqgp")
;=> "abracadabra"
