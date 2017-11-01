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
               (@state key))))))


(def nancy (Person :new))
;=> #'user/nancy
(nancy :get :name)
;=> nil

(nancy :set! :name "Nancy Drew")
;=> nil
(nancy :get :name)
;=> "Nancy Drew"
