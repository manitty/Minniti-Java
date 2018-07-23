//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class World extends Thing{
    
	//instance variables
    ArrayList<SeaPort> ports;
    PortTime time;
    HashMap<Integer,Ship> hashmap;
   
    //constructor
    public World(Scanner sc) {
        super(sc);
        ports=new ArrayList<>();
    }

    //Getter & Setter Methods
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
    
    //Method returns ships by index
     Ship getShipByIndex (int x,HashMap<Integer,Ship> hms) {
      if(hms.containsKey(x))
      {
          return hms.get(x);
      }
      return null;
   } // end getShipByIndex
    
     //Methods returns docks by index
   Dock getDockByIndex(int x)
   {
       for (SeaPort msp: ports)
         for (Dock ms: msp.docks)
            if (ms.index == x) 
               return ms;
      return null;
   }// end getDockByIndex
     
   //Methods returns SeaPorts by index
   SeaPort getSeaPortByIndex(int x)
   {
       for (SeaPort msp: ports)
          if(msp.index==x)
              return msp;
      return null;
   }
   
   //Methods assigns a ship to a dock and puts them in the que
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
     
      
   } // end method assignShip
   
   //Method assigns a person to Seaport
   void assignPerson(Person p)
   {
       for(SeaPort sp:ports)
       {
           if(sp.getIndex()==p.getParent())
           {
               sp.persons.add(p);
           }
       }
   } // end assignPerson
   
   //Method assigns a dock to an object
   void assignDock(Dock d)
   {
       for(SeaPort sp:ports)
       {
           if(sp.getIndex()==d.getParent())
           {
               sp.docks.add(d);
           }
       }
   }//end assignDock
   
   //Method assigns a port to an object
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
