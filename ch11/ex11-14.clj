(def dsl-code (str
               '(defsegment googling-clojurians
                  (and
                   (> (count $search-terms) 0)
                   (matches? $url-referrer "google")))
               '(defsegment loyal-safari
                  (and
                   (empty? $url-referrer)
                   (= :safari $user-agent)))))
;=> #'user/dsl-code


(use 'clj-in-act.ch11.engine)
;=> nil


(load-code dsl-code)
;=> {:segments {:loyal-safari #<engine@eva13399$segment_fn__2833_
; TRUNCATED OUTPUT


(def abc-session {
                  :consumer-id "abc"
                  :url-referrer "http://www.google.com/search?q=clojure+programmers"
                  :search-terms ["clojure" "programmers"]
                  :ip-address "192.168.0.10"
                  :tz-offset 480
                  :user-agent :safari})
;=> #'user/abc-session


(require 'redis) (use 'clj-in-act.ch11.session)
;=> nil
(redis/with-server {:host "localhost"}
  (save-session abc-session))
;=> "OK"


(redis/with-server {:host "localhost"}
  (in-session "abc"
              (println "The current user is in:" (classify))))
; The current user is in: (:googling-clojurians)
;=> nil


(defsegment googling-clojurians-chrome
  (and
   (> (count $search-terms) 0)
   (matches? $url-referrer "google")
   (= :chrome $user-agent)))


(defmacro defsegment [segment-name & body]
  (let [transformed (postwalk transform-lookups body)]
    `(let [segment-fn#  (fn [] ~@transformed)]
       (register-segment ~(keyword segment-name) segment-fn#)
       (def ~segment-name segment-fn#))))


(defsegment googling-clojurians-chrome
  (and
   (googling-clojurians)
   (= :chrome $user-agent)))


(defsegment googling-clojurians
  (and
   (> (count $search-terms) 0)
   (matches? $url-referrer "yahoo")))


(load-code (str '(defsegment googling-clojurians
                   (and
                    (> (count $search-terms) 0)
                    (matches? $url-referrer "yahoo")))))
