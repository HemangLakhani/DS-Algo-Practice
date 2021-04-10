package com.harry.Algo;

public class SelectionSortAlgo {
    public static void selectionSort(int a[], int n){

        //we need to do n-2 pass as the last element would already be in appropriate position
        for(int i=0; i<n-1; i++){
            int iMin=i; //ith position: elements from i to n-1 should be consider to check for minimum
            for(int j=i+1;j<n;j++){
                if(a[j]<a[iMin])
                    iMin=j; //if you find a minimum value from the array then update index of iMin
            }
            int temp = a[i]; //store current value to temp
            a[i] = a[iMin]; //store minimum value at current index
            a[iMin] = temp; //switch value at current index to the index of minimum
        }
    }

    public static void main(String[] args) {
        int a[] = {2,7,3,5,1,4};
        selectionSort(a,6);
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]);
        }
    }
}
