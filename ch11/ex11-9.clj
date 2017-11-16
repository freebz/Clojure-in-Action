(def redis-key-for :consumer-id)


(defn save-session [session]
  (redis/set (redis-key-for session) (pr-str session)))
(defn find-session [consumer-id]
  (read-string (redis/get consumer-id)))


(def ^:dynamic *session*)


(defmacro in-session [consumer-id & body]
  `(binding [*session* (find-session ~consumer-id)]
     (do ~@body)))
