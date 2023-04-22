//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            int res = g.getMaxWidth(root);
            System.out.println(res);
            // CLN.inorder(root);
            t--;
            // System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Pair{
    Node node;
    int num;
    Pair(Node _node,int _num){
        node=_node;
         num=_num;
    }
}
class Solution {
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(Node root) {
        // Your code here
        Queue<Node> q=new LinkedList<>();
        int maxSize=0;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
              Node n=q.poll();
              if(n.left!=null)
               q.add(n.left);
        
              if(n.right!=null)
              q.add(n.right);
        }
        //     int min=0,first=0,last=0;
        //     min=q.peek().num;
        //     for(int i=0;i<size;i++){
        //      int curr_id=q.peek().num-min;
        //      Node n=q.poll().node;
        //      if(i==0)first=curr_id;
        //      if(i==size-1)last=curr_id;
        //      if(n.left!=null)q.add(new Pair(n.left,2*curr_id+1));
        //      if(n.left==null &&  n.right!=null)q.add(new Pair(n.right,2*curr_id+1));
        //      if(n.left!=null && n.right!=null)q.add(new Pair(n.right,2*curr_id+2));
                
        //     }
        //     ans=Math.max(ans,last-first+1);
        // }
        if(size>maxSize)
        maxSize=size;
        
      
    }
    
    return maxSize;
}
}
