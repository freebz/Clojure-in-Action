(def mock-calls (atom {}))

(defn stub-fn [the-function return-value]
  (swap! mock-calls assoc the-function [])
  (fn [& args]
    (swap! mock-calls update-in [the-function] conj args)
    return-value))


(defmacro stubbing [stub-forms & body]
  (let [stub-paris (partition 2 stub-forms)
        real-fns (map first stub-pairs)
        returns (map last stub-pairs)
        stub-fns (map #(list `stub-fn %1 %2) real-fns returns)]
    `(with-redefs [~@(interleave real-fns stub-fns)]
       ~@body)))
