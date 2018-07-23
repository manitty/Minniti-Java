//File name: InvalidClassNameException.java
//Author: Paul Minniti
//Date: 7 May 2017
/*
Purpose: Implements an Exception for when the user inputs the name of a class
not found in the graph. The illegalCLass field allows the GUI to pull the
offending class name.
*/
public class InvalidClassNameException extends RuntimeException {
    private String illegalClass = "";

    /*
     * Creates a new instance of CycleDetectedException without
     * detail message.
     */
    public InvalidClassNameException() {
    }
    
    /*
     * Constructs an instance of CycleDetectedException with the
     * specified detail message.
     */
    public InvalidClassNameException(String className) {
        illegalClass = className;
    }
  
    public String getClassName() {
        return illegalClass;
    }
}