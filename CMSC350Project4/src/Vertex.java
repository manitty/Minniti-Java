//File name: Vertex.java
//Author: Paul Minniti
//Date: 7 May 2017
/* Purpose: Implements the methods and fields necessary to create a class for
 *  a vertex in a directed graph
 */

import java.util.*;

public class Vertex<T> {
    private ArrayList<Vertex<T>> children;
    private T value;
    private boolean discovered = false;
    private boolean finished = false;
  
    public Vertex(T value) {
        this.value = value;
        children = new ArrayList<>();
    }
  
    public Vertex(T value, ArrayList<Vertex<T>> children) {
        this.value = value;
        this.children = children;
    }
  
    public void addChild(Vertex child) {
        children.add(child);
    }
  
    public ArrayList<Vertex<T>> getChildren() {
        return children;
    }
  
    public T getValue() {
        return value;
    }
  
    public boolean hasChildren() {
        return (children.size() > 0);
    }
  
    public boolean isDiscovered() {
        return discovered;
    }
  
    public boolean isFinished() {
        return finished;
    }
  
    public void setDiscovered() {
        discovered = true;
    }
  
    public void setFinished() {
        finished = true;
    }
  
    // Resets the discovered and finished flags
    public void reset() {
        discovered = false;
        finished = false;
    }

}