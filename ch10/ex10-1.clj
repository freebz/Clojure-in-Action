(ns clj-in-act.ch10.date-operations-spec
  (:require [clojure.test :refer :all]
            [clj-in-act.ch10.date-operations :refer :all]))
(deftest test-simple-data-parsing
  (let [d (date "2009-01-22")]
    (is (= (day-from d) 22))))

; CompilerException java.io.FileNotFoundException: Could not locate clj_in_act/ch10/date_operations__init.class or clj_in_act/ch10/date_operations.clj on classpath. Please check that namespaces with dashes use underscores in the Clojure file name., compiling:(/home/freebz/work/Clojure in Action/ch10/ex10-1.clj:1:1)
