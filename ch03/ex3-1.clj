(def untrusted (with-meta {:command "delete-table" :subject "users"}
                 {:safe false :io true}))


(def untrusted ^{:safe false :io true} {:command "delete-table"
                                        :subject "users"})


(def untrusted ^{:safe false :io true} (hash-map :command "delete-table"
                                                 :subject "users"))


untrusted
;=> {:command "delete-table", :subject "users"}


(def trusted {:command "delete-table" :subject "users"})
;=> #'user/trusted
(= trusted untrusted)
;=> true


(meta untrusted)
;=> {:safe false, :io true}
(meta trusted)
;=> nil


(def still-untrusted (assoc untrusted :complete? false))
;=> #'user/still-untrusted
still-untrusted
;=> {:complete? false, :command "delete-table", :subject "users"}
(meta still-untrusted)
;=> {:safe false, :io true}


(defn ^{:safe true :console true
        :doc "testing metadata for functions"}
  testing-meta
  []
  (println "Hello from meta!"))


(meta testing-meta)
;=> nil


(meta (var testing-meta))
;=> {:ns #<Namespace user>,
     :name testing-meta,
     :file "NO_SOURXE_FILE",
     :line 1, :arglists ([]),
     :console true,
     :safe true,
     :doc "testing metadata for functions"}
