(defn describe-salary [person]
  (let [first  (:first-name person)
        last   (:last-name  person)
        annual (:salary     person)]
    (println first last "earns" annual)))


(defn describe-salary-2 [{first  :first-name
                          last   :last-name
                          annual :salary}]
  (println first last "earns" annual))
