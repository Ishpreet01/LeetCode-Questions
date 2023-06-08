//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java



class Compute {
    
    public static int maxSumBS(int arr[], int n)
    {
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        int[] sum=new int[n];
        int maxi=-1;
      for(int i=0;i<n;i++)
      dp1[i]=arr[i];
      
      for(int i=0;i<n;i++)
      dp2[i]=arr[i];
      
      
        
        for(int ind=0;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                if(arr[prev]<arr[ind])
                dp1[ind]=Math.max(dp1[ind],arr[ind]+dp1[prev]);

            }
         }
        
        // for(int i=0;i<n;i++)
        // System.out.print(dp1[i]+" ");
        
        for(int ind=n-1;ind>=0;ind--){
            for(int prev=n-1;prev>ind;prev--){
                if(arr[prev]<arr[ind])
                dp2[ind]=Math.max(dp2[ind],dp2[prev]+arr[ind]);
            }
        }
        // System.out.println();
        // for(int i=0;i<n;i++)
        // System.out.print(dp2[i]+" ");
        
         // System.out.println();
        for(int i=0;i<n;i++){
        sum[i]=dp1[i]+dp2[i]-arr[i];
     //   System.out.print(sum[i]+" ");
        if(sum[i]>maxi)
        maxi=sum[i];
    }
    
    return maxi;
}
}