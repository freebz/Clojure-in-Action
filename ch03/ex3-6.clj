(meta (defn myfn-attr-map {:a 1} []))
;=> {:arglists ([]), :a 1, :line 1, :column 7, :file "/tmp/form-init3309134914927218291.clj", :name myfn-attr-map, :ns #object[clojure.lang.Namespace 0x3dde2 "user"]}

(meta (defn ^{:a 1} myfn-metadata []))
;=> {:a 1, :arglists ([]), :line 1, :column 7, :file "/tmp/form-init3309134914927218291.clj", :name myfn-metadata, :ns #object[clojure.lang.Namespace 0x3dde2 "user"]}

(meta (defn ^{:a 1} myfn-both {:a 2 :b 3} []))
;=> {:a 2, :arglists ([]), :b 3, :line 1, :column 7, :file "/tmp/form-init3309134914927218291.clj", :name myfn-both, :ns #object[clojure.lang.Namespace 0x3dde2 "user"]}

(meta (defn ^{:a 1 :doc "doc 1"} myfn-redundant-docs "doc 2" {:a 2 :b 3
                                                              :doc "doc 3"} []))
;=> {:a 2, :doc "doc 3", :arglists ([]), :b 3, :line 1, :column 7, :file "/tmp/form-init3309134914927218291.clj", :name myfn-redundant-docs, :ns #object[clojure.lang.Namespace 0x3dde2 "user"]}
