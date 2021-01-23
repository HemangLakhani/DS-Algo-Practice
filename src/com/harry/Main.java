package com.harry;

public class Main {


    public static void main(String[] args) {
	// Here we will see LinkedList Operations
        /*
        * 1. Insert at Beginning of the list
        * 2. Insert at the nth position of the list
        * 3. Delete at nth position of the list
        * 4. Delete by Given key
        * 5. Reverse the list
        * 6. Reverse the list using Recursion
        * 7. Print element of the list in forward and reverse order using Recursion
        * */

    //create an empty list object
   // LinkedList list = new LinkedList();

    //inserting elements at the beginning of the list
    /*list = list.insertAtBeginning(list,1);
    list = list.insertAtBeginning(list,2);
    list = list.insertAtBeginning(list,3);
    list = list.insertAtBeginning(list,4);
    list = list.insertAtBeginning(list,5);

    //print the list
    list.printList(list);*/

    //inserting elements at nth position of the list ASSUME THAT THE GIVEN LIST IS EMPTY AND POSITIONS ARE VALID
   /* list = list.insertAtPosition(list,1,1); //List: 1
    list = list.insertAtPosition(list,2,2); //List: 1,2
    list = list.insertAtPosition(list,3,1); //List: 3,1,2
    list = list.insertAtPosition(list,4,2); //List: 3,4,1,2
    list = list.insertAtPosition(list,5,3); //List: 3,4,5,1,2

    //print the list
    list.printList(list);*/

    //deleting from nth position
   /* list = list.deleteAtPosition(list,3);
    list.printList(list);
    list = list.deleteAtPosition(list,1);
    list.printList(list);

    //deleting by given data value
    list = list.deleteGivenNode(list,3);
    list.printList(list);
    list = list.deleteGivenNode(list,2);
    list.printList(list);
    */
   // list = list.iterativeReverse(list);
    //list.printList(list);

    //list.printRecursive(list.head);
       // System.out.println();
    //list.printRecursiveReverse(list.head);
     /*list =  list.recursiveReverse(list,list.head);
     list.printList(list);

    //DoublyLinkedList inserting at Head of the list
    DoublyLinkedList linkedList = new DoublyLinkedList();
    linkedList = linkedList.insertAtHead(linkedList, 2);
    linkedList = linkedList.insertAtHead(linkedList, 3);
    linkedList = linkedList.insertAtHead(linkedList, 7);
    linkedList = linkedList.insertAtHead(linkedList, 9);

    linkedList.printList(linkedList);
    linkedList.reversePrint(linkedList);
      */

    /* This is Linked list implementation of the stack. Easy and fast with following operations implemented
    * 1. push
    * 2. pop
    * 3. printStack
    * 4. isEmpty
    * 5. top
     */
    Stack st = new Stack();
    st.push(4);
    st.push(5);
    st.push(9);
    st.printStack(st.top);
    st.pop();
    st.printStack(st.top);
    st.isEmpty(st.top);
    Stack.Node n = st.top();
    st.isEmpty(n);
    }
}
