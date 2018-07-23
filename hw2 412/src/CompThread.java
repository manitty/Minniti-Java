//Homework2
// Author: Paul Minniti
// Date: 9-3-2017
//Details: A thread class that runs an Computationally intensive operation.

public class CompThread extends MainThread{


    @Override
    public void run() {

        startTime = System.nanoTime();
        for(int i=0;i<51;i++) {
            System.out.println(this.getName()+"- iteration: "+i +" Computation:" + calc(i) );
        }

         time = System.nanoTime()-startTime;
    }


    long calc(int n) {

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calc(n - 1);
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
