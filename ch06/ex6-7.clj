(def hbase-master "localhost")


(def ^:dynamic *hbase-master* "localhost")
;=> #'user/*hbase-master*
(println "Hbase-master is:" *hbase-master*)
; Hbase-master is: localhost
;=> nil


(def ^:dynamic *rabbitmq-host*)
;=> #'user/*rabbitmq-host*
(println "RabbitMQ host is:" *rabbitmq-host*)
; RabbitMQ host is: #object[clojure.lang.Var$Unbound 0x17889f3 Unbound: #'user/*rabbitmq-host*]
;=> nil
(bound? #'*rabbitmq-host*)
;=> false


(def ^:dynamic *mysql-host*)

(defn db-query [db]
  (binding [*mysql-host* db]
    (count *mysql-host*)))

(def mysql-hosts ["test-mysql" "dev-mysql" "staging-mysql"])

(pmap db-query mysql-hosts)
;=> (10 9 13)
