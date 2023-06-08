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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int findLCS(String S,String T,int[][] dp,int m,int n){
        for(int i=0;i<=m;i++)
        dp[i][0]=0;
        
        for(int j=0;j<=n;j++)
        dp[0][j]=0;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(S.charAt(i-1)==T.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
    int findMinInsertions(String S){
        // code here
        StringBuilder t=new StringBuilder(S);
        String T=t.reverse().toString();
        
        int m=S.length();
        int[][] dp=new int[m+1][m+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=m;j++)
            dp[i][j]=-1;
        }
        
        int len=findLCS(S,T,dp,m,m);
        
        return S.length()-len;
    }
}