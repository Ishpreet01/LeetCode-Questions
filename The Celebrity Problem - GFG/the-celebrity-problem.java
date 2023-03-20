//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here
    // 	int i,j,idx=0; this logic will not work if we have multiple ones in a single row    //  
    //for(i=0;i<n;i++){
    //  	    for(j=0;j<n;j++){
    //         if(M[i][j]==1){
    //  	           idx=j;
    // 	           break;
    // 	        }
    // 	    }
    // 	}
    	
    // 	for(j=0;j<n;j++)
    // 	if(M[idx][j]!=0)
    // 	break;
    	
    // 	if(j==n){
    // 	    for(i=0;i<n;i++){
    // 	        if(idx!=i && M[i][idx]!=1)
    // 	        break;
    // 	    }
    	    
    // 	    if(i==n)
    // 	    return idx;
    // 	}
    	
    // 	return -1;
    
    
    // // for(i=0;i<n;i++){
    // //   for( j=0;j<n;j++){
    // //   if(M[i][j]==1){
    // //       idx=1;
    // //   break;
    // //   }
    // //   }
    // //   if(j==n)
    // //   return i;
    // // }
    
    // // return -1;
    int[]outdegree=new int[n];
    int[] indegree=new int[n];
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(M[i][j]==1){
                outdegree[i]+=1;
                indegree[j]+=1;
            }
        }
    }
    
    for(int i=0;i<n;i++){
        if(outdegree[i]==0  && indegree[i]==n-1)
        return i;
    }
    
    return -1;
    }
            
        }
    