package com.harry;

public class QueueArrayImpl {
    private int MAX_SIZE=101;
    private int[] a=new int[MAX_SIZE];
    private int front,rear;

    //we are assuming for an empty Queue both front and rear will be -1
    public QueueArrayImpl(){
        front = -1;
        rear = -1;
    }

    //check if the queue is empty
    public boolean isEmpty(){
        return (front==-1 && rear==-1);
    }

    //check if the queue is full -- We'll check if the rear and front are next to each other
    public boolean isFull(){
        return ((rear+1)%MAX_SIZE == front?true:false);
    }

    //enQueue
    public void enQueue(int x){
        System.out.println("\nEnQueue in Progress...");
        if(isEmpty()){
            front=0;
            rear=0;
        }else if(isFull()){
            System.out.println("The Queue is Full!");
        }else{
           rear = (rear+1)%MAX_SIZE;
        }
        a[rear]=x;
    }

    //deQueue
    public void deQueue(){
        if(isEmpty()){
            System.out.println("The Queue is empty!");
        }else if(front==rear){ //means all DeQueue operations have removed all elements then mark queue as empty
            front=-1;
            rear=-1;
        }else {
            front = (front+1)%MAX_SIZE;
        }
    }

    public int front(){
        if(front==-1){
            System.out.println("Cannot return front from an empty Queue!");
        }
        return a[front];
    }

    //printing Queue
    public void print(){

        //find the number of element in the circular queue
        //You can't always assume rear > front
        //You have to consider other two scenarios as well
        //1. front == rear
        //2. front > rear Or rear < front (Ex front = 90 and rear = 78)
        int count = (rear + MAX_SIZE -front) % MAX_SIZE + 1;
        System.out.println("\nThe Queue is: ");
        for(int i=0; i<count; i++){

            //Now calculate index of an element while traversing circular queue from front
            int index = (front + i) % MAX_SIZE;
            System.out.print(a[index]+ " ");
        }
    }

    public static void main(String[] args) {
        QueueArrayImpl q = new QueueArrayImpl();
        q.enQueue(3);
        q.enQueue(6);
        q.enQueue(8);
        q.enQueue(2);
        q.enQueue(9);
        q.print();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.print();
        q.enQueue(34);
        q.enQueue(87);
        q.enQueue(75);
        q.print();
    }
}
