package com.harry.DS;

public class LinkedList {
    Node head; //initially the head node will be pointing to null

    // making the inner class static so that the Main class can access it
    static class Node {
        int data; // store data of the list node
        Node next; // store address of the next node

        //creating constructor to create a new Node
        public Node(int d) {
            data = d;
            next = null;
        }
    }
    public static LinkedList insertAtPosition(LinkedList list, int data, int position){
        Node n = new Node(data);
        n.next = null;

        // let's cover different scenarios which includes invalid position argument
        //Check if the position is valid
        if(list.head == null && position>1 || position<=0){
            System.out.println("\nThe Given position is invalid!");
        }else{
            Node temp1 = list.head;
            // To enter an element at nth position of the list we need to traverse till (n-1)th position and adjust the links
            for(int j=1; j<position-1;j++){
                temp1 = temp1.next;
                if(temp1.next==null){
                    System.out.println("\nThe Given position is invalid!");
                }
            }

        }

        //inserting at the beginning of the list WHEN POSITION = 1
        if(position == 1){
            list = insertAtBeginning(list,data);
            return list;
        }
        //inserting at any other position create a temp node to point to head and traverse through list using that
        Node temp2 = list.head;
        // To enter an element at nth position of the list we need to traverse till (n-1)th position and adjust the links
        for(int i=1; i<position-1; i++){
            temp2 = temp2.next; // traverse till you get (n-1)th node
        }
        //adjust the links
        n.next = temp2.next; // point new node to the (n+1)th node
        temp2.next = n; // create link between (n-1)th node and new node (nth)

        return list;
    }
    public static LinkedList insertAtBeginning(LinkedList list, int data){
        // create a new node with given data
            Node n = new Node(data);
            n.next = list.head;
            list.head = n;
        //return the list
        return list;
    }
    public static LinkedList deleteAtPosition(LinkedList list, int position){
        //Check if the position is valid or not
        Node temp1 = list.head;

        if(list.head == null && position>=1){
            System.out.println("\nThe position is not Valid!");
        }else{
            //Node is not present
            for(int j=1; j<position-1;j++){
                temp1= temp1.next;
                if(temp1.next==null){
                    System.out.println("\nThe position is not valid");
                }
            }

        }

        //Deleting node of the list when POSITION =1
        if(position ==1){
            list.head = temp1.next;
        }
        //Deleting node of the list at nth position
        // To delete an element at nth position of the list we need to traverse till (n-1)th position and adjust the links
        for(int i=1; i<position-1;i++){ //want to delete node at 3 i<2
            temp1 = temp1.next; //at the end this is pointing at node position 2 (n-1)th node
        }
        Node temp2 = temp1.next; // create a temp new node and point it to (n+1)th node
        temp1.next = temp2.next; // assign (n-1)th node the link to (n+1)th node so that nth node will be detached
    return list;
    }
    public static LinkedList deleteGivenNode(LinkedList list, int data){
        Node temp = list.head;
        Node prev = null;

        //if the data found at the head
        if(temp!=null && temp.data==data){
            list.head = temp.next; //then delete the first node and assign head to the next node
        }

        //if the data found at nth position
        while(temp!=null && temp.data != data){
            prev = temp; //maintaining the prev node
            temp = temp.next;
        }
        //if the data found at nth node where temp is pointing right now
        if(temp!=null){
            prev.next = temp.next; //assign address of (n+1)th node to (n-1)th node de-link nth node from (n-1)th node
        }
        //if the data is not found in the list then temp will be empty
        if(temp == null){
            System.out.println("\nNo data found!");
        }
    return list;
    }

    //This method will also work with ONLY ONE element of linked list
    public static LinkedList iterativeReverse(LinkedList list){
        Node current, prev, next;
        current = list.head;
        prev = null;

        while(current!=null){
            next = current.next; //first go to the next node
            current.next = prev; //reverse the link of the current node to point to the prev
            prev = current;//advance prev to current
            current = next; //advance current to next
        }
        list.head = prev; // at the end current and next will point to NULL so head would be pointing to prev

    return list;
    }

    //See notes for detail explanation
    public static LinkedList recursiveReverse(LinkedList list, Node p){

        //Exit condition
        if(p.next == null){
            list.head = p;
            return list;
        }
        recursiveReverse(list,p.next);
        Node q = p.next;
        q.next = p;
        p.next = null;
        return list;
    }

    public static void printRecursive(Node p){
        //NEVER FORGET EXIT CONDITION IN RECURSION
        if(p == null){
            return;
        }
        System.out.print(" " + p.data);// printing element from the list
        printRecursive(p.next);//making recursive call
    }

    //This is similar to above method only swapping two lines.
    /*The mechanism of "Recursive Call" do the trick here. As the recursive call stays in the stack one on top of other
     *and at the end of the function all statement after recursive call executes our list will print in reverse due to LIFO nature of stack
     * As the last call will execute first (printing elements in reverse)
     */
    public static void printRecursiveReverse(Node p){
        if(p==null){
            return;
        }
        printRecursiveReverse(p.next);
        System.out.print(" "+ p.data);
    }
    public static void printList(LinkedList list){
        //creating temp node to get the head node and iterate through it
        Node temp = list.head;

        System.out.println("\n Your List: ");
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp=temp.next;
        }
        System.out.println("\n");
    }
}
