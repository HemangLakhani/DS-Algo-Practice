package com.harry.Algo;

public class InsertionSortAlgo {

    public static void insertionSort(int a[], int n){
        //This loop will start from index 1 as we are dividing array into two sets : sorted and unsorted
        //one set till index 0 is sorted and other is unsorted (in any set if there is only one element then it's already sorted
        for(int i=1;i<=n-1;i++){

            int value = a[i]; //we are storing value at current position so that we can insert it into sorted set
            int hole = i;  //once we take the value at current index there will be imaginary hole

            //insert element in sorted set by shifting elements which are greater than current value from sorted set to the right position
            while(hole>0 && a[hole-1]>value){
                a[hole] = a[hole-1];
                hole = hole - 1;
            }
            a[hole] = value;
        }
    }

    public static void main(String[] args) {
        int a[] ={7,2,4,1,5,3};
        insertionSort(a, 6);
        for(int i=0; i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
