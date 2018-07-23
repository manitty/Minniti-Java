 
public abstract class UserThread extends Thread{
     protected long time;
     protected long startTime;
     public abstract long getTime();
     public abstract long getStartTime();
}
