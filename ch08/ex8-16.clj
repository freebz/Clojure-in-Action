(defn new-object [klass]
  (let [state (ref {})]
    (fn [command & args]
      (case command
        :class klass
        :class-name (klass :name)
        :set! (let [[k v] args]
                (dosync (alter state assoc k v))
                nil)
        :get (let [[key] args]
               (@state key))
        (if-let [method (klass :method command)]
          (apply method args)
          (throw (RuntimeException.
                  (str "Unable to respond to " command))))))))


(def shelly (Person :new))
;=> #'user/shelly
(shelly :age)
;=> 20
(shelly :greet "Nancy")
;=> "Hello there, Nancy"
