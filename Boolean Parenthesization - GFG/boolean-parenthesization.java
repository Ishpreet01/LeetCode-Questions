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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWaysUtil(int i,int j,int isTrue,String S,int[][][] dp){
        if(i>j) return 0;
        
        if(i==j){
            if(isTrue==1 && S.charAt(i)=='T') return 1 ;
            
            if(isTrue==1 && S.charAt(i)=='F') return 0;
            
            else {
                if(S.charAt(i)=='F')
                    return 1 ;
            }
            
            return 0;
        }
        
        if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
        
         int ways=0;
        for(int ind=i+1;ind<=j-1;ind+=2){
          
            int lt=countWaysUtil(i,ind-1,1,S,dp);
            int lf=countWaysUtil(i,ind-1,0,S,dp);
            int rt=countWaysUtil(ind+1,j,1,S,dp);
            int rf=countWaysUtil(ind+1,j,0,S,dp);
            
            if(S.charAt(ind)=='&'){
              if(isTrue==1)ways+=(lt*rt);
              else ways+=(lf*rt)+(lt*rf)+(lf*rf);
            }
            
            else if(S.charAt(ind)=='|'){
                if(isTrue==1) ways+=(lt*rf)+(lf*rt)+(lt*rt);
                else ways+=(lf*rf);
            }
            
            else if(S.charAt(ind)=='^'){
                if(isTrue==1) ways+=(lt*rf)+(lf*rt);
                else ways+=(lf*rf)+(lt*rt);
            }
            
        }
        
        
        return dp[i][j][isTrue]=ways%1003;
    }
    static int countWays(int N, String S){
        // code here
        
        int[][][] dp=new int[N][N][2];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<2;k++)
                    dp[i][j][k]=-1;
        }
        }
    
       return countWaysUtil(0,N-1,1,S,dp);
    }
}