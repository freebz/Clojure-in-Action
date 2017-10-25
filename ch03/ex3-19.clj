(let [x 10
      y 20]
  (println "x, y:" x "," y))


(defn upcased-names [names]
  (let [up-case (fn [name] (.toUpperCase name))]
    (map up-case names)))
;=> #'user/upcased-names
(upcased-names ["foo" "bar" "baz"])
;=> ("FOO" "BAR" "BAZ")


(def ^:dynamic *factor* 10)
(binding [*factor* 20]
  (println *factor*)
  (doall (map multiply [1 2 3 4 5])))

(let [*factor* 20]
  (println *factor*)
  (doall (map multiply [1 2 3 4 5])))
