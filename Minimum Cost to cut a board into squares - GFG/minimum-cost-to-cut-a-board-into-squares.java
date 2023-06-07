//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        Scanner sc=new Scanner(System.in);
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String P[]=br.readLine().trim().split(" ");
            int m=Integer.parseInt(P[0])-1;
            int n=Integer.parseInt(P[1])-1;
            String A[]=br.readLine().trim().split(" ");
            String B[]=br.readLine().trim().split(" ");
            ArrayList<Integer> l=new ArrayList<>();
            for(String s : A){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            for(String s : B){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            int [] X =new int[m];
            int [] Y=new int[n];
            int ind=0;
            for(int i=0;i<m;i++){
                X[i]=l.get(ind++);
            }
            for(int i=0;i<n;i++){
                Y[i]=l.get(ind++);
            }
            
            Solution obj = new Solution();
            int res = obj.minimumCostOfBreaking(X, Y,m,n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
        // code here
        int i=M-1,j=N-1,hrntl=1,vert=1;
        int res=0;
        
        // Integer[] X1=new Integer[M];
        // Integer[] Y1=new Integer[N];
        
        // for(int x: X)
        // X1[k++]=Integer.valueOf(x);
        
        
        // for(int y: Y)
        // Y1[p++]=Integer.valueOf(y);
        
        //  Arrays.sort(X1,Collections.reverseOrder()); // can be used with Integer array not int array
        //  Arrays.sort(Y1,Collections.reverseOrder());
        
        Arrays.sort(X);
        Arrays.sort(Y);
        
        while(i>=0 && j>=0){
            if(X[i]>Y[j]){
                res+=X[i]*vert;
                hrntl++;
                i--;
            }
            else{
                res+=Y[j]*hrntl;
                vert++;
                j--;
            }
        }
        
        
        int total=0;
        
        while(i>=0)
        total+=X[i--];
        
        res+=total*vert;
        
        
        total=0;
        
        while(j>=0)
        total+=Y[j--];
        
        res+=total*hrntl;
        
        
        return res;
    }
}
        
