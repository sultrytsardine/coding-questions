import java.util.*;

/* 
 * Implement a quick sort
 */
public class QuickSort {
   public void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
   } 

   private void quicksort(int[] array, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        int pivot = array[mid];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index - 1);
        quicksort(array, index, right);
   }

   private int partition(int[] array, int left, int right, int pivot) {
       while(left <= right) {
           while(array[left] < pivot) {
               left++;
           }

           while(array[right] > pivot) {
               right--;
           }

           if (left < right) {
               swap(array, left, right);
               left++;
               right--;
           }
       }
       
       return left;
   }

   private void swap(int[] array, int left, int right) {
       int temp = array[left];
       array[left] = array[right];
       array[right] = temp;
   }
}