/**
 *  a thread class that runs a computationally intensive operation. 
 * You can perform some math computation a number of 
times.
 * @author 
 */
public class ComputationThread2 extends UserThread{
    @Override
    public void run() {
        
        startTime = System.nanoTime();
        for(int i=0;i<100;i++) {
            //not printing
            //just calculating as it is computationally intensive operation
            factorial(i);
        }
         //difference - time taken
         time = System.nanoTime()-startTime;
    }
    
   // calculating factorial
   long factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }
   
    @Override
    public long getTime() {
        return time;
    }
    
     public long getStartTime() {
        return startTime;
    }
}
