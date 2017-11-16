(defsegment loyal-sfari
  (and
   (empty? $url-referrer)
   (= :safari $user-agent)))
;=> {:segments
;     {:loyal-safari
;       #<user$eval13457$segment_fn__3232__auto____3458
;     user$eval13457$segment_fn__3232__auto____3458@5054c2b8>}}


(defn matches? [^String superset ^String subset]
  (and
   (not (empty? superset))
   (> (.indexOf superset subset) 0)))


(ns clj-in-act.ch11.engine
  (:use clj-in-act.ch11.segment
        clj-in-act.ch11.session
        clj-in-act.ch11.dsl-store))
(defn load-code [code-string]
  (binding [*ns* (:ns (meta #'load-code))]
    (load-string code-string)))


(defn segment-satisfied? [[segment-name segment-fn]]
  (if (segment-fn)
    segment-name))


(defn classify []
  (->> (all-segments)
       (map segment-satisfied?)
       (remove nil?)))
