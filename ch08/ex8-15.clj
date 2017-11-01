(defn find-method [method-name instance-methods]
  (instance-methods method-name))

(defn new-class [class-name methods]
  (fn klass [command & args]
    (case command
      :name (name class-name)
      :new (new-object klass)
      :method (let [[method-name] args]
                (find-method method-name methods)))))

(defclass Person
  (method age []
          (* 2 10))
  (method greet [visitor]
          (str "Hello there, " visitor)))

(Person :method :age)
;=> #object[user$age__4502 0x1112493 "user$age__4502@1112493"]

((Person :method :age))
;=> 20
