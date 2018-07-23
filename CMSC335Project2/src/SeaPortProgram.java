//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

@SuppressWarnings("serial")
public class SeaPortProgram extends javax.swing.JFrame implements TreeSelectionListener {

	//instance variables
	protected JTree myWorldTree;
	protected DefaultMutableTreeNode rootNode;
    protected DefaultTreeModel treeModel;
    
     private javax.swing.ButtonGroup buttonGroup1;
     private javax.swing.JRadioButton index;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
    // private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JScrollPane scrollRun;
     private javax.swing.JScrollPane scrollPane;
     private javax.swing.JRadioButton name;
     private javax.swing.JTextArea output;
     private javax.swing.JTextField search;
     private javax.swing.JRadioButton skill;
     private javax.swing.JRadioButton weight;
     private javax.swing.JRadioButton length;
     private javax.swing.JRadioButton width;
     private javax.swing.JRadioButton draft;
     private javax.swing.JButton sortData;
     private JPanel panel2;
    
     World world=new World(null);
     
     //constructor
    public SeaPortProgram() {
        JFileChooser jf=new JFileChooser(".");
        jf.showOpenDialog(null);
        jf.setVisible(true);
        File f=jf.getSelectedFile();
        if(f!=null)
        {
            initComponents();
            readFile(f);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error: You didn't choose a file.","Error",1);
        }
    }

    //Read File Method
    public void readFile(File f)
    {
        try 
        {
            BufferedReader input=new BufferedReader(new FileReader(f));
            HashMap<Integer,Ship> hashmap=new HashMap<>();
            
            while(input.ready())
            {
                String str=input.readLine().trim();
                Scanner sc=new Scanner(str);
                
                if(!str.startsWith("//"))
                {
                    String type="";
                    if(sc.hasNext())
                    {
                        type=sc.next();
                    }
                    
                    if(type.equalsIgnoreCase("port"))
                    {
                         world.assignPort(new SeaPort(sc));
                    }
                    else if(type.equalsIgnoreCase("dock"))
                    {
                          world.assignDock(new Dock(sc));
                    }
                    else if(type.equalsIgnoreCase("ship"))
                    {
                          Ship s=new Ship(sc);
                          hashmap.put(s.getIndex(), s);
                          world.assignShip(s);
                    }
                    else if(type.equalsIgnoreCase("pship"))
                    {
                        Ship s=new PassengerShip(sc);
                        hashmap.put(s.getIndex(), s);
                        world.assignShip(s);
                    }
                    else if(type.equalsIgnoreCase("cship"))
                    {
                        Ship s=new CargoShip(sc);
                        hashmap.put(s.getIndex(),s);
                        world.assignShip(s);
                    }
                    else if(type.equalsIgnoreCase("person"))
                    {
                       world.assignPerson(new Person(sc));
                    }
                    else if (type.equalsIgnoreCase("job")) 
                    {
                        Job job = new Job(sc);
                        world.assignJob(job,hashmap,panel2);
                         
                     }
                }                    
            }
            
            createTree();
        } 
        catch (Exception e) 
        {
            System.out.println(e+"-----");
        }
    }
    
    public void createTree(){
        DefaultTreeModel model = (DefaultTreeModel)myWorldTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        DefaultMutableTreeNode portCat = (DefaultMutableTreeNode)model.getChild(root,0);

        for (SeaPort tempPort : world.ports){
            DefaultMutableTreeNode portLits = new DefaultMutableTreeNode("Port: " + tempPort.getName());
           
            portCat.add(portLits);
            for (Dock tempDock : tempPort.docks){
                DefaultMutableTreeNode dockList = new DefaultMutableTreeNode("Dock: " + tempDock.getName());
               // DefaultMutableTreeNode dockList = new DefaultMutableTreeNode("Dock: " + tempDock);
                portLits.add(dockList);
               // dockList.add(new DefaultMutableTreeNode("Ship: " + tempDock.getShip().getName()));
                dockList.add(new DefaultMutableTreeNode("Ship: " + tempDock.getShip()));
            }
            for (Person tempPerson : tempPort.persons){
               // DefaultMutableTreeNode peopleList = new DefaultMutableTreeNode("Person: " + tempPerson.getName());
                DefaultMutableTreeNode peopleList = new DefaultMutableTreeNode("Person: " + tempPerson);
                portLits.add(peopleList);
            }
            for (Ship tempShip : tempPort.que){
                DefaultMutableTreeNode shipList = new DefaultMutableTreeNode("Ship: " + tempShip.getName());
                //DefaultMutableTreeNode shipList = new DefaultMutableTreeNode("Ship: " + tempShip);
                portLits.add(shipList);
            }


        }
        model.reload(root);

    }

    
    //Method to initialize the form.   
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	panel2 = new JPanel(new GridLayout (0, 5));
	    scrollRun = new JScrollPane (panel2);
        buttonGroup1 = new javax.swing.ButtonGroup();
        search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        index = new javax.swing.JRadioButton();
        name = new javax.swing.JRadioButton();
        skill = new javax.swing.JRadioButton();
        scrollPane = new javax.swing.JScrollPane();
        
