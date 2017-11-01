(defn new-class [class-name]
  (fn [command & args]
    (case command
      :name (name class-name))))
(defmacro defclass [class-name]
  `(def ~class-name (new-class '~class-name)))


(defclass Person)
;=> #'user/Person
(Person :name)
;=> "Person"


(def some-class Person)
;=> #'user/some-class
(some-class :name)
;=> "Person"
