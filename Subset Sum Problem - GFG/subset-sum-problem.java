//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

//   static int isSubsetSumUtil(int N,int[] arr,int sum){
//         int[][]dp=new int[N+1][sum+1];
        
//         for(int i=0;i<=N;i++)
//         for(int j=0;j<=sum;j++)
//         dp[i][j]=-1;
        
//         if(sum==0)
//         return 1;
        
//         if(N<=0)
//         return 0;
        
//         if(dp[N-1][sum]!=-1)
//         return dp[N-1][sum];
        
          
//         if(arr[N-1]>sum)
//         return dp[N-1][sum]=isSubsetSumUtil(N-1,arr,sum);
        
//         else{
        
//         if( isSubsetSumUtil(N-1,arr,sum)!=0 || isSubsetSumUtil(N-1,arr,sum-arr[N-1])!=0 )
//         return dp[N-1][sum]=1;
        
//         else
//         return dp[N-1][sum]=0;
//         }
//   }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
    //   int ans=isSubsetSumUtil(N,arr,sum);
       boolean[][] dp=new boolean[N][sum+1];
    //   int i;
    
    for(int i=0;i<N;i++)
    for(int j=0;j<=sum;j++)
    dp[i][j]=false;
       
       for(int i=0;i<N;i++)
       dp[i][0]=true;
       
       if(arr[0]<=sum)
       dp[0][arr[0]]=true;
       
       for(int idx=1;idx<N;idx++){
           for(int target=1;target<=sum;target++){
               boolean notTake=dp[idx-1][target];
               
               boolean take=false;
               if(arr[idx]<=target)
               take=dp[idx-1][target-arr[idx]];
               
               dp[idx][target]=take || notTake;
           }
       }
       
      return dp[N-1][sum];
    }
}