package com.harry;

public class QueueLinkedListImpl {

    class Node{
        int data;
        Node next;

        public Node(int d){
            data = d;
        }
    }
    Node front = null; //this will point to the front end (deQueue)
    Node rear = null; //this will point to the rear end (enQueue)

    //insertion at the end of the linked list
    public void enQueue(int x){
        Node n = new Node(x);
        n.next=null;

        //when the queue is empty
        if(front == null && rear == null){
            front = rear = n;
        }
        rear.next = n; //build link from last element to the new element
        rear = n; //update rear pointer to point to the last element
    }

    //deletion from beginning of the list
    public void deQueue(){

        if(front == null) return;
        //if there is only one element in the queue
        if(front == rear){
            front=rear=null;
        }else{
            front = front.next;
        }
    }

    public void print(){
        Node temp = front;
        while(temp !=null){
            System.out.printf(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLinkedListImpl Q = new QueueLinkedListImpl();
        Q.enQueue(3);
        Q.enQueue(6);
        Q.enQueue(8);
        Q.enQueue(2);
        Q.enQueue(9);
        Q.print();
        Q.deQueue();
        Q.deQueue();
        Q.deQueue();
        Q.print();
        Q.enQueue(34);
        Q.enQueue(87);
        Q.enQueue(75);
        Q.print();
    }
}
