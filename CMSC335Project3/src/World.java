
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JPanel;


public class World extends Thing{
    
    ArrayList<SeaPort> ports;
    PortTime time;
    HashMap<Integer,Ship> hashmap;
   
    public World(Scanner sc) {
        super(sc);
        ports=new ArrayList<>();
    }

    public ArrayList<SeaPort> getPorts() {
        return ports;
    }

    public void setPorts(ArrayList<SeaPort> ports) {
        this.ports = ports;
    }

    public PortTime getTime() {
        return time;
    }

    public void setTime(PortTime time) {
        this.time = time;
    }
    
     Ship getShipByIndex (int x,HashMap<Integer,Ship> hms) {
      if(hms.containsKey(x))
      {
          return hms.get(x);
      }
      return null;
   }
    
     
   Dock getDockByIndex(int x)
   {
       for (SeaPort msp: ports)
         for (Dock ms: msp.docks)
            if (ms.index == x) 
               return ms;
      return null;
   }// end getDockByIndex
     
   
   SeaPort getSeaPortByIndex(int x)
   {
       for (SeaPort msp: ports)
          if(msp.index==x)
              return msp;
      return null;
   }
   
   void assignShip (Ship ms) {
      Dock md = getDockByIndex(ms.parent);
      if (md == null) {
         SeaPort p=getSeaPortByIndex (ms.parent);
         if(p!=null)
         {
             p.ships.add (ms);
             p.que.add (ms);
         }
         return;
      }
      else
      {
           md.ship = ms;
           getSeaPortByIndex (md.parent).ships.add (ms);
      }
     
      
   } 
   
   void assignJob (Job ms,HashMap hm,JPanel panel) {
	      Ship md = getShipByIndex(ms.parent,hm);
	      if (md == null) {
	         
	         return;
	      }
	      else
	      {
	           md.jobs.add(ms);
	           Dock dock = getDockByIndex(md.parent);
	           ms.runJob(panel,md.getName(), ms.getName(),dock);
	      }
	     
	      
	   } 
   
   void assignPerson(Person p)
   {
       for(SeaPort sp:ports)
       {
           if(sp.getIndex()==p.getParent())
           {
               sp.persons.add(p);
           }
       }
   } 
   
   void assignDock(Dock d)
   {
       for(SeaPort sp:ports)
       {
           if(sp.getIndex()==d.getParent())
           {
               sp.docks.add(d);
           }
       }
   }
    
   void assignPort(SeaPort p)
   {
       ports.add(p);
   }
   
   
   public String toString()
   {
       String str="";
       for(SeaPort s:ports)
       {
           str+=s.toString()+"\n";
       }
       return str;
   }
   
    
   
}
