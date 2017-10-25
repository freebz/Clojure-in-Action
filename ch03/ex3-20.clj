(defn create-scaler [scale]
  (fn [x]
    (* x scale)))


(def percent-scaler (create-scaler 100))

(percent-scaler 0.59)
;=> 59.0
