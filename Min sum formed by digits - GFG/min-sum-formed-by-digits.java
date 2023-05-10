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
            
            Solution obj = new Solution();
            System.out.println(obj.minSum(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static long minSum(int arr[], int n)
    {
        // Your code goes here
        long a=0,b=0;
        Arrays.sort(arr);
        
        for(int i=0;i<n;i++){
           if(i%2==0)
           a=a*10+arr[i];
           else
           b=b*10+arr[i];
        }
        // for(int i=0;i<n;i++){
        //     if(i%2==0)
        //     n1=n1+arr[i];
        //     else
        //     n2=n2+arr[i];
        // }
        // if(n1.compareTo("")!=0)
        //  a=Integer.parseInt(n1);
        // if(n2.compareTo("")!=0)
        //  b=Integer.parseInt(n2);
         
         
        
        return a+b;
    }
}