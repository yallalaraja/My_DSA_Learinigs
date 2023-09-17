package Recursion;
public class QuickSort {
    public static void quickSort(int arr[],int low,int high){
        //s -> low e->high
        int s = low;
        int e = high;

        //For best case TC taking mid as pivot element
        int mid = s+(e-s)/2;
        int pivot = arr[mid];

        //low >= high then it come out from the function 
        if(low>=high){
            return;
        }
        
        while(s<=e){
            //checking whether number is less than pivot is placed in left side 
            while(arr[s] < pivot){
                s++;
            }
            //checking whether number is greater than pivot is placed in right side 
            while(arr[e]>pivot){
                e--;
            }

            //If the above conditon fails then swap the start and end elements
            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        
        //Applying the quicksort from low->end && start->high
        quickSort(arr,low,e);
        quickSort(arr, s, high);
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        System.out.println("Before sorting");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        quickSort(arr,0,arr.length-1);
        System.out.println("After sorting");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
