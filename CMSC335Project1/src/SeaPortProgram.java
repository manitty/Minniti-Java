//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SeaPortProgram extends javax.swing.JFrame {

	//instance variables
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
                }                    
            }
            
            output.setText(world.toString());
        } 
        catch (Exception e) 
        {
            System.out.println(e+"-----");
        }
    }
    
    //Method to initialize the form.   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        index = new javax.swing.JRadioButton();
        name = new javax.swing.JRadioButton();
        skill = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        sortData = new javax.swing.JButton();

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

        buttonGroup1.add(skill);
        skill.setText("Skill");

        output.setColumns(20);
        output.setRows(5);
        jScrollPane2.setViewportView(output);

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        sortData.setText("Sort");
        sortData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDataActionPerformed(evt);
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(index)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(skill)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jButton2)
                    .addComponent(sortData))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    //search Method
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(index.isSelected())
        {
            try
            {
                  int ind=Integer.parseInt(search.getText());
                  output.setText("");
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
                                out+=d.toString()+"\n";
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
                                flag=true;
                                break;
                            }
                        }
                        if(flag) break;
                  }
                  output.setText(out);
                  
            }
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
          
                
            }
            else if(skill.isSelected())
           {
                String skillString=search.getText();
                output.setText("");
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
                        }
                    }
                }
                output.setText(out);
           }
            else if(name.isSelected())
            {
                  String nameString=search.getText();
                  output.setText("");
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
                            }
                        }
                        
                        ArrayList<Ship> sArr=s.getShips();
                        for(Ship d:sArr)
                        {
                            if(d.getName().equalsIgnoreCase(nameString))
                            {
                                out+=d.toString()+"\n";
                            }
                        }
                        ArrayList<Ship> qArr=s.getQue();
                        for(Ship d:qArr)
                        {
                            if(d.getName().equalsIgnoreCase(nameString))
                            {
                                out+=d.toString()+"\n";
                            }
                        }
                        ArrayList<Person> pArr=s.getPersons();
                        for(Person d:pArr)
                        {
                            if(d.getName().equalsIgnoreCase(nameString))
                            {
                                out+=d.toString()+"\n";
                            }
                        }
                  }
                  output.setText(out);
            }
        
    }

   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        search.setText("");
        output.setText("");
    }
    
    //sort Method
    private void sortDataActionPerformed(java.awt.event.ActionEvent evt) {
        
        for(SeaPort s:world.getPorts())
        {
            Collections.sort(s.getDocks(),new NameComparator());
            Collections.sort(s.getPersons(),new NameComparator());
            Collections.sort(s.getShips(),new NameComparator());
            Collections.sort(s.getQue(),new QueComparator());
        }
        output.setText(world.toString());
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
                new SeaPortProgram().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton index;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton name;
    private javax.swing.JTextArea output;
    private javax.swing.JTextField search;
    private javax.swing.JRadioButton skill;
    private javax.swing.JButton sortData;
   
}
