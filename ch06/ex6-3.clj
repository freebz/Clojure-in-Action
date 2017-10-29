(defn new-user [id login monthly-budget]
  {:id id
   :login login
   :monthly-budget monthly-budget
   :total-expenses 0})


(defn add-new-user [login budget-amount]
  (dosync
   (let [current-number (count @all-users)
         user (new-user (inc current-number) login budget-amount)]
     (alter all-users assoc login user))))


(add-new-user "amit" 1000000)
;=> {"amit" {:id 1, :login "amit", :monthly-budget 1000000, :total-expenses 0}}

(add-new-user "deepthi" 2000000)
;=> {"amit" {:id 1, :login "amit", :monthly-budget 1000000, :total-expenses 0}, "deepthi" {:id 2, :login "deepthi", :monthly-budget 2000000, :total-expenses 0}}
