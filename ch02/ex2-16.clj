(as-> {"a" [1 2 3 4]} <>
  (<> "a")
  (conj <> 10)
  (map inc <>))
;=> (2 3 4 5 11)


(let [<> {"a" [1 2 3 4]}
      <> (<> "a")
      <> (conj <> 10)
      <> (map inc <>)]
  <>)


(let [x 1 y 2]
  (cond-> []
    (odd? x)          (conj "x is odd")
    (zero? (rem y 3)) (conj "y is divisible by 3")
    (even? y)         (conj "y is even")))
;=> ["x is odd" "y is even"]


(let [x 1 y 2]
  (as-> [] <>
    (if (odd? x)          (conj <> "x is odd")            <>)
    (if (zero? (rem x 3)) (conj <> "y is divisible by 3") <>)
    (if (even? y)         (conj <> "y is even")           <>)))
;=> ["x is odd" "y is even"]
