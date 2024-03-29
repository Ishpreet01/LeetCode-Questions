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
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maximizeSum(a, n, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {

    public static long maximizeSum(long a[], int n, int k)
    {
        // Your code goes here  
        Arrays.sort(a);
        int i=0,j=0;
        long sum=0;
        
      //  for(int q=0;q<n;q++)
       // System.out.print(a[q]);
        
        
        for(i=0;i<n;i++){
            if(a[i]<0 && k>0){
                a[i]=-a[i];
                k--;
                j++;
                //sum=sum+a[i];
            }
        }
        
        if(k>0){
            if(k%2!=0 && j==n)
            a[n-1]=-a[n-1];
            
            if(k%2!=0 && j<n)
            a[j]=-a[j];
        }
        
        for(j=0;j<n;j++)
        sum=sum+a[j];
        
        return sum;
    }
}