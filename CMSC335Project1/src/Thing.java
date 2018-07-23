//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.util.Scanner;

public class Thing {
	//Instance Variables
    String name;
    int index;
    int parent;

    //constructor
    public Thing(Scanner sc)
    {
        
        if(sc!=null)
        {
            name=sc.next();
            index=sc.nextInt();
            parent=sc.nextInt();
        }
    }
    
    //Getter Methods
    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getParent() {
        return parent;
    }
    
    //toString override method prints name & index
    @Override
    public String toString()
    {
        return name+" "+index;
    }
}
