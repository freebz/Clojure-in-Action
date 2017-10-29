(let [p (promise)]
  (future (Thread/sleep 5000)
          (deliver p :done))
  @p)
;=> :done
