(def ^:dynamic *db-host* "localhost")

(defn expense-report [start-date end-date]
  (println *db-host*)) ;; can do real work

(binding [*db-host* "production"]
  (expense-report "2010-01-01" "2010-01-07"))

