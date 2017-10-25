;; Listing 3.7  Using external libraries by calling require

(ns org.currylogic.damages.http.expenses)
(require '(clojure.data [json :as json-lib]))
(require '(clojure [xml :as xml-core]))

(declare load-totals)

(defn import-transactions-xml-from-bank [url]
  (let [xml-document (xml-core/parse url)]
    ;; more code here
))

(defn totals-by-day [start-date end-date]
  (let [expenses-by-day (load-totals start-date end-date)]
    (json-lib/json-str expenses-by-day)))
