(defmacro defsegment [segment-name & body]
  (let [transfromed (postwalk transform-lookups body)]
    `(let [segment-fn# (fn [] ~@transformed)]
       (register-segment ~(keyword segment-name) segment-fn#))))
