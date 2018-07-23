
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
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
public class SeaPortProgram extends javax.swing.JFrame implements TreeSelectionListener{

// initialize topButtons, index, searchBar, 
	protected JTree myWorldTree;
	protected DefaultMutableTreeNode rootNode;
    protected DefaultTreeModel treeModel;
    private javax.swing.ButtonGroup topButtons;
    private javax.swing.JRadioButton index;
    private javax.swing.JButton searchBar;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollRun;
    private javax.swing.JRadioButton name;
  //  private javax.swing.JTextArea output;
    private javax.swing.JTextField search;
    private javax.swing.JRadioButton skill;
    private javax.swing.JButton sortData;
    private JPanel panel2;

     World world=new World(null);

    public SeaPortProgram() {
        JFileChooser jf=new JFileChooser(".");
        jf.showOpenDialog(null);
        jf.setVisible(true);
       
        File f=jf.getSelectedFile();
        if(f!=null)
        {
            txtEntry();
            txtFile(f);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error: You didn't choose a file.","Error",1);
        }
    }

    
    public void txtFile(File f)
    {
        try 
        {
            @SuppressWarnings("resource")
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
                    else if (type.equalsIgnoreCase("job")) {
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
        //DefaultTreeModel model = (DefaultTreeModel) myWorldTree.getModel();
        //DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        //model.insertNodeInto(new DefaultMutableTreeNode("another_child"), root, root.getChildCount());


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

    
    private void txtEntry() {

    	panel2 = new JPanel(new GridLayout (0, 5));
	    scrollRun = new JScrollPane (panel2);
        topButtons = new javax.swing.ButtonGroup();
        search = new javax.swing.JTextField();
        searchBar = new javax.swing.JButton();
        sortData = new javax.swing.JButton();
        index = new javax.swing.JRadioButton();
        name = new javax.swing.JRadioButton();
        skill = new javax.swing.JRadioButton();
        scrollPane = new javax.swing.JScrollPane();
        
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
        searchBar.setText("Search");
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        topButtons.add(index);
        // sets the name "Index" of the button
        index.setText("Index");
        topButtons.add(name);
     // sets the name "Name" of the button
        name.setText("Name");

        topButtons.add(skill);
     // sets the name "Skill" of the button
        skill.setText("Skill");

      //  output.setColumns(5);
     //   output.setRows(10);
     //   scrollPane.setViewportView(output);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jsp, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(index)
                                .addComponent(name)
                                .addComponent(skill)
                            .addComponent(search)
                            .addComponent(sortData)))
                        
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchBar)))));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(index)
                    .addComponent(name)
                    .addComponent(skill)
                    )
                .addComponent(jsp, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
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
            }
        model.reload(root);
    }

   

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

		
	}


    
}
