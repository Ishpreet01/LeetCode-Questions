//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
    
}

class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    
    static int activitySelectionUtil(int start[], int end[], int n){
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (p1,p2)->p1.first-p2.first);
            ArrayList<Pair> list=new ArrayList<>();
            
        for(int i=0;i<n;i++)
        pq.add(new Pair(end[i],start[i]));
        
        Pair it=pq.poll();
        int begin=it.second;
        int finish=it.first;
        
        list.add(new Pair(begin,finish));
        
        while(!pq.isEmpty()){
            Pair itr=pq.poll();
            if(itr.second>finish){
                begin=itr.second;
                finish=itr.first;
                list.add(new Pair(finish,begin));
            }
        }
        
        
        return list.size();
        
    
    }
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
     //   int count=1;
     int count=0;
        
        // for(int i=0;i<n-1;i++){
        //     for(int j=0;j<n-i-1;j++){
        //         if(end[j]>end[j+1]){
        //             int t=end[j];
        //             end[j]=end[j+1];
        //             end[j+1]=t;
                    
        //             int p=start[j];
        //             start[j]=start[j+1];
        //             start[j+1]=p;
                    
        //         }
        //     }
        // } O(n^2) solution
        
        //O(NlogN) solution
      count=activitySelectionUtil(start,end,n);
        
        
        
        // int j=0;
        
        // for(int i=1;i<n;i++){
        //     if(start[i]>end[j]){ //this required because we need to compare it with the first activity that we selected instead of the previous one
        //     count++; 
        //   j=i;
        //     }
        // }
        
        return count;
    }
}