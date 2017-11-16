;; 2 * PI * r * (r + h)

(defn surface-area-cylinder [r h]
  (-> r
      (+ h)
      (* 2 Math/PI r)))


(defn some-calculation [a-collection]
  (->> (seq a-collection)
       (filter some-pred?)
       (map a-transform)
       (reduce another-function)))


(defn another-calculation [a-collection]
  (->> (seq a-collection)
       (filter some-pred?)
       (map a-transform)
       (#(compute-averages-from % another-pred?))))


(defn another-calculation [a-collection]
  (as-> (seq a-collection) result
    (filter some-pred? result)
    (map a-transform result)
    (compute-averages-from result another-pred?)))


(defn yet-another-calculation [a-collection]
  (thread-it (seq a-collection)
             (filter some-pred? it)
             (map a-transform it)
             (compute-averages-from it another-pred?)))


(defmacro thread-it [& [first-expr & rest-expr]]
  (if (empty? rest-expr)
    first-expr
    `(let [~'it ~first-expr]
       (thread-it ~@rest-expr))))


(thread-it (* 10 20) (inc it) (- it 8) (* 10 it) (/ it 5))
