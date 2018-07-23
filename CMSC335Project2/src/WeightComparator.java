
import java.util.Comparator;

public class WeightComparator implements Comparator<Ship>{

    @Override
    public int compare(Ship o1, Ship o2) {
       
    	return o1.getWeight().compareToIgnoreCase(o2.getWeight());
    	
    	
    	
    	
    }
}