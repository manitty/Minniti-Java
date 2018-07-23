//File name: QuickSort.java
//Author: Paul Minniti
//Date: 18 June 2017
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
    
    private static void Quicksort(int listEle[], int from, int to) {
        if (from >= to) {
            return;
        }
        int pvot = listEle[from];
        int in = from - 1;
        int jn = to + 1;
        while (in < jn) {
            in++;
            while (listEle[in] < pvot) { in++; }
            jn--;
            while (listEle[jn] > pvot) { jn--; }
            if (in < jn) {
                swap(listEle, in, jn);
            }
        }
        Quicksort(listEle, from, jn);
        Quicksort(listEle, jn + 1, to);
    }
    public static int[] Quicksort(int [] liste) {
        Quicksort(liste, 0, liste.length-1);
        return liste;
    }       
    public static void main(String args[]) throws Exception
    {
        String ele="";
        int in=0,n=0;
        
        QuickSort s= new QuickSort();
        ArrayList<Integer> arrlist=new ArrayList<Integer>();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Enter a list of Elements(one element per line)");
        System.out.println(" write 'STOP' when complete.");
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        while(!(ele=bf.readLine()).equalsIgnoreCase("stop")){
            int intelement=Integer.parseInt(ele);
            arrlist.add(intelement);
            
        }
        
        int elementlist[]  = new int[arrlist.size()];
        Iterator<Integer> iter = arrlist.iterator();
        for (int jn=0;iter.hasNext();jn++) {
            elementlist[jn] = iter.next();
        }
        
        elementlist=Quicksort(elementlist);
        System.out.println("Recursive Quicksort: ");
        for (int jn=0;jn<elementlist.length;jn++) {
            System.out.println(elementlist[jn]+" ");
        }
    }
    
    
}