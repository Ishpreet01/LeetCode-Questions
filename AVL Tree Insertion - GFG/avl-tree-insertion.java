//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
}
class Node
{
    int data, height;
    Node left, right;
    
    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
class GfG
{
    public static boolean isBST(Node n, int lower, int upper)
    {
    	if(n==null) return true;
    	if( n.data <= lower || n.data >= upper ) return false;
    	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }
    
    public static pair isBalanced(Node n)
    {
    	if(n==null)
    	    {
    	        return new pair(0,true);
    	    }
        
    	pair l = isBalanced(n.left);
    	pair r = isBalanced(n.right);
    
    	if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
    
    	return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }
    
    public static boolean isBalancedBST(Node root)
    {
    	if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
    		System.out.print("BST voilated, inorder traversal : ");
    
    	else if ( isBalanced(root).second == false)
    		System.out.print("Unbalanced BST, inorder traversal : ");
    
    	else return true;
    	return false;
    }
    
    public static void printInorder(Node n)
    {
    	if(n==null) return;
    	printInorder(n.left);
    	System.out.print(n.data + " ");
    	printInorder(n.right);
    }


    public static void main(String args[])
        {
            int ip[] = new int[2000];
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    for(int i = 0; i < n; i++)
                        {
                            ip[i] = sc.nextInt();
                        }
                        
                    Node root = null;
                    Solution obj = new Solution();
                    for(int i=0; i<n; i++)
                    {
                        root = obj.insertToAVL( root, ip[i] );
                        
                        if ( isBalancedBST(root) == false )
                            break;
                    }
                    
                    printInorder(root);
                    System.out.println();
                    
                }
            
                
        }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    int height;
};
*/

class Solution
{
    
    
    int getHeight(Node n){
        if(n==null)
        return 0;
        
        return n.height;
    }
    
    int getBalance(Node n){
        
        if(n==null)
        return 0;
        
        return getHeight(n.left)-getHeight(n.right);
    }
    
    Node newNode(int data){
    Node n=new Node(data);
  //  n.data=data;
   // n.height=1;
    
    return n;
}

    Node leftrotate(Node x){
       Node y=x.right;
       Node t2=y.left;
       
       y.left=x;
       x.right=t2;
       
       x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
       y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
       
       return y;
    }
    
     Node rightrotate(Node y){
       Node x=y.left;
       Node t2=x.right;
       
       x.right=y;
       y.left=t2;
       
       y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
       x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
      
       
       return x;
    }
    public  Node insertToAVL(Node node,int data)
    {
        //code here
        if(node==null)
        return newNode(data);
        
        if(data<node.data)
        node.left=insertToAVL(node.left,data);
        
        if(data>node.data)
        node.right=insertToAVL(node.right,data);
        
        node.height=1+Math.max(getHeight(node.left),getHeight(node.right));
        
        int bal=getBalance(node);
        
        if(bal>1 && data<node.left.data)
        return rightrotate(node);
        
        if(bal<-1 && data>node.right.data)
        return leftrotate(node);
        
        if(bal>1 && data>node.left.data){
            node.left=leftrotate(node.left);
            return rightrotate(node);
        }
        
        if(bal<-1 && data<node.right.data){
            node.right=rightrotate(node.right);
            return leftrotate(node);
        }
        
        return node;
        
        
        
    }
}    