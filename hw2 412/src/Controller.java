//Homework2
// Author: Paul Minniti
// Date: 9-3-2017
//Details: A class that acts as a controller for the threads.

import java.util.ArrayList;
import java.util.Collections;

public class Controller{
  public static void main(String[] args) throws InterruptedException{

	//Instance Variables  
    final int THREAD_COUNT = 10;
    long IO_Thread_Start[]= calculateTime(create(THREAD_COUNT,true), false);
    long IO_Thread_Stop[]= calculateTime(create(THREAD_COUNT,true), false);
    long Comp_Thread_Start[]= calculateTime(create(THREAD_COUNT,true), false);
    long Comp_Thread_Stop[]= calculateTime(create(THREAD_COUNT,true), false);
    long start[]=new long[20];
    long IO_Wait_Time=0;
    long Comp_Wait_Time=0;
    
   //Initializes the threads and sets their names
    MainThread thread[]=new MainThread[20];
    for(int i=0;i<20;i++){
      if(i<10){
        thread[i]=new IOThread();
        thread[i].setName("IOThread: "+(i+1));
      }
      else{
        thread[i]=new CompThread();
        thread[i].setName("CompThread: "+(i+1-10));
      }
    }

  //Randomizing the Threads 
    ArrayList<Integer> indexes=new ArrayList<>();
    for(int i=0;i<20;i++){
      indexes.add(i);
    }
    Collections.shuffle(indexes);

    //Start the threads
    for(Integer i:indexes){
      start[i]=System.nanoTime();
      thread[i].start();
      thread[i].join();
    }

    //calculates timing 
    for(Integer i:indexes){
      if(thread[i] instanceof IOThread){
        IO_Wait_Time+=thread[i].getStartTime()-start[i];
      }
      else{
        Comp_Wait_Time+=thread[i].getStartTime()-start[i];
      }
    }
    
    System.out.println("\n");
    
    //prints the total wait time for each individual thread 
    for(Integer i:indexes){
      System.out.println("Wait time for "+thread[i].getName()+" is : "+(thread[i].getStartTime()-start[i]));
    }
    
    //prints the average wait time for each thread type
    System.out.println("\n");
    System.out.println("Average wait time for IOThreads : "+ IO_Wait_Time/10);
    System.out.println("Average wait time for ComputationalThreads : "+ Comp_Wait_Time/10);

    long runTime=0;
    for(int i=0;i<20;i++)
    {
      runTime+=thread[i].getTime();
    }

    System.out.println("Overall run time : "+runTime);

  }

//Calculates the compute time for each thread
  public static long[] calculateTime(MainThread thread[], boolean sheduled) throws InterruptedException {


    long time[] = new long[thread.length];
    for (int i = 0; i < thread.length; i++) {
      if (sheduled) {
        thread[i].setPriority(i + 1);
      }
      thread[i].start(); //calls run method internally
      thread[i].join();
    }

    for (int i = 0; i < thread.length; i++) {
      time[i] = thread[i].getTime();

    }
    return time;
  }

//creates the threads
  public static MainThread[] create(int length, boolean isIOThread) {
	  MainThread thread[];
    if (isIOThread) {
      thread = new IOThread[length];
      for (int i = 0; i < length; i++) {
        thread[i] = new IOThread();
        thread[i].setName("IOThread " + (i + 1));
      }
    } else {
      thread = new CompThread[length];
      for (int i = 0; i < length; i++) {
        thread[i] = new CompThread();
        thread[i].setName("CompThread " + (i + 1));
      }
    }
    return thread;
  }
}
