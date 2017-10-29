import clojure.lang.RT;
import clojure.lang.Var;

public class Driver {
    public static void main(Sring[] args) throws Exception {
	RT.loadResourceScript("clojure_script.clj");
	Var report = RT.var("clj.script.examples", "print-report");
	Integer result = (Integer) report.invoke("Siva");
	System.out.println("Result: " + result);
    }
}
