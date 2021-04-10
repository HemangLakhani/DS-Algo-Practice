package com.harry.Algo;

public class BubbleSortAlgo {

    public static void bubbleSort(int a[], int n){

        //outer loop will run till the length of the array or once we found sorted array in between
        for(int k=0; k<n-1; k++){
            int flag=0; //flag check for empty pass of inner loop (or if the array is already sorted)

            for(int i=0; i<n-k-1;i++){
                if(a[i] > a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    flag = 1;
                }
            }
            if(flag==0) break;
        }
    }

    public static void main(String[] args) {
        int a[] = {2,7,4,1,5,3};
        bubbleSort(a,6);
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]);
        }
    }
}
