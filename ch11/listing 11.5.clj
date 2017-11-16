;; Listing 11.5  Simple DSL execution engine to classify users into segments

(ns clj-in-act.ch11.engine
  (:use clj-in-act.ch11.segment
        clj-in-act.ch11.session
        clj-in-act.ch11.dsl-store))
(defn load-code [code-string]
  (binding [*ns* (:ns (meta #'load-code))]
    (load-string code-string)))
(defn matches? [^String superset ^String subset]
  (and
   (not (empty? superset))
   (> (.indexOf superset subset) 0)))
(defn segment-satisfied? [[segment-name segment-fn]]
  (if (segment-fn)
    segment-name))
(defn classify []
  (->> (all-segments)
       (map segment-satisfied?)
       (remove nil?)))