        weight = new javax.swing.JRadioButton();
        length = new javax.swing.JRadioButton();
        width = new javax.swing.JRadioButton();
        draft = new javax.swing.JRadioButton();
        
        //jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        sortData = new javax.swing.JButton();
        
        rootNode = new DefaultMutableTreeNode("The World");
        DefaultMutableTreeNode category = null;
        category = new DefaultMutableTreeNode("Ports");
        rootNode.add(category);
        myWorldTree = new JTree(rootNode);
        myWorldTree.setEditable(true);
        myWorldTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        myWorldTree.addTreeSelectionListener(this);
        JScrollPane treeView = new JScrollPane(myWorldTree);
        treeView.setViewportView(myWorldTree);
        treeView.setWheelScrollingEnabled(true);
        scrollPane.setViewportView(treeView);
        JSplitPane jsp = new JSplitPane (JSplitPane.VERTICAL_SPLIT, scrollPane, scrollRun);
	    jsp.setDividerLocation (100);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(index);
        index.setText("Index");

        buttonGroup1.add(name);
        name.setText("Name");

        buttonGroup1.add(draft);
        draft.setText("Draft");
        
        buttonGroup1.add(weight);
        weight.setText("Weight");
        
        buttonGroup1.add(length);
        length.setText("Length");
        
        buttonGroup1.add(width);
        width.setText("Width");
        
        buttonGroup1.add(skill);
        skill.setText("Skill");

        //output.setColumns(20);
        //output.setRows(5);
       // jScrollPane2.setViewportView(output);

       

