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
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        int res=0;
        Stack<Integer> st=new Stack<>();
        st.add(-1);
        // if(S.length()==1) this logic gives the total count of valid parentheses
        // return 0;
        
        // for(int i=0;i<S.length();i++){
        //     char ch=S.charAt(i);
        //     if(ch=='(')
        //     st.add(ch);
        //     else{
        //         if(!st.isEmpty()){
        //         st.pop();
        //         count++;
        //         }
        //     }
        // }
        
        // return count*2;
        
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch=='(')
            st.add(i);
            else{
                if(!st.isEmpty())
                st.pop();
                
                if(!st.isEmpty())
                res=Math.max(res,i-st.peek());
                
                else
                st.add(i);
            }
        }
        
        return res;
        
        
    }
}