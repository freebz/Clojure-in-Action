(java.util.UUID/randomUUID)
;=> #uuid "4b241b3a-bfb9-4231-8b79-952508913a9e"


(ns clj-in-act.ch3.reader
  (:import java.util.UUID))

(defn guid [four-letters-four-digits]
  (java.util.UUID/fromString
   (str four-letters-four-digits "-1000-413f-8a7a-f11c6a9c4036")))

(use 'clj-in-act.ch3.reader)
;=> nil
(guid "abcd1234")
;=> #uuid "abcd1234-1000-413f-8a7a-f11c6a9c4036"
