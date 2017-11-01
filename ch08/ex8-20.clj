(def OBJECT (new-class :OBJECT nil {}))


(defclass Person
  (method age [] (* 2 10))
  (method about [diff]
          (str "I was born about " (+ diff (this :age)) " years ago")))
;=> #'user/Person


(defclass Woman
  (extends Person)
  (method greet [v] (str "Hello, " v))
  (method age [] (* 2 9)))
;=> #'user/Woman


(def donna (Woman :new))
;=> #'user/donna
(donna :greet "Shelly")
;=> "Hello, Shelly"
(donna :age)
;=> 18
(donna :about 3)
; CompilerException java.lang.RuntimeException: Unable to respond to :about, compiling:(/home/freebz/work/Clojure in Action/ch08/ex8-20.clj:23:1)
