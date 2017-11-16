;; Listing 11.3  dsl-store namespace for storing the rules as anonymous functions

(ns clj-in-act.ch11.dsl-store)
(def RULES (ref {}))
(defn register-segment [segment-name segment-fn]
  (dosync
   (alter RULES assoc-in [:segments segment-name] segment-fn)))
(defn segment-named [segment-name]
  (get-in @RULES [:segments segment-name]))
(defn all-segments []
  (:segments @RULES))
