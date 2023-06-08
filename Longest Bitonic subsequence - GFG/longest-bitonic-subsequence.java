//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];
        
        int[] bitonic=new int[nums.length];
        int maxl=-1;
        
     
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        
        for(int ind=0;ind<nums.length;ind++){
            for(int prev=0;prev<ind;prev++){
                if(nums[prev]<nums[ind]){
                    dp1[ind]=Math.max(dp1[ind],1+dp1[prev]);
                }
            }
        }
        
        // for(int i=0;i<nums.length;i++)
        // System.out.print(dp1[i]+" ");
        
        for(int ind=nums.length-1;ind>=0;ind--){
            for(int prev=nums.length-1;prev>ind;prev--){
                if(nums[prev]<nums[ind])
                dp2[ind]=Math.max(dp2[ind],1+dp2[prev]);
            }
        }
        //   System.out.println();
        
        
        //  for(int i=0;i<nums.length;i++)
        // System.out.print(dp2[i]+" ");
        
        
       for(int i=0;i<nums.length;i++){
        if(dp1[i]+dp2[i]-1>maxl)
        maxl=dp1[i]+dp2[i]-1;
        }
        
        
        return maxl;
        
        
    }
}