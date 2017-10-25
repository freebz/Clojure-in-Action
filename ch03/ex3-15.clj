(load-file "listing 3.3.clj")

(def person {:username "zak"
             :balance 12.95
             :member-since "2009-02-01"})


(person :username)
;=> "zak"


(:username person)
;=> "zak"


(map #(% :member-since) users)
;=> ("2009-04-16" "2009-02-01" "2009-03-30")


(map :member-since users)
;=> ("2009-04-16" "2009-02-01" "2009-03-30")


(:login person)
;=> nil
(:login person :not-found)
;=> :not-found


(def expense {'name "Show Leopard" 'cost 29.95M})
;=> #'user/expense
(expense 'name)
;=> "Show Leopard"
('name expense)
;=> "Show Leopard"
('vendor expense)
;=> nil
('vendor expense :absent)
;=> :absent


(person :username)
;=> "zak"


(person :login :not-found)
;=> :not-found


(def names ["kyle" "zak" "rob"])
;=> #'user/names
(names 1)
;=> "zak"


(names 10)
CompilerException java.lang.IndexOutOfBoundsException, compiling:(/home/freebz/work/Clojure in Action/ch03/ex3-15.clj:53:1)
(names 10 :not-found)
CompilerException clojure.lang.ArityException: Wrong number of args (2) passed to: PersistentVector, compiling:(/home/freebz/work/Clojure in Action/ch03/ex3-15.clj:53:1)
