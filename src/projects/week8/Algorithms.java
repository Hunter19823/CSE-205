package projects.week8;

import java.util.*;

public class Algorithms {
    private static final Random random = new Random();
    static{
        //random.setSeed(6l);
    }

    public static void main(String[] args)
    {
        int[] sample = populate(10);
        print(sample);
        selectSort(sample);
        sample = populate(10);
        print(sample);
        bubbleSort(sample);
        sample = populate(10);
        print(sample);
        quickSort(sample,0,sample.length-1);
        print(sample);
        sample = populate(10);
        System.out.println("Repopulated: ");
        print(sample);
        mergeSort(sample,0,sample.length-1);
        print(sample);

    }

    /**
     * Selection Sort
     * For every value in the array (except the last):
     *      store minimum as current index.
     *      for every value past current index:
     *          if current value is less than current minimum:
     *              set minimum equal to current inner index.
     *      swamp current index with minimum index.
     * return array.
     *
     * @param arr
     * @return
     */
    public static void selectSort(int[] arr)
    {
        int n = arr.length;
        for(int i=0; i<n-1;i++){
            int min = i;
            for(int j=i+1; j<n;j++)
            {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        print(arr);
    }

    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Bubble Sort
     * for every value in the array minus one:
     *      for every value in the array minus one:
     *          compare the current value to the next value,
     *          if current > next:
     *              swap current with next.
     * return arr.
     *
     * @param arr
     * @return arr
     */
    public static void bubbleSort(int[] arr)
    {
        /**
         * Bubble Sort
         * for every value in the array minus one:
         *      for every value in the array minus one:
         *          compare the current value to the next value,
         *          if current > next:
         *              swap current with next.
         * return array.
         *
         */
        int n = arr.length;
        for(int i=0;  i<n-1; i++) {
            for(int j=0; j < n-1; j++)
            {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        print(arr);
    }

    public static void quickSort(int[] arr, int begin, int end)
    {
        if(begin < end)
        {
            int partIndex = partition(arr,begin,end);

            quickSort(arr, begin,partIndex-1);
            quickSort(arr, partIndex+1, end);
        }
    }

    public static int partition(int[] arr, int begin, int end)
    {
        int pivot = arr[end];
        int i = begin-1;
        for(int j = begin; j < end; j++) {
            if(arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        return i+1;
    }

    public static void mergeSort(int[] arr, int left, int right)
    {
        if(left < right){
            int middle = left + (right - left)/2;

            mergeSort(arr, left, middle);
            mergeSort(arr,middle+1, right);

            sort(arr, left, middle, right);
        }
    }

    private static void sort(int[] arr, int left, int middle, int right)
    {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i=0; i<n1; i++)
            leftArray[i] = arr[left + i];
        for(int i=0; i<n2; i++)
            rightArray[i] = arr[middle + 1 + i];

        int i = 0,j = 0, k = left;
        while(i < n1 && j < n2)
        {
            if(leftArray[i] <= rightArray[j])
            {
                arr[k] = leftArray[i];
                i++;
            }else{
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < n1)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < n2)
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }


    }

    public static int[] populate(int size)
    {
        return random.ints(size,0,50).toArray();
    }

}
