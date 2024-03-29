//{ Driver Code Starts
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
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        Queue<Character> q=new LinkedList<>();
        char[] count=new char[26];
        String ans="";
        
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            
            count[ch-'a']++;
            
            q.add(ch);
            
            while(!q.isEmpty()){
                if(count[q.peek()-'a']>1)
                q.remove();
                
                else{
                    ans=ans+q.peek();
                    break;
                }
            }
            
            if(q.isEmpty())
            ans=ans+"#";
            
        }
        
        
        return ans;
    }
}