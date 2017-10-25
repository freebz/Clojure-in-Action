(def MAX-CONNECTIONS 10)

(def RABBITMQ-CONNECTION)

(def ^:dynamic RABBITMQ-CONNECTION)
(binding [RABBITMQ-CONNECTION (new-connection)]
  (
   ;; do something here with RABBITMQ-CONNECTION
   ))
