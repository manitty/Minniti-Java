
import java.util.Comparator;

public class WidthComparator implements Comparator<Ship>{

    @Override
    public int compare(Ship o1, Ship o2) {
       
    	return o1.getWidth().compareToIgnoreCase(o2.getWidth());
    	
    	
    	
    	
    }
}