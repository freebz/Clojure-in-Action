(defn array-type [klass]
  (.getName (class (make-array klass 0))))
;=> #'user/array-type
(array-type BigDecimal)
;=> "[Ljava.math.BigDecimal;"
(def bigdec-arr
  ^"[Ljava.math.BigDecimal;"
  (into-array BigDecimal [1.0M]))
