public class ComputerInformationHighway {

    public static void main(String[] args) {
        int unsorted[] = {9, 15, 1, 65, 48, 2, 5, 91, 13, 5};
        mergeSort(unsorted, 0, unsorted.length-1);
        
        for(int i : unsorted)
            System.out.printf("%d ", i);
    }
    
    public static int[] swap(int[] array, int x, int y) {
        if(x < array.length && y < array.length) {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
        
        return array;
    }
    
    public static void merge(int[] unsorted, int start, int mid, int end) {
        //Left instance of list
        int[] lList = new int[mid - start + 2];
        for(int i = start; i < mid+1; i++)
            lList[i - start] = unsorted[i]; 
        
        lList[mid - start + 1] = Integer.MAX_VALUE;
        
        //Right instance of list
        int[] rList = new int[end - mid + 1];
        for(int i = mid + 1; i < end + 1; i++)
            rList[i - mid  - 1] = unsorted[i]; 
        
        rList[end - mid] = Integer.MAX_VALUE;
        
        //Merge two lists onto old array.
        int i = 0, j = 0;
        for(int k = start; k < end + 1; k++) {
            if(lList[i] < rList[j])
                unsorted[k] = lList[i++];
            else
                unsorted[k] = rList[j++];
        }
        
    }
    
    public static void mergeSort(int[] unsorted, int start, int end) {
        if(start < end) {
             int mid = (start + end)/2;
             mergeSort(unsorted, start, mid);
             mergeSort(unsorted, mid + 1, end);
             merge(unsorted, start, mid, end);
        }
    }
}
