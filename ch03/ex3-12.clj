(load-file "listing 3.3.clj")

(sort-by username users)
;=> ({:username "kyle", :firstname "Kyle", :lastname "Smith", :balance 175.00M, :member-since "2009-04-16"} {:username "rob", :firstname "Robert", :lastname "Jones", :balance 98.50M, :member-since "2009-03-30"} {:username "zak", :firstname "Zackary", :lastname "Jones", :balance 12.95M, :member-since "2009-02-01"})



(defn sorter-using [ordering-fn]
  (fn [collection]
    (sort-by ordering-fn collection)))


(def poorest-first (sorter-using balance))


(poorest-first users)
;=> ({:username "zak", :firstname "Zackary", :lastname "Jones", :balance 12.95M, :member-since "2009-02-01"} {:username "rob", :firstname "Robert", :lastname "Jones", :balance 98.50M, :member-since "2009-03-30"} {:username "kyle", :firstname "Kyle", :lastname "Smith", :balance 175.00M, :member-since "2009-04-16"})


(map lastname-firstname users)
;=> (["Smith" "Kyle"] ["Jones" "Zackary"] ["Jones" "Robert"])
(sort *1)
;=> (["Jones" "Robert"] ["Jones" "Zackary"] ["Smith" "Kyle"])
