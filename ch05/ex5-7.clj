(import 'java.awt.event.MouseAdapter)
(proxy [MouseAdapter] []
  (mousePressed [event]
    (println "Hey!")))


(reify java.io.FileFilter
  (accept [this f]
    (.isDirectory f)))

