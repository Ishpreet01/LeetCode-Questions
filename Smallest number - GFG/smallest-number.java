//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.smallestNumber(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String smallestNumber(int S, int D){
        // code here
        String ans="";
        int[] arr=new int[D];
        
        if(S>9*D)
        return "-1";
        
        if(D==1)
        return String.valueOf(S);
        
        S=S-1;
        arr[0]=1;
        for(int i=D-1;i>=1;i--){
            if(S>9){
            arr[i]=9;
            S=S-9;
            }
            else{
            arr[i]=S;
            S=0;
            }
        }
        
        if(S!=0)
        arr[0]+=S;
        
        for(int i=0;i<D;i++)
        ans=ans+arr[i];
        
        return ans;
    }
}