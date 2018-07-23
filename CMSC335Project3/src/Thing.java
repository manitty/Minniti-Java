
import java.util.Scanner;

public class Thing {

    String name;
    int index;
    int parent;


    public Thing(Scanner sc)
    {
        
        if(sc!=null)
        {
            name=sc.next();
            index=sc.nextInt();
            parent=sc.nextInt();
        }
    }
    

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getParent() {
        return parent;
    }
    
    
    @Override
    public String toString()
    {
        return name+" "+index;
    }
}
