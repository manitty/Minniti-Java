
import java.util.Comparator;

public class LengthComparator implements Comparator<Ship>{

    @Override
    public int compare(Ship o1, Ship o2) {
       
    	return o1.getLength().compareToIgnoreCase(o2.getLength());
    	
    	
    	
    	
    }
}