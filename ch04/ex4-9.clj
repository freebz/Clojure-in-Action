(derive :rating/bronze :rating/basic)
;=> nil
(derive :rating/silver :rating/basic)
(derive :rating/gold :rating/premier)
(derive :rating/platinum :rating/premier)
(derive :rating/basic :rating/ANY)
(derive :rating/premier :rating/ANY)


(isa? :rating/gold :rating/premier)
;=> true
(isa? :rating/gold :rating/ANY)
;=> true
(isa? :rating/ANY :rating/premier)
;=> false
(isa? :rating/gold :rating/gold)
;=> true
(parents :rating/premier)
;=> #{:rating/ANY}
(ancestors :rating/gold)
;=> #{:rating/ANY :rating/premier}
(descendants :rating/ANY)
;=> #{:rating/basic :rating/bronze :rating/gold :rating/premier :rating/silver :rating/platinum}
