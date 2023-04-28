//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java

class NodeRange{
   Node node=null;
    int min=Integer.MIN_VALUE;
    int max=Integer.MAX_VALUE;
    NodeRange(){
     
    }
    NodeRange(Node node,int min,int max){
        this.node=node;
        this.min=min;
        this.max=max;
    }
}
class GFG 
{
    //Function to construct the BST from its given level order traversal
    public Node constructBST(int[] arr)
    {
       if (arr.length == 0)
      return null;
 
    // Create root node and store a copy of it in head
    Node root = new Node(arr[0]), head = root;
 
    // Create queue to store the tree nodes
    Queue<NodeRange> queue = new LinkedList<>();
    queue.add(new NodeRange(root, Integer.MIN_VALUE,
                            Integer.MAX_VALUE));
 
    for (int i = 1; i < arr.length; i++) {
      NodeRange nr = queue.peek();
 
      // Check if arr[i] can be a child of the temp
      // node
      if (arr[i] > nr.min && arr[i] < nr.max) {
        // Check if arr[i] can be left child
        if (arr[i] < nr.node.data) {
          // Set the left child and range
          nr.node.left = new Node(arr[i]);
          queue.add(new NodeRange(nr.node.left,
                                  nr.min,
                                  nr.node.data));
        }
        // Check if arr[i] can be right child
        else {
          // Pop the temp node from queue, set the
          // right child and new range
          queue.remove();
          nr.node.right = new Node(arr[i]);
          queue.add(new NodeRange(nr.node.right,
                                  nr.node.data,
                                  nr.max));
        }
      }
      else {
        queue.remove();
        i--;
      }
    }
 
    return head;

    }
}