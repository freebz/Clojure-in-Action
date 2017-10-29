(defn check-credentials [username password]
  true)

(defn login-user [request]
  (let [username (:username request)
        password (:password request)]
    (if (check-credentials username password)
      (str "Welcome back, " username ", " password " is correct!")
      (str "Login failed!"))))


(def request {:username "amit" :password "123456"})
;=> #'user/request
(login-user request)
;=> "Welcome back, amit, 123456 is correct!"


(defmacro defwebmethod [name args & exprs]
  `(defn ~name [{:keys ~args}]
     ~@exprs))


(defwebmethod login-user [username password]
  (if (check-credentials username password)
    (str "Welcome, " username ", " password " is still correct!")
    (str "Login failed!")))


(login-user request)
;=> "Welcome, amit, 123456 is still correct!"
