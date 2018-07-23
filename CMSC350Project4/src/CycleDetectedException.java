//File name: CycleDetectedException.java
//Author: Paul Minniti
//Date: 7 May 2017
/* Purpose: Implements an Exception for when there is a cycle detected within the inputted graph
 */

public class CycleDetectedException extends RuntimeException {
    private String cycleVert = "";

    /*
     * Creates a new instance of CycleDetectedException without
     * detail message.
     */
    public CycleDetectedException() {
    }
    
    /*
     * Constructs an instance of CycleDetectedException with the
     * specified detail message
     */
    public CycleDetectedException(String vertName) {
        cycleVert = vertName;
    }
  
    public String getCycleVertex() {
        return cycleVert;
    }
}