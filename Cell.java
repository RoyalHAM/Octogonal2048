import java.util.*;
public class Cell<Integer>
{
   private Integer object;
   private int row;
   private int column; 
   public Cell(int r,int c,Integer obj) 
   {
      object=obj;
      row=r;
      column=c;
   }
   public int getColumn()
   {
      return column;
   }
   public int getRow()
   {
      return row;
   }
   public Integer get()
   {
      return object;
   }
   public void setColumn(int c)
   {
      column=c;
   }
   public void setRow(int r)
   {
      row=r;
   }
   public void set(Integer obj)
   {
      object=obj;
   }
   public String toString()
   {
      return this.get()+" ";
   
   }
}