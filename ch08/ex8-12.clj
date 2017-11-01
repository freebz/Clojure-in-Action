(defn new-class [class-name]
  (fn klass [command & args]
    (case command
      :name (name class-name)
      :new (new-object klass))))


(defclass Person)
;=> #'user/Person
(def nancy (Person :new))
;=> #'user/nancy
(nancy :class-name)
;=> "Person"
