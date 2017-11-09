(defmacro verify-call-times-for [fn-name number]
  `(is (= ~number (count (@mock-calls ~(keyword fn-name))))))


(defmacro verify-first-call-args-for [fn-name & args]
  `(is (= '~args (first (@mock-calls ~(keyword fn-name))))))


(defmacro verify-nth-call-args-for [n fn-name & args]
  `(is (= '~args (nth (@mock-calls ~(keyword fn-name)) (dec ~n)))))


(deftest test-filter-greater-than
  (mocking [log-call]
           (let [filtered (expenses-greater-than all-expenses 15.0)]
             (is (= (count filtered) 2))
             (is (= (:amount (first filtered)) 20.0))
             (is (= (:amount (last filtered)) 30.0)))
           (verify-call-times-for log-call 1)
           (verify-first-call-args-for log-call "expenses-greater-than" 15.0)
           (verify-nth-call-args-for 1 log-call "expenses-greater-than" 15.0)))


(defmacro verify-frist-call-args-for [fn-name & args]
  `(verify-nth-call-args-for 1 ~fn-name ~@args))
