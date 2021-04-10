package com.harry.DS;

public class DoublyLinkedList {
    Node head;

    static class Node{
        int data;
        Node prev;
        Node next;

        public Node(int d){
            data = d;
            prev = null;
            next = null;
        }
    }

    public static DoublyLinkedList insertAtHead(DoublyLinkedList list, int data){
        //create a new node with data
        Node n = new Node(data);

        if(list.head==null){
            list.head = n;
            return list;
        }
        list.head.prev = n;
        n.next = list.head;
        list.head = n;
    return list;
    }

    public static void reversePrint(DoublyLinkedList list){
        Node temp = list.head;
        if(temp==null)return; // if the list is empty exit

        //traverse till the end of the list
        while(temp.next!=null){
            temp = temp.next;
        }
        System.out.println("Your Reverse List:");
        //Traversing backward using prev pointer
        while (temp!=null){
            System.out.printf(" "+temp.data);
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void printList(DoublyLinkedList list){
        Node temp = list.head;
        System.out.println("\nYour List:");
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp=temp.next;
        }
        System.out.println();
    }
}
