//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;





public class Job extends Thing implements Runnable,ActionListener{
    
    double duration;
    ArrayList<String> requirements;
    
    ////////////////////////////////////////////////////////
    enum Status {RUNNING, SUSPENDED, WAITING, DONE};
    public Dock dock;
    public JButton cancelButton = new JButton("Cancel Job");
    public JButton startButton = new JButton("Start Job");
    public Job currentJob = null;
    public volatile boolean runJob = false;
    public volatile boolean cancelJob = false;
    public long jobTime = 0;
    Status status = Status.SUSPENDED;
    boolean goFlag = true;
    boolean noKillFlag = true;
    JProgressBar progressBar;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            this.cancelJob = true;
            this.runJob = false;
            noKillFlag = false;
            cancelButton.setBackground (Color.red);
            goFlag= false;
        } else if (e.getSource() == startButton) {
        	 goFlag = !goFlag; // ND; should be synced, and notify waiting sync in running loop
        }
    }

    @Override
    public void run() {
        
        
        long currentTime = System.currentTimeMillis();
        long startTime = currentTime;
        long stopTime = (long) (currentTime + 1000 * duration);
        //System.out.println("Stop time: " + stopTime);
        double duration = stopTime - currentTime;
        int index =0;
        Thread jobThread = Thread.currentThread();
        while (currentTime < stopTime) {

              if (this.cancelJob && jobThread != null) {
                  jobThread.interrupt();
                  showStatus (Status.SUSPENDED); // should wait here, not busy looop
                 
                  break;
              } else {
                  try {
                       Thread.sleep(1000);
                  } catch (InterruptedException e) {
                  }
                  progressBar.setDoubleBuffered(true);
           
                  progressBar
                          .setValue((int) (((currentTime - startTime) / duration) * 100));
                  currentTime = System.currentTimeMillis();

              }

            } // end runninig

        if (!this.cancelJob) {
            progressBar.setValue(100);
            showStatus (Status.DONE);
        }
            
           
        }
            /*synchronized (worker.party) {
              worker.busyFlag = false; 
              worker.party.notifyAll ();
            }
*/
        
       
    
   
    /////////////////////////////////////////////////////////

    public Job(Scanner sc) {
        super(sc);
        duration=sc.nextDouble(); 
        requirements = new ArrayList<>();
       while(sc.hasNext()){
    	   String s = sc.next();
        	requirements.add(s);
        }
    }

    
    
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public ArrayList<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<String> requirements) {
        this.requirements = requirements;
    }

    void showStatus (Status st) {
        status = st;
        switch (status) {
          case RUNNING:
        	  startButton.setBackground (Color.green);
        	  startButton.setText ("Running");
            break;
          case SUSPENDED:
        	  startButton.setBackground (Color.yellow);
        	  startButton.setText ("Suspended");
            break;
          case WAITING:
        	  startButton.setBackground (Color.orange);
            startButton.setText ("Waiting turn");
            break;
          case DONE:
        	  startButton.setBackground (Color.green);
            startButton.setText ("Done");
            break;
        } // end switch on status
      } // end showStatus
	public void runJob(JPanel panel, String shipName, String jobName,Dock dock) {
		   
		    progressBar = new JProgressBar(1,100);
	        progressBar.setBounds(110,20,200,25);
	        progressBar.setStringPainted(true);
		    panel.add (progressBar);
		    this.dock = dock;
		    
		    panel.add (new JLabel (shipName, SwingConstants.CENTER));
		    panel.add (new JLabel (jobName    , SwingConstants.CENTER));
		    (new Thread (this, shipName + " " + jobName)).start();
		    
		    panel.add (cancelButton);
		    panel.add (startButton);
		    
		    startButton.addActionListener (this);
		    cancelButton.addActionListener (this);
		
	}
    
    
    
}
