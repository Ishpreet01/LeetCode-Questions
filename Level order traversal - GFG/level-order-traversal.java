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
        	    Solution g = new Solution();
                ArrayList <Integer> res = g.levelOrder(root);
                for (Integer num : res) System.out.print(num + " ");
    			System.out.println();
                t--;
            
        }
    }
   
}


// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution
{
    //Function to return the level order traversal of a tree.
   
    public static int height(Node node){
        if(node==null)
        return 0;
        
        else{
        int lheight=height(node.left);
        int rheight=height(node.right);
        
        if(lheight>rheight)
        return lheight+1;
        
        else
        return rheight+1;
        }
    }
    
    static void currentLevel(Node node,int i,ArrayList<Integer> ans){
        
        if(node==null)
        return;
        
        if(i==1){
         ans.add(node.data);
      // return;
    //  System.out.print(node.data+" ");
        }
        
        else if(i>1){
          
            currentLevel(node.left,i-1,ans);
             
            currentLevel(node.right,i-1,ans);
        }
    }
    static ArrayList <Integer> levelOrder(Node node) 
    {
        // Your code here
         ArrayList<Integer> ans=new ArrayList<>();
        int h=height(node);
       
        for(int i=1;i<=h;i++)
         currentLevel(node,i,ans);
    //   Queue<Node> q=new LinkedList<>();
    //   q.add(node);
      
    //   while(!q.isEmpty()){
    //       ans.add(q.data);
    //       if(node.left!=null || node.right!=null){
    //       q.remove();
    //       q.add(node.left);
    //       q.add(node.right);
    //   }
    
    return ans;
    }
}





