//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution ob = new Solution();
        	    ob.toSumTree(root);
        	    printInorder(root);
        	    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends


//User function template for JAVA

/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}*/

class Solution{
    
    public int findSum(Node temp){
        if(temp.left==null && temp.right==null)
        return temp.data;
        
        if(temp.left==null)
        return temp.data+findSum(temp.right);
        
        if(temp.right==null)
        return temp.data+findSum(temp.left);
        
        sum=temp.data+findSum(temp.left)+findSum(temp.right);
      //  System.out.println(sum);
        return sum;
    }
    
    
    int sum=0;
    public void toSumTree(Node root){
         //add code here.
       
 
        if(root.left==null && root.right==null)
            sum=0;
        else
           sum=findSum(root);
         if(root.left!=null || root.right!=null)   
        root.data=sum-root.data;
        
        else if(root.left==null && root.right==null)
        root.data=sum;
        
        sum=0;
        if(root.left!=null)
        toSumTree(root.left);
        
        if(root.right!=null)
        toSumTree(root.right);
        
    
}
}