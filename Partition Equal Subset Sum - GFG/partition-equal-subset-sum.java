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
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
   static boolean canPartition(boolean[][] dp,int[] arr,int N,int target){
       for(int i=0;i<N;i++)
       dp[i][0]=true;
       
      if(arr[0]<=target) dp[0][arr[0]]=true;
       
       for(int i=1;i<N;i++){
           for(int j=1;j<=target;j++){
               boolean notTake=dp[i-1][j];
               boolean take=false;
               if(arr[i]<=j)
               take=dp[i-1][j-arr[i]];
               
               dp[i][j]=take || notTake;
           }
       }
       
       return dp[N-1][target];
    }
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++)
        sum+=arr[i];
        
        if(sum%2!=0)
        return 0;
        
        boolean[][] dp=new boolean[N][(sum/2)+1];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<(sum/2)+1;j++)
            dp[i][j]=false;
        }
        
        boolean res=canPartition(dp,arr,N,sum/2);
        
        if(res==true)
        return 1;
        
        return 0;
    }
}