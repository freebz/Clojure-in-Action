(defmacro defnn [fname [& names] & body]
  (let [ks {:keys (vec names)}]
    `(defn ~fname [& {:as arg-map#}]
       (let [~ks arg-map#]
         ~@body))))


(defnn print-details [name salary start-date]
  (println "Name:" name)
  (println "Salary:" salary)
  (println "Started on:" start-date))


(print-details :start-date "10/22/2009" :name "Rob" :salary 1000000)
; Name: Rob
; Salary: 1000000
; Started on: 10/22/2009
;=> nil
