(defmocktest test-filter-greater-than
  (mocking [log-call]
           (let [filtered (expenses-greater-than all-expenses 15.0)]
             (testing "the filtering itself works as expected"
               (is (= (count filtered) 2))
               (is (= (:amount (first filtered)) 20.0))
               (is (= (:amount (last filtered)) 30.0))))
           (testing "Auditing via log-call works correctly"
             (verify-call-times-for log-call 1)
             (verify-first-call-args-for log-call "expenses-greater-than" 15.0))))


(test-filter-greater-than)
