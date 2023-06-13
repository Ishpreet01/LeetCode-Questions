//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int maxCoinsUtil(int[] a,int i,int j,int[][] dp){
        if(i>j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int maxc=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost=a[i-1]*a[ind]*a[j+1]+maxCoinsUtil(a,i,ind-1,dp)+maxCoinsUtil(a,ind+1,j,dp);
            maxc=Math.max(cost,maxc);
        }
        
        return dp[i][j]=maxc;
    }
  public static int maxCoins(int N, int[] arr) {
    // code here
    int[] a=new int[arr.length+2];
    int len=arr.length+2;
    a[0]=1;
    for(int i=1;i<len-1;i++){
        a[i]=arr[i-1];
    }
    
    a[len-1]=1;
    int[][] dp=new int[N+2][N+2];
    
    // for(int i=0;i<=N;i++){
    //     for(int j=0;j<=N;j++)
    //     dp[i][j]=-1;
    // }
    
    // for(int i=N;i>0;i--){
    //     for(int j=1;j<=N;j++){
    //         if(i>j) dp[i][j]=0;
    //     }
    // } this base case gets covered because by default everything will be zero
        
        
    for(int i=N;i>0;i--){
        for(int j=1;j<=N;j++){
        if(i>j) continue;
          int maxc=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost=a[i-1]*a[ind]*a[j+1]+dp[i][ind-1]+dp[ind+1][j];
            maxc=Math.max(cost,maxc);
        }
        
        dp[i][j]=maxc;
        }
    }
  
  //  int ans=maxCoinsUtil(a,1,len-2,dp);
    return dp[1][N];

  }
}
     