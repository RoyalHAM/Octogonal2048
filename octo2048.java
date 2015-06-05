import java.util.*;
public class octo2048
{
   public static final int RANDOM_INT1=1;
   public static final int RANDOM_INT2=2;
   public static final int WIN_VALUE=2048;
   public static char move;
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
            move=input.nextLine().toLowerCase().charAt(0);
            while(!swipe(move))
            {
               System.out.println("Please enter a valid direction.");
               move=input.nextLine().toLowerCase().charAt(0);
            }
         }
         System.out.println("Would you like to play again?");
         String ans=input.nextLine();
         ans=ans.toLowerCase();
         if(ans.equals("yes")||ans.equals("y")||ans.equals("ye")||ans.equals("yes"))
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
   public static int replace(int r1, int c1,int r2,int c2)
   {
      if(sm.get(r2,c2)==null)
      {
         sm.set(r2,c2,sm.get(r1,c1));
         return 0;
      }
      if(sm.get(r1,c2).equals(sm.get(r2,c2)))
      {
         doubleCapacity(r2,c2);
         return 1;
      }
      return -1;
   }
   public static void doubleCapacity(int r,int c)
   {
      Integer i=sm.set(r,c,sm.get(r,c)*2);
   
   }
   //movement methods
   public static boolean swipe(char input)
   {
      int trav=0;
      int loc1;
      int loc2;
      if(input=='q') //diagonal up left
      {
      
         return true;
      }
      if(input=='w') //up
      {
         while(trav<sm.numColumns())
         {
            if(trav==0||trav==sm.numColumns()-1)
            {
            
            }
            else
            {}
         }
         return true;
      }
      if(input=='e') //diagonal up right
      {
      
         return true;
      }
      if(input=='d') //left
      {
      
         return true;
      }
      if(input=='c') //diagonal down left
      {
      
         return true;
      }
      if(input=='x') //down
      {
      
         return true;
      }
      if(input=='z') //diagonal down right
      {
      
         return true;
      }
      if(input=='a') //right
      {
      
         return true;
      }
      return false;
   }
   
   
   
   
   
   
   
   
}