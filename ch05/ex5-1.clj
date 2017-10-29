(import 'java.util.Date 'java.text.SimpleDateFormat)

(import '[java.util Date Set])

(ns com.clojureinaction.book
  (:import (java.util Set Date)))


(import '(java.text SimpleDateFormat))
(def sdf (new SimpleDateFormat "yyyy-MM-dd"))

(def sdf (SimpleDateFormat. "yyyy-MM-dd"))


(defn date-from-date-string [date-string]
  (let [sdf (SimpleDateFormat. "yyyy-MM-dd")]
    (.parse sdf date-string)))


(Long/parseLong "12321")
