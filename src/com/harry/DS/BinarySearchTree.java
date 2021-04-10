package com.harry.DS;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
    static BstNode root = null;
    static class BstNode{
        int data;
        BstNode left; //left subtree address
        BstNode right; //right subtree address

        public BstNode(int d){
            data = d;
            left = null;
            right = null;
        }
    }

    public static BstNode insertTreeNode(BstNode root, int data){
        //EXIT CONDITION FOR THE RECURSION
        //if tree is empty then create a new node
        if(root == null){
            root = new BstNode(data);
        }//else if the data is less than root node then enter new node in the left of the tree
        else if(data<=root.data){
            root.left = insertTreeNode(root.left, data);
        }//else if the data is greater than root node then enter new node in the right of the tree
        else{
            root.right = insertTreeNode(root.right,data);
        }
        return root;
    }

    //Method returning boolean for search
    public static boolean booleanSearch(BstNode root, int data){
        //if the tree is empty return false
        if(root == null) return false;
        else if(root.data == data)return true; //EXIT CONDITION FOR THE RECURSION
        else if(data<root.data) return booleanSearch(root.left, data);
        else return booleanSearch(root.right, data);
    }

    //Method returning address of the node
    public static BstNode search(BstNode root, int data){
        //if the tree is empty return false
        if(root == null) return null;
        else if(root.data == data)return root; //EXIT CONDITION FOR THE RECURSION
        else if(data<root.data) return search(root.left, data);
        else return search(root.right, data);
    }

    //find minimum element from the tree ITERATIVE SOLUTION
    public static int findMinIterative(BstNode root){
        if(root == null){
            System.out.println("Error: There is no Tree!");
        }

        //go until you reach at the end of the left subtree
        while(root.left!=null){
            root = root.left;
        }
        return root.data; //the data of the left most node will be minimum
    }
    //find minimum element from the tree RECURSIVE SOLUTION
    public static int findMinRecursive(BstNode root){
        if(root == null){
            System.out.println("Error: There is no Tree!");
        }else if(root.left == null){ //exit condition
            //we found our minimum element
            return root.data;
        }
        return findMinRecursive(root.left); //until not found keep searching the left subtree
    }


    //find maximum element from the tree ITERATIVE SOLUTION
    public static int findMaxIterative(BstNode root){
        if(root == null){
            System.out.println("Error: There is no Tree!");
        }

        //go until you reach at the end of the right subtree
        while(root.right!=null){
            root = root.right;
        }
        return root.data; //the data of the right most node will be maximum
    }
    //find maximum element from the tree RECURSIVE SOLUTION
    public static int findMaxRecursive(BstNode root){
        if(root == null){
            System.out.println("Error: There is no Tree!");
        }else if(root.right == null){ //exit condition
            //we found our minimum element
            return root.data;
        }
        return findMaxRecursive(root.right); //until not found keep searching the right subtree
    }

    //find height of tree : no of edges from root to leaf node
    //formula max(height of left subtree, height of right subtree) + 1
    public static int treeHeight(BstNode root){
        //Exit condition (for leaf node where left and right subtree are null don't return 0 return -1
        //See workbook for explanation
        if(root == null){
            return -1;
        }
        return Math.max(treeHeight(root.left),treeHeight(root.right)) + 1;
    }

    /*
    * Tree Traversal Breadth First Search (BFS)
    * Level Order Traversal
     */
    public static void levelOrder(BstNode root){
        if(root == null){
            return;
        }
        Queue<BstNode> q = new LinkedList<>();
        q.add(root); //adding root of the queue
        //while there is at least one discovered node
        while(!q.isEmpty()){
            BstNode  current = q.peek(); //store the first node in current
            q.remove(); //after visiting remove the first node from queue
            System.out.print(current.data+" ");
            //if current node have left child add it to queue
            if(current.left!=null) q.add(current.left);
            //if current node have right child add it to queue
            if(current.right!=null) q.add(current.right);
        }
    }

    /*
    * Tree traversal Depth First Search (DFS)
    * Here we will implement three DFS Algorithms
    * 1. PreOrder Traversal
    * 2. InOrder Traversal
    * 3. PostOrder Traversal
     */

    //PreOrder <data/root><left><right>
    public static void preOrderTraversal(BstNode root){

        //Base condition or Exit condition from recursion
        if(root == null) return;
        System.out.printf(root.data+ " "); // 1. Visit the root (Read Data)
        preOrderTraversal(root.left); // 2. Visit the left subtree
        preOrderTraversal(root.right); // 3. Visit the right subtree
    }

    //InOrder <left><root/data><right>
    // InOrder Traversal of BST will give sorted elements
    public static void inOrderTraversal(BstNode root){

        //Base condition or Exit condition from recursion
        if(root == null) return;
        inOrderTraversal(root.left); // 1. Visit the left subtree
        System.out.printf(root.data+ " "); // 2. Visit the root (Read Data)
        inOrderTraversal(root.right); // 3. Visit the right subtree
    }

    //PostOrder <left><right><root/data>
    public static void postOrderTraversal(BstNode root){

        //Base condition or Exit condition from recursion
        if(root == null) return;
        postOrderTraversal(root.left); // 1. Visit the left subtree
        postOrderTraversal(root.right); // 2. Visit the right subtree
        System.out.printf(root.data+ " "); // 3. Visit the root (Read Data)
    }

    /*
    * Check if the given Binary Tree is Binary Search Tree or Not (Here in this class the function will always be true.But we can pass
    * root of any binary tree and see the true result)
    * The implemented approach
    * 1. Using permissible range to check if the data of node is in the range (see notes for explanation)
     */

    //Approach 1 (Here we are not covering the scenario where Binary Tree have duplicate data)
    public static boolean isBinarySearchTree(BstNode root){
        return isBstUtil(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean isBstUtil(BstNode root, int minValue, int maxValue){

        //exit condition
        if(root == null) return true;
        if(root.data > minValue && root.data < maxValue
                && isBstUtil(root.left, minValue, root.data)    //check notes to see how this will work
                && isBstUtil(root.right, root.data, maxValue)){
            return true;
        }else{
            return false;
        }
    }

    /*
    * This method will delete the node from Binary Search Tree using recursive approach. There are three cases to cover.
    * case 1: delete a node with 0 child
    * case 2: delete a node with 1 child
    * case 3: delete a node with 2 children
     */
    public static BstNode delete(BstNode root, int data){
        if(root == null) return root; //exit condition
        //search data in either left or right subtree
        else if(data < root.data){
            root.left = delete(root.left,data);
        }
        else if(data>root.data){
            root.right = delete(root.right,data);
        }
        //Here data = root.data means we found the match
        else{
            //case 1: no child
            if(root.left==null && root.right==null){
                root = null;
            }
            //case 2: 1 child
            else if(root.left==null){ //don't have left child only right child
                root = root.right;
            }
            else if(root.right==null){ //don't have right child only left child
                root = root.left;
            }
            //case 3: 2 children
            else{ //check notebook for explanation
                int temp = findMinIterative(root.right);
                root.data = temp;
                root.right = delete(root.right,temp);
            }
        }
        return root;
    }

    /*
    * This method will find inorder successor of the given node (which is next higher value than the given node)
    * We need to cover two cases.
    * 1. Node has right subtree (Then we can find minimum in right subtree which will be higher then given node and thus the successor of the node)
    * 2. Node doesn't have right subtree (In this case we will find to which the given node is in left. So the nearest ancestor will have higher
    *                                       value than the given node and thus it will be successor of the given node)
    *   Here we are returning value of the successor, we can also return it's address.
     */

    public static int inorderSuccessor(BstNode root, int data){
        //search for the node in BST
        BstNode current = search(root,data);
        if(current==null) System.out.print("The data not found in tree!");

        //case 1: Node has right subtree
        if(current.right!=null){
            return findMinIterative(current.right);
        }
        //case 2: No right subtree
        else{
            BstNode successor = null;
            BstNode ancestor = root;

            while(ancestor!=current){
                if(current.data<ancestor.data){
                    successor=ancestor;//so far this is the deepest node for which the current node is in left
                    ancestor=ancestor.left;
                }
                else {
                    ancestor = ancestor.right;
                }
            }
            if(successor!=null){
                return successor.data;
            }else return 0;
        }
    }

    public static void main(String[] args) {
        BstNode root=null;
        root = insertTreeNode(root, 15);
        root = insertTreeNode(root, 20);
        root = insertTreeNode(root, 25);
        root = insertTreeNode(root, 10);
        root = insertTreeNode(root, 17);
        root = insertTreeNode(root, 8);
        root = insertTreeNode(root, 12);
        root = insertTreeNode(root, 9);
        root = insertTreeNode(root, 5);
        root = insertTreeNode(root, 2);

        int num;
       /* Scanner sc = new Scanner(System.in);
        System.out.println("You will get 3 Searches");
        for(int i=0;i<3;i++){
            System.out.println("Enter Number to Search in the Tree: ");
            num = sc.nextInt();
            if(booleanSearch(root,num)){
                System.out.println("The number is in the Tree!");
            }else{
                System.out.println("The number is not in the Tree!!");
            }
        }*/
        int min1 = findMinIterative(root);
        System.out.println("Found Minimum with Iterative: "+min1);
        int min2 = findMinRecursive(root);
        System.out.println("Found Minimum with Recursive: "+min2);

        int max1 = findMaxIterative(root);
        System.out.println("Found Maximum with Iterative: "+max1);
        int max2 = findMaxRecursive(root);
        System.out.println("Found Maximum with Recursive: "+max2);

        int heightOfTree = treeHeight(root);
        System.out.println("Height of the Tree is: " + heightOfTree);

        //BREADTH FIRST SEARCH (BFS) Level Order Traversal
        System.out.println("\nBreadth First Search (Level Order Traversal)");
        levelOrder(root);
        System.out.println();

        // DEPTH FIRST SEARCH (DFS) ALGORITHMS
        System.out.println("\nPreOrder Traversal: ");
        preOrderTraversal(root);
        System.out.println();

        System.out.println("\nInOrder Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.println("\nPostOrder Traversal: ");
        postOrderTraversal(root);
        System.out.println();

        System.out.println("\nCheck if the given Binary Tree is BST or Not?");
        if(isBinarySearchTree(root)){
            System.out.println("\nYes, the given Binary Tree is BST.");
        }else{
            System.out.println("\nNo, the given Binary Tree is not BST.");
        }

        //TEST DELETE NODE FROM BINARY TREE

        System.out.println("\nOriginal Tree -> inorder traversal values: ");
        inOrderTraversal(root);
        System.out.println();

        BstNode root_after_deletion = delete(root,15);

        System.out.println("\nTree after deleting a node  -> inorder traversal values: ");
        inOrderTraversal(root_after_deletion);
        System.out.println();

        //TEST FIND INORDER SUCCESSOR OF THE GIVEN NODE
        int successor = inorderSuccessor(root,17);
        if(successor==0){
            System.out.println("\nInorder Successor of the Given Node is not found");
        }else System.out.println("\nInorder Successor of the Given Node is: "+successor);
    }
}
