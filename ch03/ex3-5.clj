(defn total-cost [item-cost number-of-items]
  (* item-cost number-of-items))


(defn total-cost
  "return line-tiem total of the item and quantity provided"
  [item-cost number-of-items]
  (* item-cost number-of-items))


(meta #'total-cost)
;=> {:arglists ([item-cost number-of-items]), :doc "return line-tiem total of the item and quantity provided", :line 1, :column 1, :file "/tmp/form-init7267192605138100454.clj", :name total-cost, :ns #object[clojure.lang.Namespace 0x7aeb8f "user"]}


(doc total-cost)
-------------------------
user/total-cost
([item-cost number-of-items])
return line-tiem total of the item and quantity provided
;=> nil
