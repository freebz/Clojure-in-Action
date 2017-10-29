(defmacro def-logged-fn [fn-name args & body]
  `(defn ~fn-name ~args
     (let [now (System/currentTimeMillis)]
       (println "[" now "] Call to" (str (var ~fn-name)))
       ~@body)))


;(def-logged-fn printname [name]
;  (println "hi" name))
; CompilerException java.lang.RuntimeException: Can't let qualified name: user/now, compiling:(/home/freebz/work/Clojure in Action/ch07/ex7-7.clj:8:1)


(macroexpand-1 '(def-logged-fn printname [name]
                  (println "hi" name)))
;=> (clojure.core/defn printname [name]
;     (clojure.core/let [user/now (java.lang.System/currentTimeMillis)]
;       (clojure.core/println "[" user/now "] Call to"
;          (clojure.core/str (var printname)))
;       (println "hi" name)))


(defmacro def-logged-fn [fn-name args & body]
  `(defn ~fn-name ~args
     (let [now# (System/currentTimeMillis)]
       (println "[" now# "] Call to" (str (var ~fn-name)))
       ~@body)))


(def-logged-fn printname [name]
  (println "hi" name))


(printname "deepthi")
; [ 1509271559331 ] Call to #'user/printname
; hi deepthi
;=> nil
