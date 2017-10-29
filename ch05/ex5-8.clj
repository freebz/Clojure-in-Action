(ns com.curry.utils.calculators
  (:gen-class))
(defn present-value [data]
  (println "calculating present value..."))


(in-ns 'com.curry.utils.calculators)
(defn discounted-cash-flow [data]
  (println "calculating discounted cash flow..."))


(ns com.curry.utils.calculators
  (:gen-class))
(load "calc/fcf")
(load "calc/dcf")
(defn present-value [data]
  (println "calculating present value..."))

