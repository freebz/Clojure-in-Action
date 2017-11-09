(defn to-upper [s]
  (.toUpperCase (str s)))


(deftest test-to-upcase
  (is (= "RATHORE" (to-upper "rathore")))
  (is (= "1" (to-upper 1)))
  (is (= "AMIT" (to-upper "amit"))))


(deftest test-to-upcase
  (are [l u] (= u (to-upper l))
    "RATHORE" "rathore"
    "1"       "1"
    "AMIT"    "amit"))
