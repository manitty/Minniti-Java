
 /*
 a thread class that runs an IO intensive operation.
You can write to the system out a number of times (ie 1000) or 
do something like read and write a file. 
 */
 
public class IOThread1 extends UserThread{
   
    @Override
    public void run() {
        startTime = System.nanoTime();
        for(int i=0;i<1000;i++) {
            System.out.println(this.getName()+" Current iterations: "+i);
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
