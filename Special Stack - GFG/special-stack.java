//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
      Stack<Integer> aux=new Stack<>();
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    
	    if(s.isEmpty() && aux.isEmpty()){
	    aux.add(a);
	    s.add(a);
	    }
	    
	    else{
	        if(aux.peek()<a)
	        aux.add(aux.peek());
	        else
	        aux.add(a);
	        
	        s.add(a);
	    }
	    
	    
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            aux.pop();
            return s.pop();
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
          
        //   while(!s.isEmpty()){
        //       int a=s.pop();
        //       s2.add(a);
        //       if(a<min)
        //       min=a;
        //   }
        //   while(!s2.isEmpty())
        //   s.add(s2.pop());
        
           int min=aux.pop();
           return min;
           
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           if(s.size()==n)
           return true;
           
           return false;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           if(s.size()==0)
           return true;
           
           return false;
	}
}