(let [filtered (fetch-expenses-greater-than "" "" "" 15.0)]
  (is (= (count filtered) 2))
  (is (= (:amount (first filtered)) 20.0))
  (is (= (:amount (last filtered)) 30.0)))
