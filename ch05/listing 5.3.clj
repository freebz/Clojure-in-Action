;; Listing 5.3  Leiningen project file for ConcreteClojureClass

(defproject gentest "0.1.0"
  :dependencies [[org.clojure/clojure "1.6.0"]]

  ; Place our "AbstractJavaClass.java" and "gen-clojure.clj" files under
  ; the src/com/gentest directory.
  :source-paths ["src"]
  :java-source-path ["src"]

  ; :aot is a list of clojure namespaces to compile.
  :aot [com.gentest.gen-clojure]

  ; This is the java class "lein run" should execute.
  :main com.gentest.ConcreteClojureClass)
  
