;; Listing 11.1  A general rotation cipher system to implement things like ROT13

(ns clj-in-act.ch11.shifting)
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
(defn shifted-tableau [shift-by]
  (->> (map #(shift shift-by %) INDICES)
       (map lookup)
       (zipmap ALPHABETS )))
(defn encrypt [shift-by plaintext]
  (let [shifted (shifted-tableau shift-by)]
    (apply str (map shifted plaintext))))
(defn decrypt [shift-by encrypted]
  (encrypt (- shift-by) encrypted))
(def encrypt-with-rot13 (partial encrypt 13))
(def decript-with-rot13 (partial decrypt 13))