        sortData.setText("Sort");
        sortData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDataActionPerformed(evt);
            }

			private void sortDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortDataActionPerformed
        
        for(SeaPort s:world.getPorts())
        {
            Collections.sort(s.getDocks(),new NameComparator());
            Collections.sort(s.getPersons(),new NameComparator());
            Collections.sort(s.getShips(),new NameComparator());
            Collections.sort(s.getQue(),new QueComparator());
        }
    //    output.setText(world.toString());
        DefaultTreeModel model = (DefaultTreeModel)myWorldTree.getModel();
        DefaultMutableTreeNode root =(DefaultMutableTreeNode)model.getRoot();
        DefaultMutableTreeNode portCat = (DefaultMutableTreeNode)model.getChild(root,0);
        portCat.removeAllChildren();
        createTree();
    }//GEN-LAST:event_sortDataActionPerformed
        });
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jsp, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(index)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(skill)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(weight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(length)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(width)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(draft)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sortData))
                            	.addComponent(search))
                     
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(index)
                    .addComponent(name)
                    .addComponent(skill)
                    .addComponent(weight)
                    .addComponent(length)
                    .addComponent(width)
                    .addComponent(draft)                   
                    .addComponent(jButton2)
                    .addComponent(sortData))
                .addGap(7, 7, 7)
                .addComponent(jsp, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   	 DefaultTreeModel model = (DefaultTreeModel)myWorldTree.getModel();
        DefaultMutableTreeNode root =(DefaultMutableTreeNode)model.getRoot();
        DefaultMutableTreeNode portCat = (DefaultMutableTreeNode)model.getChild(root,0);
        portCat.removeAllChildren();
        DefaultMutableTreeNode portLits =  null;
       if(index.isSelected())
       {
       	
            
           try
           {
                 int ind=Integer.parseInt(search.getText());
            //     output.setText("");
                 String out="";
                 ArrayList<SeaPort> arr=world.getPorts();
                 for(SeaPort s:arr)
                 {
                       boolean flag=false;
                       ArrayList<Dock> dArr=s.getDocks();
                       for(Dock d:dArr)
                       {
                           if(d.getIndex()==ind)
                           {
                               out+=d.toString()+"\n";
                               portLits = new DefaultMutableTreeNode("Dock: " + d);
                               flag=true;
                               break;
                           }
                       }
                       if(flag) break;
                       
                       ArrayList<Ship> sArr=s.getShips();
                       for(Ship d:sArr)
                       {
                           if(d.getIndex()==ind)
                           {
                               out+=d.toString()+"\n";
                               portLits = new DefaultMutableTreeNode("Ship: " + d);
                               flag=true;
                               break;
                           }
                       }
                       if(flag) break;
                       ArrayList<Ship> qArr=s.getQue();
                       for(Ship d:qArr)
                       {
                           if(d.getIndex()==ind)
                           {
                              // out+=d.toString()+"\n";
                           	 portLits = new DefaultMutableTreeNode("Ship: " + d);
                               flag=true;
                               break;
                           }
                       }
                       if(flag) break;
                       ArrayList<Person> pArr=s.getPersons();
                       for(Person d:pArr)
                       {
                           if(d.getIndex()==ind)
                           {
                               out+=d.toString()+"\n";
                               portLits = new DefaultMutableTreeNode("Person:" + d);
                               flag=true;
                               break;
                           }
                       }
                       if(flag) break;
                 }
             //    output.setText(out);
                 
           }
           catch (Exception e) 
           {
               System.out.println(e.getMessage());
           }
           portCat.add(portLits);
               
           }
           else if(skill.isSelected())
          {
               String skillString=search.getText();
            //   output.setText("");
               String out="";
               ArrayList<SeaPort> arr=world.getPorts();
               for(SeaPort s:arr)
               {
                   ArrayList<Person> pArr=s.getPersons();
                   for(Person p:pArr)
                   {
                       if(p.getSkills().equalsIgnoreCase(skillString))
                       {
                           out+=p.toString()+"\n";
                           portLits = new DefaultMutableTreeNode("Person:" + p);
                       }
                   }
               }
               portCat.add(portLits);
           //    output.setText(out);
          }
           else if(name.isSelected())
           {
                 String nameString=search.getText();
            //     output.setText("");
                 String out="";
                 ArrayList<SeaPort> arr=world.getPorts();
                 for(SeaPort s:arr)
                 {
                       ArrayList<Dock> dArr=s.getDocks();
                       for(Dock d:dArr)
                       {
                           if(d.getName().equalsIgnoreCase(nameString))
                           {
                               out+=d.toString()+"\n";
                               portLits = new DefaultMutableTreeNode("Dock:" + d);
                           }
                       }
                       
                       ArrayList<Ship> sArr=s.getShips();
                       for(Ship d:sArr)
                       {
                           if(d.getName().equalsIgnoreCase(nameString))
                           {
                               out+=d.toString()+"\n";
                               portLits = new DefaultMutableTreeNode("Ship:" + d);
                           }
                       }
                       ArrayList<Ship> qArr=s.getQue();
                       for(Ship d:qArr)
                       {
                           if(d.getName().equalsIgnoreCase(nameString))
                           {
                               out+=d.toString()+"\n";
                               portLits = new DefaultMutableTreeNode("Ship:" + d);
                           }
                       }
                       ArrayList<Person> pArr=s.getPersons();
                       for(Person d:pArr)
                       {
                           if(d.getName().equalsIgnoreCase(nameString))
                           {
                               out+=d.toString()+"\n";
                               portLits = new DefaultMutableTreeNode("Person:" + d);
                           }
                       }
                 }
                 portCat.add(portLits);
              //   output.setText(out);
           }
       model.reload(root);
   }
    
    //Main Method
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SeaPortProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeaPortProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeaPortProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeaPortProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               SeaPortProgram sp = new SeaPortProgram();
               sp. setSize(1800,1800);
               sp .setVisible(true);
            }
        });
    }

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

  
   
}
