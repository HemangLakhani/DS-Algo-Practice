package com.harry;

public class Stack {

    //Here we will use LinkedList implementation of Stack
    static Node  top;

    static class Node{
        int data;
        Node link;

        public Node(int d){
            data = d;
            link = null;
        }
    }

    //Insertion of the element on the top of stack -- here we will insert at the head of the LinkedList
    public static void push(int data){

        //creating node or adding element at top of stack
        Node n = new Node(data);
        n.link = top;
        top = n;
    }

    //Deletion of elements from top of the stack
    public static void pop(){
        if(top == null){
            return;
        }
        top = top.link;
    }

    //return top of the list
    public static Node top(){
        if(top==null){
            System.out.println("\nNo Stack Top Found");
        }
        return top;

    }

    //if the stack is empty
    public static void isEmpty(Node top){
        if(top == null){
            System.out.println("\nThe Stack is Empty!");
        }else{
            System.out.println("\nThe Stack is not Empty!");
        }
    }

    //print stack
    public static void printStack(Node top){

        System.out.println("\nYour Stack: ");
        while(top !=null){
            System.out.print(" "+top.data);
            top = top.link;
        }
    }
}
