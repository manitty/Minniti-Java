import java.util.Comparator;


public class QueComparator implements Comparator<Ship>{
    
     @Override
    public int compare(Ship o1, Ship o2) {
        if(o1.weight>o2.weight)
            return 1;
        else if(o1.weight<o2.weight)
            return -1;
        else if(o1.length>o2.length)
            return 1;
        else if(o1.length<o2.length)
            return -1;
        else if(o1.width>o2.width)
            return 1;
        else if(o1.width<o2.width)
            return -1;
        else if(o1.draft>o2.draft)
            return 1;
        else if(o1.draft<o2.draft)
            return -1;
        else
            return 0;
            
    }
    
}