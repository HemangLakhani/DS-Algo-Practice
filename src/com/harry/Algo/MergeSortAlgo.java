package com.harry.Algo;

public class MergeSortAlgo {
    /*
    * Merge Sort Algorithm has following properties
    * 1. Divide and Conquer
    * 2. Recursive
    * 3. Stable
    * 4. Not in-place (O(n) space complexity)
    * 5. Time complexity O(nlogn)
     */
    public static void mergeSort(int a[]){
        int n = a.length;
        if(n<2)
            return;
        int mid = n/2;
        int left []= new int[mid];
        int right []= new int[n-mid];

        for(int i=0; i<mid; i++){
            left[i] = a[i];
        }
        for(int i=mid; i<n; i++){
            right[i-mid] = a[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,a);
    }
    static void merge(int left[], int right [], int a[]){
        int i=0; //keep track of index of left sublist
        int j=0; //keep track of index of right sublist
        int k=0; //keep track of index of main list

        while(i<left.length && j<right.length){
            if(left[i] <= right[j]){
                a[k] = left[i];
                i++;
            }else{
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            a[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int a[] = {2,4,1,6,8,5,3,7};
        mergeSort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
