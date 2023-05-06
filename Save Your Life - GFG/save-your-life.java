//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
      //  code here
        char[] arr=w.toCharArray();
        List<Character> list=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        list.add(x[i]);
        
      String ans="",temp="";
      int start=-1,sum=0,max=Integer.MIN_VALUE;
      for(int i=0;i<w.length();i++){
          char ch=w.charAt(i);
         temp=temp+ch;
          if(list.contains(ch)){
              int val=b[list.indexOf(ch)];
              sum+=val;
          }
          else
          sum+=(int)ch;
        
          if(sum>max){
          max=sum;
          ans=temp;
          }
          
            
          if(sum<0){
              sum=0;
              temp="";
          }
          
          
          
      }
       
      return ans;
    }
    
    //   HashMap<Character,Integer> charMap = new HashMap<>();
    //     for(int i=0;i<n;i++){
    //         charMap.put(x[i],b[i]);
    //     }
    //     int curMax = 0;
    //     int maxSum = Integer.MIN_VALUE;
    //     String curMaxStr = "";
    //     String maxStr = "";
    //     for(int j=0;j<w.length();j++){
    //         if(charMap.containsKey(w.charAt(j))) {
    //             curMax = curMax + charMap.get(w.charAt(j));
    //         } else {
    //             curMax = curMax + (int)w.charAt(j);
    //         }
    //         curMaxStr+= w.charAt(j);
    //         if(curMax > maxSum) {
    //             maxSum = curMax;
    //             maxStr = curMaxStr;
    //         }
    //         if( curMax < 0){
    //             curMaxStr = "";
    //             curMax = 0;
    //         }
    //     }
    //     return maxStr;
    // }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends