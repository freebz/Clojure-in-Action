(def bad-agent (agent 10))


(send bad-agent / 0)
;=> #object[clojure.lang.Agent 0x1022cc4 {:status :failed, :val 10}]


(deref bad-agent)
;=> 10


(send bad-agent / 2)
; CompilerException java.lang.RuntimeException: Agent is failed, needs restart, compiling:(/home/freebz/work/Clojure in Action/ch06/ex6-5.clj:9:1)


(agent-error bad-agent)
;=>        :cause "Divide by zero"


(clear-agent-errors bad-agent)
