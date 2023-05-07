//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
          int[][][] dp=new int[30][30][30];
    int LCSof3Util(String A,String B,String C,int n1,int n2,int n3){
        
        if(n1==0 || n2==0 || n3==0)
        return 0;
        
        if(dp[n1][n2][n3]!=-1)
        return dp[n1][n2][n3];
        
        if(A.charAt(n1-1)==B.charAt(n2-1) && B.charAt(n2-1)==C.charAt(n3-1))
         return dp[n1][n2][n3]=1+LCSof3Util(A,B,C,n1-1,n2-1,n3-1);
        
        
        return dp[n1][n2][n3]=Math.max(LCSof3Util(A,B,C,n1-1,n2,n3),Math.max(LCSof3Util(A,B,C,n1,n2-1,n3),LCSof3Util(A,B,C,n1,n2,n3-1)));
        
    }
    
    // String printLCS(char[] arr,int[][] dp1,int m,int n,String A,String B,int index){
    //     int i=m,j=n;
    //     String ans="";
        
    //     while(i>0 && j>0){
    //         if(A.charAt(i-1)==B.charAt(j-1)){
    //             arr[index]=A.charAt(i-1);
    //             index--;
    //             i--;
    //             j--;
    //         }
            
    //         else if(dp1[i-1][j]>dp1[i][j-1])
    //         i--;
            
    //         else
    //         j--;
    //     }
        
    //     for(int k=0;k<arr.length;k++)
    //     ans=ans+arr[k];
        
    //     return ans;
    // }
    
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
       
      
        
        for(int i=0;i<30;i++)
        for(int j=0;j<30;j++)
        for(int k=0;k<30;k++)
        dp[i][j][k]=-1;
        
        int l=LCSof3Util(A,B,C,n1,n2,n3);
       //   System.out.println(l1);
        // char[] ans1=new char[l1];
        // int index1=l1-1;
        // String temp=printLCS(ans1,dp1,n1,n2,A,B,index1);
        
        // System.out.println(temp);
      //  return 0;
        
        //   int[][] dp2=new int[l1+1][n3+1]; //rows in the dp array represent the first string
          
        //   for(int i=0;i<=l1;i++)
        //   for(int j=0;j<=n3;j++)
        //   dp2[i][j]=-1;
        
         return l;
        //  char[] ans2=new char[l2];
        // int index2=l2-1;
        // String str=printLCS(ans2,dp2,n3,l2, C,temp,index2);
        
        // return str;
        
    }
} 