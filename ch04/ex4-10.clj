(defmulti greet-user :rating)
;=> #'user/greet-user
(defmethod greet-user :rating/basic [user]
  (str "Hello " (:login user) \.))
;=> #object[clojure.lang.MultiFn 0x646999 "clojure.lang.MultiFn@646999"]
(defmethod greet-user :rating/premier [user]
  (str "Welcome, " (:login user) ", valued affiliate member!"))
;=> #object[clojure.lang.MultiFn 0x646999 "clojure.lang.MultiFn@646999"]
(map greet-user [user-1 user-2 user-3 user-4])
;=> ("Hello rob." "Hello gordon." "Welcome, kyle, valued affiliate member!" "Welcome, celeste, valued affiliate member!")
