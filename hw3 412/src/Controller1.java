
import java.util.ArrayList;
import java.util.Collections;

/*
 a controller class that instantiates 5 objects of each class and runs each object.
2) Take the start and stop time for each thread and print out the time it takes to run.
3) Take the start and stop time to schedule and run all the threads and print out the time to run.
4) Run the program a couple of times.
 */
public class Controller1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        final int NUM_THREADS = 5;
       
        long ioThreadsTime1[] = calculateTime(create(NUM_THREADS,true), false);
        long compThreadsTime1[] = calculateTime(create(NUM_THREADS,false), false);
        //calculate time with scheduling
        long ioThreadsTime2[] = calculateTime(create(NUM_THREADS,true), true);
        long compThreadsTime2[] = calculateTime(create(NUM_THREADS,false), true);

        System.out.println("****Without Scheduling******");
        System.out.println("IO Threads time::");
        display(ioThreadsTime1);
        System.out.println("Computationally intensive Threads time::");
        display(compThreadsTime1);
        System.out.println("\n\n****With Scheduling******");
        System.out.println("IO Threads time::");
        display(ioThreadsTime2);
        System.out.println("Computationally intensive Threads time::");
        display(compThreadsTime2);
         
        UserThread threads[]=new UserThread[10];
        for(int i=0;i<10;i++)
        {
            if(i<5)
            {
                threads[i]=new IOThread1();
                threads[i].setName("IOThread : "+(i+1));
            }
            else
            {
                threads[i]=new ComputationThread2();
                threads[i].setName("ComputationThread : "+(i+1-5));
            }
        }
        
         
        //create an arraylist of index shuffle it to make threads random
        ArrayList<Integer> indexes=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            indexes.add(i);
        }
        
        //shuffle
        Collections.shuffle(indexes);
        
                
        
        long starts[]=new long[10];
        //run 
        for(Integer i:indexes)
        {
            starts[i]=System.nanoTime();
            threads[i].start();
            threads[i].join();
        }
        
        //calculate waiting time 
        long waitTimeForIO=0;
        long waitTimeForCom=0;
        

        for(Integer i:indexes)
        {
            if(threads[i] instanceof IOThread1)
            {
                waitTimeForIO+=threads[i].getStartTime()-starts[i];
            }
            else
            {
                waitTimeForCom+=threads[i].getStartTime()-starts[i];
            }
        }
        
                System.out.println("\n");

        for(Integer i:indexes){
                  System.out.println("Wait time for "+threads[i].getName()+" is : "+(threads[i].getStartTime()-starts[i]));
        }
        
        
        System.out.println("\n");
        System.out.println("Average wait time for IOThreads : "+waitTimeForIO/5);
        System.out.println("Average wait time for ComputationalThreads : "+waitTimeForCom/5);
        
        long runTime=0;
        for(int i=0;i<10;i++)
        {
            runTime+=threads[i].getTime();
        }
        
        System.out.println("Overall run time : "+runTime);
        
         
    }

    /**
     * method to calculate time taken by each thread
     *
     * @param thread
     * @param shedule
     * @return
     * @throws InterruptedException
     */
    public static long[] calculateTime(UserThread thread[], boolean sheduled) throws InterruptedException {

        
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

    /**
     * method to create the threads
     * @param length
     * @param isIOThread
     * @return 
     */
    public static UserThread[] create(int length, boolean isIOThread) {
        UserThread thread[];
        if (isIOThread) {
            thread = new IOThread1[length];
            for (int i = 0; i < length; i++) {
                thread[i] = new IOThread1();
                thread[i].setName("IOThread " + (i + 1));
            }
        } else {
            thread = new ComputationThread2[length];
            for (int i = 0; i < length; i++) {
                thread[i] = new ComputationThread2();
                thread[i].setName("ComputationThread " + (i + 1));
            }
        }
        return thread;
    }

    /**
     * method to display running times
     *
     * @param time
     */
    public static void display(long time[]) {
        for (int i = 0; i < time.length; i++) {
            System.out.println("\tThread " + (i + 1) + ": Total time(nanoTime) - " + time[i]);
        }
    }
}
