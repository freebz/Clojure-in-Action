(defn of-n-args [a b c d e]
  (str a b c d e))


(defn of-k-args [d e]
  (of-n-args 1 2 3 d e))


(of-k-args \a \b)
;=> "123ab"


(defn partially-applied [of-n-args & n-minus-k-args]
  (fn [& k-args]
    (apply of-n-args (concat n-minus-k-args k-args))))


(def of-2-args (partially-applied of-n-args \a \b \c))
;=> #'user/of-2-args
(def of-3-args (partially-applied of-n-args \a \b))
;=> #'user/of-3-args


(of-2-args 4 5)
;=> "abc45"
(of-3-args 3 4 5)
;=> "ab345"


(def of-2-args (partial of-n-args \a \b \c))
;=> #'user/of-2-args
(def of-3-args (partial of-n-args \a \b))
;=> #'user/of-3-args


(of-2-args 4 5)
;=> "abc45"
(of-3-args 3 4 5)
;=> "ab345"
