
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
public class NameComparator implements Comparator<Thing>{

    @Override
    public int compare(Thing o1, Thing o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
    
}
