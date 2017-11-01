(defn new-user [login password email]
  (fn [a]
    (case a
      :login login
      :password password
      :email email
      nil)))


(def arjun (new-user "arjun" "secret" "arjun@zololabs.com"))
;=> #'user/arjun
(arjun :login)
;=> "arjun"
(arjun :password)
;=> "secret"
(arjun :email)
;=> "arjun@zololabs.com"
(arjun :name)
;=> nil


(defn new-user [login password email]
  (fn [a]
    (case a
      :login login
      :email email
      :password-hash (hash password)
      nil)))
;=> #'user/new-user
(def arjun (new-user "arjun" "secret" "argun@zololabs.com"))
;=> #'user/arjun
(arjun :password)
;=> nil
(arjun :password-hash)
;=> 1614358358


(defn new-user [login password email]
  (fn [a & args]
    (case a
      :login login
      :email email
      :authenticate (= password (first args)))))


(def adi (new-user "adi" "secret" "adi@currylogic.com"))
;=> #'user/adi
(adi :authenticate "blah")
;=> false
(adi :authenticate "secret")
;=> true
