//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        int count=0,j=0;
       
        if(s1.length()!=s2.length())
        return false;
        
       int[] arr1=new int[256];
       int[] arr2=new int[256];
        Arrays.fill(arr1,0);
        Arrays.fill(arr2,0);
        
        for(int i=0;i<s1.length();i++){
           arr1[(int)s1.charAt(i)]++;
        }
       // System.out.println("b freq= "+arr1[102]);
         for(int i=0;i<s2.length();i++){
          arr2[(int)s2.charAt(i)]++;
          // System.out.println(arr2[i]+" ");
        }
        
        for(int i=0;i<256;i++){
            if(arr1[i]>0 && arr1[i]>=arr2[i])
            count=count+(arr1[i]-arr2[i]);
        }
        
       //  System.out.println("Count= "+ count);
             
             if(count>k)
             return false;
        
        return true;
    }
}