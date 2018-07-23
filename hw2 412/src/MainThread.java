//Homework2
// Author: Paul Minniti
// Date: 9-3-2017
//Details: A Class that holds the variables for thread timing 

public abstract class MainThread extends Thread{
     protected long time;
     protected long startTime;
     public abstract long getTime();
     public abstract long getStartTime();
}
