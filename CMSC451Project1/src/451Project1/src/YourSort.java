public class YourSort implements SortInterface{
    public UnsortedException unsorted;
    int iterativeCount;
    int recursiveCount;
    long iterativeTime;
    long recursiveTime;
   
    public void iterativeSort (int [] list) throws Exception {
        iterativeCount = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < list.length - 1; i++){
            
            int currentMin = list[i];
            int currentMinIndex = i;
          
            for (int j = i + 1; j < list.length; j++){
                if (currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
                iterativeCount++;
            }
          
            
            if (currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
         
        }
        long endTime = System.nanoTime();
        iterativeTime = endTime - startTime;
        for (int i = 0; i < list.length - 1; i++){
            if (list[i] > list [i + 1]){
                unsorted = new UnsortedException ("Sort failed!");
                throw unsorted;
            }
        }
              
    }
  
  

    public void recursiveSort(int [] list) throws Exception {
        recursiveCount = 0;
        recursiveSort(list, 0, list.length - 1);
    }
  
    public void recursiveSort(int [] list, int low, int high)throws Exception{          
              
        long startTime = System.nanoTime();
        if (low < high) {
            int indexOfMin = low;
            int min = list[low];
          
            for (int i = low + 1; i <= high; i++){
                    if (list[i] < min) {
                    min = list[i];
                   indexOfMin = i;               
                }
                recursiveCount++;
            }
          

            list[indexOfMin] = list[low];
            list[low] = min;

            recursiveSort(list, low + 1, high);

        }
        long endTime = System.nanoTime();
        recursiveTime = endTime - startTime;
        for (int i = 0; i < list.length - 1; i++){
            if (list[i] > list [i + 1]){
                unsorted = new UnsortedException ("Sort failed!");
                throw unsorted;
            }
        }
    }
  
  
    public int getCount(){
        int totalCount = iterativeCount + recursiveCount;
        iterativeCount = 0;
        recursiveCount = 0;      
        return totalCount;
    }
  
    public long getTime(){
        long totalTime = iterativeTime + recursiveTime;
        iterativeTime = 0;
        recursiveTime = 0;
        return totalTime;
    }
  
}