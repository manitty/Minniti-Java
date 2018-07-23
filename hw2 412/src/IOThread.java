//Homework2
// Author: Paul Minniti
// Date: 9-3-2017
//Details: A thread class that runs an IO intensive operation.

public class IOThread extends MainThread{

     @Override
     public void run() {
         startTime = System.nanoTime();
         for(int i=0;i<51;i++) {
             System.out.println(this.getName()+"- iteration: "+i);
         }
          time = System.nanoTime()-startTime;
     }

     @Override
     public long getTime() {
         return time;
     }

     public long getStartTime() {
         return startTime;
     }


}
