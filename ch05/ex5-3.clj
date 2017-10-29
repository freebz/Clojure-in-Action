(. System getenv "PATH")
(. System (getenv "PATH"))


(import '(java.util Random))
;=> java.util.Random
(def rnd (Random.))
;=> #'user/rnd
(. rnd nextInt 10)
;=> 4
(. rnd (nextInt 10))
;=> 3
