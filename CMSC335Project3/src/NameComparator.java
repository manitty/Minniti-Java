
import java.util.Comparator;


public class NameComparator implements Comparator<Thing>{

    @Override
    public int compare(Thing o1, Thing o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
    
}
