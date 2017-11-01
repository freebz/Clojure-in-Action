(defn square [x]
  (* x x))
(defn square-all [numbers]
  (if (empty? numbers)
    nil
    (cons (square (first numbers))
          (square-all (rest numbers)))))


(square-all [1 2 3 4 5 6])
;=> (1 4 9 16 25 36)


(defn cube [x]
  (* x x x))
(defn cube-all [numbers]
  (if (empty? numbers)
    ()
    (cons (cube (first numbers))
          (cube-all (rest numbers)))))

(cube-all [1 2 3 4 5 6])
;=> (1 8 27 64 125 216)


(defn do-to-all [f numbers]
  (if (empty? numbers)
    ()
    (cons (f (first numbers))
          (do-to-all f (rest numbers)))))

(do-to-all square [1 2 3 4 5 6])
;=> (1 4 9 16 25 36)
(do-to-all cube [1 2 3 4 5 6])
;=> (1 8 27 64 125 216)


(do-to-all square (range 11000))
; CompilerException java.lang.StackOverflowError, compiling:(/home/freebz/work/Clojure in Action/ch08/ex8-1.clj:35:1)


(defn do-to-all [f numbers]
  (lazy-seq
   (if (empty? numbers)
     ()
     (cons (f (first numbers))
           (do-to-all f (rest numbers))))))

(take 10 (drop 10000 (do-to-all square (range 11000))))
;=> (100000000 100020001 100040004 100060009 100080016 100100025 100120036 100140049 100160064 100180081)

(take 10 (drop 10000 (do-to-all square (range 11000))))
;=> (100000000 100020001 100040004 100060009 100080016 100100025 100120036 100140049 100160064 100180081)
