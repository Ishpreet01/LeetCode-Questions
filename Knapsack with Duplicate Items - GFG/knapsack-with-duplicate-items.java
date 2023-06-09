//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    // static int knapSackUtil(int W,int ind,int[] val,int[] wt){
    //     if(ind==0){
    //         if(wt[0]<=W)
    //         return W/wt[0]*val[0];
    //         else
    //         return 0;
    //     }
        
    //     if(W==0) return 0;
        
    //     int notTake=knapSackUtil(W,ind-1,val,wt);
        
    //     int take=Integer.MIN_VALUE;
        
    //     if(wt[ind]<=W)
    //     take=val[ind]+knapSackUtil(W-wt[ind],ind,val,wt);
        
    //     return Math.max(take,notTake);
    // }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
    //    int profit=0;
        
        int[][] dp=new int[N][W+1];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=0;
            }
        }
        
        for(int w=0;w<=W;w++)
        dp[0][w]=w/wt[0]*val[0];
        
        for(int ind=0;ind<N;ind++)
        dp[ind][0]=0;
        
        for(int ind=1;ind<N;ind++){
            for(int w=0;w<=W;w++){
                int notTake=dp[ind-1][w];
                
                int take=Integer.MIN_VALUE;
                
                if(wt[ind]<=w)
                take=val[ind]+dp[ind][w-wt[ind]];
                
                dp[ind][w]=Math.max(take,notTake);
            }
        }
         return dp[N-1][W];
    }
    
    // return profit=knapSackUtil(W,N-1,val,wt);
}