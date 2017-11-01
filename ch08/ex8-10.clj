(defn new-object [klass]
  (fn [command & args]
    (case command
      :class klass)))

(def cindy (new-object Person))


(new-object Person)
;=> #object[user$new_object$fn__2240 0xcf5a24 "user$new_object$fn__2240@cf5a24"]

((cindy :class) :name)
;=> "Person"
