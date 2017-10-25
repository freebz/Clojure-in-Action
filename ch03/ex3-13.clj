(load-file "listing 3.3.clj")

(last-then-firstname users)
;=> ({:username "rob", :firstname "Robert", :lastname "Jones", :balance 98.50M, :member-since "2009-03-30"} {:username "zak", :firstname "Zackary", :lastname "Jones", :balance 12.95M, :member-since "2009-02-01"} {:username "kyle", :firstname "Kyle", :lastname "Smith", :balance 175.00M, :member-since "2009-04-16"})
