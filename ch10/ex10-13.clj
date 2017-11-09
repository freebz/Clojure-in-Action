(def all-expenses [{:amount 10.0 :date "2010-02-28"}
                   {:amount 20.0 :date "2010-02-25"}
                   {:amount 30.0 :date "2010-02-21"}])


(deftest test-fetch-expenses-greater-than
  (stubbing [fetch-all-expenses all-expenses]
            (let [filtered (fetch-expenses-greater-than "" "" "" 15.0)]
              (is (= (count filtered) 2))
              (is (= (:amount (first filtered)) 20.0))
              (is (= (:amount (last filtered)) 30.0)))))
