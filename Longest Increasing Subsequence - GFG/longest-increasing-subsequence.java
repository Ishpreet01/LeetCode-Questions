//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    
    static int binsearch(ArrayList<Integer> list,int key){
        int low=0,high=list.size()-1;
        int ans=-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(list.get(mid)==key)return mid;
            
            else if(list.get(mid)<key)low=mid+1;
            
            else{
                ans=mid;
                high=mid-1;
            }
        }
        
        return ans;
    }
    static int longestSubsequence(int size, int a[])
    {
        // code here
        // int[] dp=new int[size];
        // int maxi=-1;
        // Arrays.fill(dp,1);
        
        // for(int ind=0;ind<size;ind++){
        //     for(int prev=0;prev<=ind-1;prev++){
        //         if(a[prev]<a[ind]){
        //             dp[ind]=Math.max(dp[ind],1+dp[prev]);
        //         }
        //     }
            
        //     maxi=Math.max(maxi,dp[ind]);
        // }
        
        // return maxi;
        
        ArrayList<Integer> list=new ArrayList<>();
        list.add(a[0]);
        
        for(int i=1;i<size;i++){
            if(a[i]>list.get(list.size()-1))
            list.add(a[i]);
            else{
                int idx=binsearch(list,a[i]);
                list.set(idx,a[i]);
            }
        }
        
        return list.size();
    }
} 