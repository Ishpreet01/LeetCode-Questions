//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp=new int[n][n+1];
        
        for(int N=0;N<=n;N++)
        dp[0][N]=N*price[0];
        
        for(int ind=1;ind<n;ind++){
            for(int N=0;N<=n;N++){
                int notTake=dp[ind-1][N];
                
                int take=Integer.MIN_VALUE;
                
                if(1+ind<=N)
                take=price[ind]+dp[ind][N-ind-1];
                
                dp[ind][N]=Math.max(take,notTake);
            }
        }
        
        return dp[n-1][n];
    }
}