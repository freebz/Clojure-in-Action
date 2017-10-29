(def a-ref (ref 0))
(def an-agent (agent 0))
(def an-atom (atom 0))


(deref a-ref)
(deref an-agent)
(deref an-atom)


@a-ref
@an-agent
@an-atom
