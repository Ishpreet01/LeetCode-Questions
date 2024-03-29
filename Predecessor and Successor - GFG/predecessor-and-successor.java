//{ Driver Code Starts
import java.util.*;

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

 class Res
    {
        Node pre = null;
        Node succ = null;
    }
class PreSucc
{
   
     public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
      public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t = sc.nextInt();
          
           while(t-->0){
            int n = sc.nextInt();
            if(n==0)
            {
                System.out.println(0);
                continue;
            }
            Node root = null;
           Res p = new Res();
           Res s = new Res();
            for(int i=0;i<n;i++){
                
                int a=sc.nextInt();
                int a1=sc.nextInt();
                
                char lr=sc.next().charAt(0);
                
                if(i==0){
                    
                    root=new Node(a);
                    
                    switch(lr)
                    {
                        
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            
            int key = sc.nextInt();
            GfG g=new GfG();
            g.findPreSuc(root, p, s, key);
            
            if(p.pre != null)
              System.out.print(p.pre.data + " ");
              else
              System.out.print("-1" + " ");
              
            if(s.succ != null)
              System.out.println(s.succ.data);
              else
              System.out.println("-1");
            
            
        }
    }
}
// } Driver Code Ends


/* BST Node
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class GfG
{
    static void storeInorder(Node root,ArrayList<Integer> arr){
        if(root==null)
        return;
        
        storeInorder(root.left,arr);
        arr.add(root.data);
        storeInorder(root.right,arr);
}
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
        ArrayList<Integer> arr=new ArrayList<>();
       int pin=-1,i;
       storeInorder(root,arr);
     //  System.out.println(arr);
       for(i=0;i<arr.size();i++){
           if(arr.get(i)>key)
           break;
       }
       
       if(i!=0 && arr.get(i-1)==key)
       pin=i-2;
       else if(i!=0 && arr.get(i-1)!=key)
       pin=i-1;
       
       if(pin>=0)
       p.pre=new Node(arr.get(pin));
       else
       p.pre=new Node(-1);
       
       if(i<arr.size())
       s.succ=new Node(arr.get(i));
       else
       s.succ=new Node(-1);
    }
}