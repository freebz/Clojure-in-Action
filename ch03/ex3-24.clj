(defn describe-salary-2 [{first  :first-name
                          last   :last-name
                          annual :salary}]
  (println first last "earns" annual))


(defn describe-salary-3 [{first  :first-name
                          last   :last-name
                          annual :salary
                          bonus  :bonus-percentage
                          :or {bonus 5}}]
  (println first last "earns" annual "with a" bonus "percent bonus"))

(def a-user {:first-name       "pascal"
             :last-name        "dylan"
             :salary           85000
             :bonus-percentage 20})
(describe-salary-3 a-user)
; pascal dylan earns 85000 with a 20 percent bonus


(def another-user {:first-name "basic"
                   :last-name  "groovy"
                   :salary     70000})
(describe-salary-3 another-user)
; basic groovy earns 70000 with a 5 percent bonus


(defn describe-person [{first  :first-name
                        last   :last-name
                        bonus  :bonus-percentage
                        :or {bonus 5}
                        :as p}]
  (println "Info about" first last "is:" p)
  (println "Bonus is:" bonus "percent"))

(def third-user {:first-name "lambda"
                 :last-name  "curry"
                 :salary     95000})
(describe-person third-user)
; Info about lambda curry is: {:first-name lambda, :last-name curry, :salary 95000}
; Bonus is: 5 percent


(defn greet-user [{:keys [first-name last-name]}]
  (println "Welcome," first-name last-name))

(def roger {:first-name "orger" :last-name "mann" :salary 65000})
(greet-user roger)
; Welcome, orger mann
