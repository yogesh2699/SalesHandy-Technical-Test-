
import java.util.Scanner;

public class matrix {
 
	public static void main(String[] args) {
		//Main function to choose which function will work on select Minimum/Maximum.
		Scanner st = new Scanner(System.in);
		System.out.println("Please Enter Maximum or Minimum");
		String s = st.nextLine();
		if(s.equals("Maximum")){
			Max();   //Max() function will call if User enter Maximum.
		}
		else if(s.equals("Minimum")) {
			Min();   //Min() function will call if user enter Minimum.
		}
		else{
			System.out.println("Please enter the correct keyword");
		}
		
} 
	private static void Min() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No. of Rows: ");
		int  N = sc.nextInt();
		System.out.println("Enter No. of Column: ");
		 int M = sc.nextInt();
		 System.out.println("Enter the Element in Matrix of "+N+"*"+M+"");
		 int[][] arr = new int[N][M];
		 
		 for(int i=0;i<N;i++)
		 {
			 for(int j=0;j<M;j++){
				 int element = sc.nextInt();
				 arr[i][j] = element;
			 }
		 }
		 
		 int[] row_result = new int[N];
		 int[] col_result = new int[M+1];
                  // Calling the function  
		 //smallest element in Matrix rows are insert in Array row 
                int[] row =  smallestInRow(N,M, arr, row_result); 
        //Create a Temporary array to append Sorted Array row with Matrix.
          int[][] temparr = new int[N+1][M+1];
          for(int i=0;i<N+1;i++){
        	  for(int j=0;j<M+1;j++){
        		  temparr[i][j]=0;
        	  }
          }
          for(int i=0;i<N;i++){
        	  for(int j=0;j<M;j++){
        		  temparr[i][j]=arr[i][j];
        	  }
          }
          //Append a row Array with Temporary Matrix
          for(int i=0;i<N;i++){
        	  int element = row[i];
        	  temparr[i][M] = element;
          }
          //smallest element in Matrix Column are inserted in Array col
          int[] col = smallestInCol(N,M+1,temparr,col_result);
          //Append col Array with temporary Matrix.
        for(int i=0;i<M+1;i++){
        	  int element = col[i];
        	  temparr[N][i] = element;
          }
          
          //Printing the Newly Created Matrix
          System.out.println("Newly Created Matrix in Minimum operation:-");
          for(int i=0;i<N+1;i++){
        	  for(int j=0;j<M+1;j++){
        		  System.out.print(temparr[i][j]+" ");
        	  }
        	  System.out.println(" ");
        	  }	
		
	}
	public static void Max(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No. of Rows: ");
		int  N = sc.nextInt();
		System.out.println("Enter No. of Column: ");
		 int M = sc.nextInt();
		 System.out.println("Enter the Element in Matrix of "+N+"*"+M+"");
		 int[][] arr = new int[N][M];
		 
		 for(int i=0;i<N;i++)
		 {
			 for(int j=0;j<M;j++){
				 int element = sc.nextInt();
				 arr[i][j] = element;
			 }
		 }
		 int[] row_result = new int[N];
		 int[] col_result = new int[M+1];
		 // Calling the function  
		 //largest element in Matrix rows are insert in Array row
                int[] row =  largestInRow(N, M, arr, row_result); 
              //Create a Temporary array to append Sorted Array row with Matrix.
          int[][] temparr = new int[N+1][M+1];
          for(int i=0;i<N+1;i++){
        	  for(int j=0;j<M+1;j++){
        		  temparr[i][j]=0;
        	  }
          }
          for(int i=0;i<N;i++){
        	  for(int j=0;j<M;j++){
        		  temparr[i][j]=arr[i][j];
        	  }
          }
          //Append a row Array with Temporary Matrix
          for(int i=0;i<N;i++){
        	  int element = row[i];
        	  temparr[i][M] = element;
          }
          //largest element in Matrix Column are inserted in Array col
          int[] col = largestInCol(N,M+1,temparr,col_result);
        //Append a col Array with Temporary Matrix
          for(int i=0;i<M+1;i++){
        	  int element = col[i];
        	  temparr[N][i] = element;
          }
          System.out.println("Newly Created Matrix in Maximum operation:-");
          for(int i=0;i<N+1;i++){
        	  for(int j=0;j<M+1;j++){
        		  System.out.print(temparr[i][j]+" ");
        	  }
        	  System.out.println(" ");
        	  }
	}
	 
 // Function to get minimum element in column
    public static int[] smallestInCol(int n,int m , int[][] temparr, int[] col_result) { 
    	for (int i = 0; i < m; i++) { 
    		  
            // initialize the minimum element  
            // as first element  
            int minm = temparr[0][i]; 
  
            // Run the inner loop for columns  
            for (int j = 1; j < n; j++) { 
  
                // check if any element is smaller  
                // than the minimum element of the column  
                // and replace it  
                if (temparr[j][i] < minm) { 
                    minm = temparr[j][i]; 
                } 
            } 
  
            // insert the smallest element of the row in col_result array  
            col_result[i] = minm; 
        } 
        
		return col_result; 
  
    }
 // Function to get minimum element in Row
    public static int[] smallestInRow(int n,int m, int[][] arr, int[] row_result) { 
    	for (int i = 0; i < n; i++) { 
    		  
            // initialize the minimum element  
            // as first element  
            int minm = arr[i][0]; 
  
            for (int j = 1; j < m; j++) { 
  
                // check if any element is smaller  
                // than the minimum element of the row  
                // and replace it  
                if (arr[i][j] < minm) { 
                    minm = arr[i][j]; 
                } 
            } 
  
            // insert the smallest element of the row in row_result array  
            row_result[i] = minm; 
        }
        
		return row_result; 
  
    }
 // Function to get maximum element in column
    public static int[] largestInCol(int n,int m , int[][] temparr, int[] col_result) { 
    	for (int i = 0; i < m; i++) { 
  		  
            // initialize the maximum element  
            // as first element  
            int minm = temparr[0][i]; 
  
            // Run the inner loop for columns  
            for (int j = 1; j < n; j++) { 
  
                // check if any element is smaller  
                // than the maximum element of the column  
                // and replace it  
                if (temparr[j][i] > minm) { 
                    minm = temparr[j][i]; 
                } 
            } 
  
            // insert the largest element of the row in col_result array  
            col_result[i] = minm; 
        } 
        
		return col_result; 
  
    }
 // Function to get max element in Row
    public static int[] largestInRow(int n,int m, int[][] arr, int[] row_result) { 
    	for (int i = 0; i < n; i++) { 
  		  
            // initialize the maximum element  
            // as first element  
            int minm = arr[i][0]; 
  
            for (int j = 1; j < m; j++) { 
  
                // check if any element is smaller  
                // than the maximum element of the row  
                // and replace it  
                if (arr[i][j] > minm) { 
                    minm = arr[i][j]; 
                } 
            } 
  
            // insert the largest element of the row in row_result array  
            row_result[i] = minm; 
        }
        
		return row_result;  
  
    }
    }
//Program End