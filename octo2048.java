import java.util.*;
public class octo2048
{
   public static final int RANDOM_INT1=1;
   public static final int RANDOM_INT2=2;
   public static final int WIN_VALUE=2048;
   private static SparseMatrix<Integer> sm = new SparseMatrix(5,5);
   public static void main(String[]args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to Octogonal 2048!");
      boolean isPlaying=true;
      while(isPlaying)
      {
         while(true)
         { //each turn starts here
            if(checkForLose())
            {
               System.out.println("You lost!");
               break;
            }
            if(checkForWin())
            {
               System.out.println("You won!");
               break;
            }
            newRandomInt();
            System.out.print(sm);
            System.out.print("\n'q' to swipe diagonally up left, \n'w' to swipe up, \n'e' to swipe diagonally up right, \n'd' to swipe left, \n'c' to swipe diagonally down left, \n'x' to swipe down, \n'z' to swipe diagonally down left, \n'a' to swipe left\n");
         }
         System.out.println("Would you like to play again?");
         String ans=input.nextLine();
         if(ans.equals("yes"))
            reset();
         else
            isPlaying=false;
      }
      System.out.println("Thanks for playing.");
   }
   public static void reset()
   {
      sm.clear();
   }
   public static boolean checkForWin()
   {
      for(int i=0;i<sm.list.size();i++)
         if(sm.list.get(i).equals(WIN_VALUE))
            return true;
      return false;
   }
   public static boolean checkForLose()
   {
      if(sm.list.size()==21)
         return true;
      return false;
   }
   public static void newRandomInt()
   {
      int r=0;
      int c=0;
      while(!sm.isValid(r,c)) //checks if location at (r,c) is both null and not in one of the corners
      {
         r=(int)(Math.random()*sm.numRows());
         c=(int)(Math.random()*sm.numColumns());
      }
      sm.add(r,c,(int)(Math.random()*2+1));
   }
   //assume (r1,c1) is a valid index
   public static void replace(int r1, int c1,int r2,int c2)
   {
      if(sm.get(r2,c2)==null)
      {
         sm.set(r2,c2,sm.get(r1,c1));
      }
      if(sm.get(r1,c2).equals(sm.get(r2,c2)))
      {
         doubleCapacity(r2,c2);
      }
      return;
   }
   public static void doubleCapacity(int r,int c)
   {
   Integer i=sm.set(r,c,sm.get(r,c)*2);
   
   }
   //movement methods
   public static void swipe(char input)
   {
      if(input=='q') //diagonal up left
      {
      
         return;
      }
      if(input=='w') //up
      {
      
         return;
      }
      if(input=='e') //diagonal up right
      {
      
         return;
      }
      if(input=='d') //left
      {
      
         return;
      }
      if(input=='c') //diagonal down left
      {
      
         return;
      }
      if(input=='x') //down
      {
      
         return;
      }
      if(input=='z') //diagonal down right
      {
      
         return;
      }
      if(input=='a') //right
      {
      
         return;
      }
      return;
   }
   
   
   
   
   
   
   
   
}