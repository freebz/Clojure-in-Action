(def all-users (ref {}))


(deref all-users)
;=> {}


@all-users
;=> {}


all-users
;=> #object[clojure.lang.Ref 0xb78afa {:status :ready, :val {}}]
