(def a-ref (ref 0))

(dosync
 (ref-set a-ref 1))


(defmacro sync-set [r v]
  (list 'dosync
        (list 'ref-set r v)))


(sync-set a-ref 1)
