//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int i;
    static List<Integer> minPartitionUtil(int N,List<Integer> ans,List<Integer> deno){
        if(N==0)
        return ans;
        
        if(deno.contains(N)){
        ans.add(N);
        return ans;
        }
        
        if(N>2000){
            ans.add(2000);
             return minPartitionUtil(N-2000,ans,deno);
        }
        
        for(i=0;i<deno.size();i++){
            if(deno.get(i)>N){
                ans.add(deno.get(i-1));
                break;
        }
    }
     return minPartitionUtil(N-deno.get(i-1),ans,deno);
    
    }
    
    
    static List<Integer> minPartition(int N)
    {
        // code here
        List<Integer> ans=new ArrayList<>();
        List<Integer> deno=new ArrayList<>();
        deno.add(1);
        deno.add(2);
        deno.add(5);
        deno.add(10);
        deno.add(20);
        deno.add(50);
        deno.add(100);
        deno.add(200);
        deno.add(500);
        deno.add(2000);
        
        return minPartitionUtil(N,ans,deno);
        
    }
}