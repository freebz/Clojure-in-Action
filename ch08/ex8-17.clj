(declare ^:dynamic this)


(defclass Person
  (method age [] (* 2 10))
  (method about [diff]
          (str "I was born about " (+ diff (this :age)) " years ago")))


(defn new-object [klass]
  (let [state (ref {})]
    (fn thiz [command & args]
      (case command
        :class klass
        :class-name (klass :name)
        :set! (let [[k v] args]
                (dosync (alter state assoc k v))
                nil)
        :get (let [[key] args] (@state key))
        (let [method (klass :method command)]
          (if-not method
            (throw (RuntimeException.
                    (str "Unable to respond to " command))))
          (binding [this thiz]
            (apply method args)))))))


(def shelly (Person :new))
;=> #'user/shelly
(shelly :about 2)
;=> "I was born about 22 years ago"
