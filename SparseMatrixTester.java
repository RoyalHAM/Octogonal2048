   public class SparseMatrixTester
   {
      public static void main(String[] arg)
      {
         SparseMatrix<Integer> sm = new SparseMatrix(5, 5);
         //sm will be a 4 x 5 array of Strings
      	System.out.print("\n'q' to swipe diagonally up left, \n'w' to swipe up, \n'e' to swipe diagonally up right, \n'd' to swipe left, \n'c' to swipe diagonally down left, \n'x' to swipe down, \n'z' to swipe diagonally down left, \n'a' to swipe left\n");
         sm.add(0,2,1);
         sm.add(2,2,2);
         sm.add(4,2,3);
         sm.setBlank("-");
         System.out.println(sm);					//show the contents of the sparse matrix
         
         System.out.println(sm.get(4,2));
      
         /*
      	should display something like:
      									0 1 2 3 4
      	- - - - D		or		 0         D
      	- - - - -             1                  
      	- A - - - 				 2   A      
      	- - - - -				 3          
      	
      	
         
         System.out.println(temp1);		//should be A
         System.out.println(temp2);		//should be B
         System.out.println(temp3);		//should be C
         sm.clear();
         System.out.println(sm);	
         */
      }
   }
