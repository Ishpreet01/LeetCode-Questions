//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsackUtil(Item[] arr,int W){
        double profit=0.0;
		Arrays.sort(arr,new Comparator<Item>(){
		    @Override
		    public int compare(Item it1,Item it2){
		        double r1=(double) it1.value/(double)it1.weight;
		        double r2=(double)it2.value/(double)it2.weight;
		        
		        if(r1<r2)return 1;
		        
		        if(r1>r2) return -1;
		        
		        else return 0;
		    }
		});
		
		for(Item i: arr){
		    double curr_wt=i.weight;
		    double cur_val=i.value;
		    
		    if(W-curr_wt>=0){
		       profit+=cur_val;
		       W-=curr_wt;
		    }
		    
		    else{
		        double fraction=(W*cur_val)/curr_wt;
		        profit+=fraction;
		        break;
		    }
		}
		
		return profit;
	}

    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        
        return fractionalKnapsackUtil(arr,W);
    }
}