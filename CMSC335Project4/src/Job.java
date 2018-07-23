


import java.awt.Component;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class Job extends Thing implements Runnable {
	private Thread thread;
	private  boolean run;
	private JProgressBar progressBar;
	private double duration;
	private ArrayList<String> skills = new ArrayList<>();
	private String status = "Waiting";
	private static World world;

	public Job(Scanner scannerInput, JPanel jobPanel, World world) {
		super(scannerInput);
		Job.world = world;
		

		if (scannerInput.hasNextDouble()) {
			duration = scannerInput.nextDouble();
		}
		if (scannerInput.hasNext()) {
			while (scannerInput.hasNext()) {
				String requirement = scannerInput.next();
				System.out.print(requirement + "  ");
				this.skills.add(requirement);
			}
			System.out.println("\n");
		}
		

		JPanel rowPanel = new JPanel();
		rowPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		BoxLayout rowLayout = new BoxLayout(rowPanel, BoxLayout.X_AXIS);
		rowPanel.setLayout(rowLayout);
		progressBar = new JProgressBar(0, (int) this.getDuration());
		progressBar.setStringPainted(true);
		progressBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		JButton suspendButton = new JButton("Suspend");
		JButton resumeButton = new JButton("Resume");
		JButton stopButton = new JButton("Stop");
		
		suspendButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				run = false;
				try {
					thread.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		resumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				run = true;
				thread.notify();
			}
			
		});
		
		stopButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				run = false;
				thread.interrupt();
				progressBar.setValue(0);
			}
		});
		
		rowPanel.add(new Label(this.getName()));
		rowPanel.add(new Label(String.valueOf(this.getDuration())));
		rowPanel.add(progressBar);
		rowPanel.add(suspendButton);
		rowPanel.add(resumeButton);
		rowPanel.add(stopButton);
		jobPanel.add(rowPanel);
		
		run = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		System.out.println(String.format("Job is running: %s", this.toString()));
		this.status = "Running";
		Ship ship = world.getShipByIndex(this.getParent());
		synchronized (ship) {
			while (run==true && ! this.status.equalsIgnoreCase("Completed") ){
				for (int i = 0; i<=this.duration; i+=1) {
					try {
						this.progressBar.setValue(i);
						Thread.sleep(100);
						this.progressBar.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				this.status = "Completed";
				Dock dock = world.getDockByIndex(ship.getParent()); // Leaves dock when all jobs are completed
				for (int i=0; i<ship.getJobs().size(); i++) {
					if (ship.getJobs().get(i).getName().equalsIgnoreCase(this.name)) {
						ship.getJobs().remove(i);
					}
				}
				if (ship.getJobs().isEmpty()) {
					try {
						SeaPort seaport = world.getSeaPortByIndex(world.getDockByIndex(ship.getParent()).getParent());

						while (!seaport.getQue().isEmpty()) {
							Ship queShip = seaport.getQue().get(seaport.getQue().size()-1); // Gets the ship from queue
							System.out.println(String.format("Current queue in seaport %-17s: %s", seaport.getName(), seaport.getQue().stream().map(s -> s.getName()).collect(Collectors.toList())));
							seaport.getQue().remove(seaport.getQue().size()-1);  // Removes the ship from the queue
							if (! queShip.getJobs().isEmpty()) {
								dock.setShip(queShip); // add ship to dock
								System.out.println(String.format("Assigning ship %s to dock %s", queShip.getName(), dock.getName()));
							}
							else { // no jobs left for this ship, so it sails
								System.out.println(String.format("No jobs remaining for ship %s. Leaving Dock.", queShip.getName()));
							}
						}
						System.out.println(String.format("Current queue in seaport %-17s: %s", seaport.getName(), seaport.getQue().stream().map(s -> s.getName()).collect(Collectors.toList()))); 
						
					} catch (NullPointerException e) {}
				}
			}
			
			System.out.println(String.format("Remaining jobs in ship %-20s:%1d", ship.getName(), ship.getJobs().size()));
			if (ship.getJobs().isEmpty()) { // Last set of ships leave
				System.out.println(String.format("No jobs remaining for ship %s. Sailing out.", ship.getName()));
			}
		}
		
		
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
	
	public String toString() {
		return String.format("Job: (%s, skills: %s)", super.toString(), this.skills);
	}



}
