// Recursive APPROACH of the Quick Sort
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class QuickSort {        
    private static void swap(int[] a1, int in, int jn) {
        int temp = a1[in];
        a1[in] = a1[jn];
        a1[jn] = temp;
    }
    
    private static void Quicksort(int liste[], int from, int to) {
        if (from >= to) {
            return;
        }
        int pvot = liste[from];
        int in = from - 1;
        int jn = to + 1;
        while (in < jn) {
            in++;
            while (liste[in] < pvot) { in++; }
            jn--;
            while (liste[jn] > pvot) { jn--; }
            if (in < jn) {
                swap(liste, in, jn);
            }
        }
        Quicksort(liste, from, jn);
        Quicksort(liste, jn + 1, to);
    }
    public static int[] Quicksort(int [] liste) {
        Quicksort(liste, 0, liste.length-1);
        return liste;
    }       
    public static void main(String args[]) throws Exception
    {
        String liste="";
        int in=0,n=0;
        
        QuickSort s= new QuickSort();
        ArrayList<Integer> arrlist=new ArrayList<Integer>();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Enter the liste of elements,one element in line");
        System.out.println(" write 'STOP' when liste is complete.");
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        while(!(liste=bf.readLine()).equalsIgnoreCase("stop")){
            int intelement=Integer.parseInt(liste);
            arrlist.add(intelement);
            
        }
        
        int elementlist[]  = new int[arrlist.size()];
        Iterator<Integer> iter = arrlist.iterator();
        for (int jn=0;iter.hasNext();jn++) {
            elementlist[jn] = iter.next();
        }
        
        elementlist=Quicksort(elementlist);
        System.out.println("the sorted value via recursive approach of Quicksort is: ");
        for (int jn=0;jn<elementlist.length;jn++) {
            System.out.println(elementlist[jn]+" ");
        }
    }
    
    
}
