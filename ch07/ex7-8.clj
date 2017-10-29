(macroexpand  '(declare add multiply subtract divide))
;=> (do
;     (def add)
;     (def multiply)
;     (def subtract)
;     (def divide))


(defmacro defonce [name expr]
  `(let [v# (def ~name)]
     (when-not (.hasRoot v#)
       (def ~name ~expr))))


(defmacro and
  ([] true)
  ([x] x)
  ([x & next]
   `(let [and# ~x]
      (if and# (and ~@next) and#))))


(macroexpand '(and (even? x) (> x 50) (< x 500)))
;=> (let* [and__1722__auto__ (even? x)]
;     (if and__1722__auto__
;       (user/and (> x 50) (< x 500))
;       and__1722__auto__))


(time (* 1331 12531))
; "Elapsed time: 0.07054 msecs"
;=> 16678761


(defmacro time [expr]
  `(let [start# (. System (nanoTime))
         ret# ~expr]
     (prn
      (str "Elapsed time: "
           (/ (double (- (. System (nanoTime)) start#)) 1000000.0)
           " msecs"))
     ret#))
