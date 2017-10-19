(def the-map {:a 1 :b 2 :c 3})
;=> #'user/the-map


(hash-map :a 1 :b 2 :c 3)
;=> {:a 1, :c 3, :b 2}


(the-map :b)
;=> 2


(:b the-map)
;=> 2
(:z the-map 26)
;=> 26


(def updated-map (assoc the-map :d 4))
;=> #'user/updated-map
updated-map
;=> {:d 4, :a 1, :b 2, :c 3}
(dissocf updated-map :a)
;=> {:b 2, :c 3, :d 4}


(def users {:kyle {
                   :date-joined "2009-01-01"
                   :summary {
                             :average {
                                       :monthly 1000
                                       :yearly 12000}}}})

(assoc-in users [:kyle :summary :average :monthly] 3000)
;=> {:kyle {:date-joined "2009-01-01", :summary {:average {:monthly 3000,
:yearly 12000}}}}

(get-in users [:kyle :summary :average :monthly])
;=> 1000

(update-in users [:kyle :summary :average :monthly] + 500)
;=> {:kyle {:date-joined "2009-01-01", :summary {:average {:monthly 1500,
:yearly 12000}}}}
