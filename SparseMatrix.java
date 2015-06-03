import java.util.*;
import java.io.*;
public class SparseMatrix<Integer>
{
   public ArrayList<Cell<Integer>>list=new ArrayList<Cell<Integer>>();
   private int numElements;
   private int numRows,numCols;
   private String blank="-";
   public SparseMatrix(int r,int c)
   {
      numRows = r;
      numCols = c;
   }
   public int size()			//returns # actual elements stored
   {
      return numElements;
   }
   
   public int numRows()	//returns # rows set in constructor
   {
      return numRows;
   }
   
   public int numColumns()	//returns # cols set in constructor
   {
      return numCols;
   }
   
   private int getKey(int r,int c)
   {
      return r*this.numColumns()+c;
   }
   
   public void add(int r, int c, Integer x)	   //adds obj at row r, col c
   {
      numElements++;
      Cell object = new Cell(r,c,x);
      
      int key=getKey(r,c);
      if(list.size()==0)
      {
         list.add(object);
         return;
      }
      Cell last = list.get(list.size()-1);
      if(key > getKey(last.getRow(),last.getColumn()))
      {
         list.add(object);
         return;
      }
      for(int i=0;i<list.size();i++)
      {
         if(getKey(list.get(i).getRow(),list.get(i).getColumn())<key)
         {
            list.add(i,object);
            return;
         }  
      }
      list.add(list.size(),object);
      return;
   }
   
   public Integer get(int r,int c)
   {
      int key = getKey(r,c);
      for(int k=0;k<list.size();k++)
      {
         return list.get(k).get();
      }
      return null;
   }
   public Integer set(int r, int c, Integer x)
   {
      Cell<Integer> object = new Cell<Integer>(r,c,x);
      for(int i=0;i<list.size();i++)
         if(getKey(list.get(i).getRow(),list.get(i).getColumn())==getKey(r,c))
            return list.set(i,object).get();
      for(int j=0;j<list.size();j++)
         if(getKey(list.get(j).getRow(),list.get(j).getColumn())>getKey(r,c))
         {
            list.add(j,object);
            break;
         }
      return null;
   }
   public Integer remove(int r, int c)
   {
      for(int i=0; i<list.size(); i++)
         if(getKey(list.get(i).getRow(),list.get(i).getColumn())==getKey(r,c))
            return list.remove(i).get();
      return null;
   }
   public String toString()
   {
      boolean check=false;
      String str="";
      for(int i=0;i<numRows();i++)
      {
         for(int j=0;j<numColumns();j++)
         {
            for(int k=0;k<list.size();k++)
            {
               check=false;
               if(list.get(k).getRow()==i&&list.get(k).getColumn()==j)
               {
                  str+=list.get(k).toString();
                  check=true;
                  break;
               }
            } 
            if(!check)
               if((i==numRows()-1&&j==numColumns()-1)||(i==0&&j==numColumns()-1)||(i==numRows()-1&&j==0)||(i==0&&j==0))
                  //     bottom right corner                top right corner       bottom left corner   top right corner
                  str+="  ";
               else
                  str+=blank+" ";
                  
         }
         str+="\n";
      }
      return str;
   }
   public void setBlank(String x)
   {
      blank=x;
   }
   public void clear()
   {
      
      list.clear();
   }
   public boolean isValid(int r,int c)
   {
      if((r==0&&c==numColumns()-1)||(r==0&&c==0)||(c==0&&r==numRows()-1)||(c==numColumns()-1&&r==numRows()-1)||get(r,c)!=null)
         return false;
      return true;
   }
   
}