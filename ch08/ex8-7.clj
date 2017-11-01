(defn adder [num1 num2]
  (let [x (+ num1 num2)]
    (fn [y]
      (+ x y))))


(def add-5 (adder 2 3))
;=> #'user/add-5


(add-5 10)
;=> 15


(let [x 1
      y 0]
  (/ x y))
; CompilerException java.lang.ArithmeticException: Divide by zero, compiling:(/home/freebz/work/Clojure in Action/ch08/ex8-7.clj:12:1)


(let [x 1
      y 0]
  (try
    (/ x y)
    (catch Exception e (println (.getMessage e)))))
; Divide by zero
;=> nil


(defn try-catch [the-try the-catch]
  (try
    (the-try)
    (catch Exception e (the-catch e))))


(let [x 1
      y 0]
  (try-catch #(/ x y)
             #(println (.getMessage %))))
