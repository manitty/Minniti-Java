
import java.util.Comparator;

public class DraftComparator implements Comparator<Ship>{

    @Override
    public int compare(Ship o1, Ship o2) {
       
    	return o1.getDraft().compareToIgnoreCase(o2.getDraft());
    	
    	
    	
    	
    }
}