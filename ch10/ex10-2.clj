(ns clj-in-act.ch10.date-operations)
(defn date [date-string])
(defn day-from [d])


(use 'clojure.test)
;=> nil
(run-tests 'clj-in-act.ch10.date-operations-spec)

;; Testing clj-in-act.ch10.date-operations-spec

;; FAIL in (test-simple-data-parsing) (ex10-1.clj:6)
;; expected: (= (day-from d) 22)
;; actual: (not (= nil 22))

;; Ran 1 tests containing 1 assertions.
;; 1 failures, 0 errors.
;=> {:test 1, :pass 0, :fail 1, :error 0, :type :summary}
