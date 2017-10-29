// Listing 5.1  An abstract Java class that will be used to illustrate gen-class

package com.gentest;
public abstract class AbstractJavaClass {
    public AbstractJavaClass(String a, String b) {
	System.out.println("Constructor: a, b");
    }
    public AbstractJavaClass(String a) {
	System.out.println("Constructor: a");
    }
    public abstract String getCurrentStatus();

    public String getSecret() {
	return "The Secret";
    }
}
