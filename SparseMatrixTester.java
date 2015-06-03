   public class SparseMatrixTester
   {
      public static void main(String[] arg)
      {
         SparseMatrix<Integer> sm = new SparseMatrix(5, 5);
         //sm will be a 4 x 5 array of Strings
      	System.out.print("\n'q' to swipe diagonally up left, \n'w' to swipe up, \n'e' to swipe diagonally up right, \n'd' to swipe left, \n'c' to swipe diagonally down left, \n'x' to swipe down, \n'z' to swipe diagonally down left, \n'a' to swipe left\n");
         sm.add(2, 1, 1);
         sm.add(0, 3, 2);
         sm.add(3, 3, 8);
         sm.add(1, 4, 32);
         sm.add(1, 3, 64);
         sm.add(2, 3, 8);
         
         
         
         
         Integer temp1 = sm.get(2, 1);			//get the element at row 2, col 1
         Integer temp2 = sm.set(0, 3, 2048);	//change the element at row 0, col 4 to a D, return the old value
         Integer temp3 = sm.remove(3, 3);		//remove the element at row 3, col 3 and return its value
         sm.setBlank("-");
         System.out.println(sm);					//show the contents of the sparse matrix
      
         /*
      	should display something like:
      									0 1 2 3 4
      	- - - - D		or		 0         D
      	- - - - -             1                  
      	- A - - - 				 2   A      
      	- - - - -				 3          
      	
      	*/
         
         System.out.println(temp1);		//should be A
         System.out.println(temp2);		//should be B
         System.out.println(temp3);		//should be C
         sm.clear();
         System.out.println(sm);	
      }
   }
