(defn new-object [klass]
  (fn [command & args]
    (case command
      :class klass
      :class-name (klass :name))))


(def cindy (new-object Person))
;=> #'user/cindy
(cindy :class-name)
;=> "Person"
