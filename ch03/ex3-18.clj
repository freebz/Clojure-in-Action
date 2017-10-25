(def ^:dynamic *factor* 10)
(defn multiply [x]
  (* x *factor*))

(map multiply [1 2 3 4 5])

(binding [*factor* 20]
  (map multiply [1 2 3 4 5]))

(binding [*factor* 20]
  (doall (map multiply [1 2 3 4 5])))
