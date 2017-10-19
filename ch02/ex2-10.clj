(defn addition-function [x y]
  (+ x y))


(def addition-function
  (fn [x y]
    (+ x y)))


(defn average-pets []
  (/ (apply + (map :number-pets (vals users))) (count users)))


(defn average-pets []
  (let [user-data (vals users)
        pet-counts (map :number-pets user-data)
        total (apply + pet-counts)]
    (/ total (count users))))


(let [x 1
      y 2
      z (+ x y)]
  z)
;=> 3


(defn average-pets []
  (let [user-data (vals users)
        pet-counts (map :number-pets user-data)
        value-from-println (println "total pats:" pet-counts)
        total (apply + pet-counts)]
    (/ total (count users))))


(defn average-pets []
  (let [user-data (vals users)
        pet-counts (map :number-pets user-data)
        _ (println "total pats:" pet-counts)
        total (apply + pet-counts)]
    (/ total (count users))))
