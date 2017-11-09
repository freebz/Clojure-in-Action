(defn clear-calls []
  (reset! mock-calls {}))


(def ^:dynamic *mock-calls*)


(defmacro defmocktest [test-name & body]
  `(deftest ~test-name
     (binding [*mock-calls* (atom {})]
       (do ~@body))))


(defmocktest test-fetch-expenses-greater-than
  (stubbing [fetch-all-expenses all-expenses]
            (let [filtered (fetch-expenses-greater-than "" "" "" 15.0)]
              (is (= (count filtered) 2))
              (is (= (:amount (first filtered)) 20.0))
              (is (= (:amount (last filtered)) 30.0)))))


(defmocktest test-filter-greater-than
  (mocking [log-call]
           (let [filtered (expenses-greater-than all-expenses 15.0)]
             (is (= (count filtered) 2))
             (is (= (:amount (first filtered)) 20.0))
             (is (= (:amount (last filtered)) 30.0)))
           (verify-call-times-for log-call 1)
           (verify-first-call-args-for log-call "expenses-greater-than" 15.0)))
