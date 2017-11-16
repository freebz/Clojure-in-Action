(defmacro make-synonym [new-name old-name]
  (defmacro b [& stuff]
    `(binding ~@stuff)))


(defmacro make-synonym [new-name old-name]
  `(defmacro ~new-name [& stuff]
     `(~old-name ~@stuff)))


(macroexpand-1 '(make-synonym b binding))
;=> (clojure.core/defmacro b [& user/stuff]
;     (clojure.core/seq
;       (clojure.core/concat (clojure.core/list user/old-name)
;                            user/stuff)))


(defmacro back-quote-test []
  `(something))
;=> #'user/back-quote-test
(macroexpand '(back-quote-test))
;=> (user/something)


(defmacro back-quote-test []
  ``(something))
;=> #'user/back-quote-test


(macroexpand '(back-quote-test))
;=> (clojure.core/seq
;     (clojure.core/concat (clojure.core/list (quote user/something))))


(macroexpand-1 '(make-synonym b binding))
;=> (clojure.core/defmacro b [& user/stuff]
;     (clojure.core/seq
;       (clojure.core/concat (clojure.core/list user/old-name) user/stuff)))


(defmacro back-quote-test []
  ``(~something))
;=> #'user/back-quote-test
(macroexpand '(back-quote-test))
;=> (clojure.core/seq (clojure.core/concat (clojure.core/list user/something)))


(defmacro back-quote-test []
  ``(~@something))
;=> #'user/back-quote-test
(macroexpand '(back-quote-test))
;=> (clojure.core/seq (clojure.core/concat user/something))


(defmacro make-synonym [new-name old-name]
  `(defmacro ~new-name [& ~'stuff]
     `(~old-name ~@~'stuff)))


(macroexpand-1 '(make-synonym b binding))
;=> (clojure.core/defmacro b [& stuff]
;     (clojure.core/seq (clojure.core/concat
;                         (clojure.core/list user/old-name) stuff)))


(defmacro make-synonym [new-name old-name]
  `(defmacro ~new-name [& ~'stuff]
     `(~'~old-name ~@~'stuff)))


(macroexpand-1 '(make-synonym b binding))
;=> (clojure.core/defmacro b [& stuff]
;     (clojure.core/seq (clojure.core/concat
;       (clojure.core/list (quote binding)) stuff)))


(declare x y)
;=> #'user/y
(make-synonym b binding)
;=> #'user/b
(b [x 10 y 20] [x y])
;=> [10 20]
