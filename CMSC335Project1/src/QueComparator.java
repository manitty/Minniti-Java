
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
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
