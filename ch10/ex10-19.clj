(defn mock-fn [the-function]
  (stub-fn the-function nil))


(defmacro mocking [fn-names & body]
  (let [mocks (map #(list `mock-fn (keyword %)) fn-names)]
    `(with-redefs [~@(interleave fn-names mocks)]
       ~@body)))


(deftest test-filter-greater-than
  (mocking [log-call]
           (let [filtered (expenses-greater-than all-expenses 15.0)]
             (is (= (count filtered) 2))
             (is (= (:amount (first filtered)) 20.0))
             (is (= (:amount (last filtered)) 30.0)))))
