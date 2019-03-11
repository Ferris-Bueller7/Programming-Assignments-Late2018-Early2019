/**
 * Program that reads tokens from file data.txt and prints the integer
 * tokens found in it to the screen in increasing order.
 *
 * Ethan Covert 3859
 * 9/14/18
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays; 
public class Module1Program 
{
   public static int[] doubleArrayAndCopy(int[] arr)//this method doubles the array and then copies the info of the old array onto the new larger array 
   {
      int[] newArr = new int[arr.length*2];
      for(int i = 0; i < arr.length; i++)
      {
         newArr[i] = arr[i];         
      }
      return newArr;
         
   }
   public static void main(String[] args) 
   {
      int[] data = new int[8];
      Scanner file = null;
      int index = 0;
      String sCRAP = null;
      try
      { 
         file = new Scanner(new File("data.txt"));
         while (file.hasNext())
         {               
            if(file.hasNext(" "))//clears spaces before characters
            {
               sCRAP = file.next();   
            }
            if(file.hasNextInt())
            {
               if (index > data.length - 1) //checks to see if the index(number of integers) is larger than array if so then it calls doubleArrayAndCopy(data)
               {   
                  data = doubleArrayAndCopy(data);
               }
               data[index] = file.nextInt();
               index++;//increases the number of integers in index to keep track of total number of integers
            }
            else 
            {
                  //Stores all the stuff not needed in the text in a different locations mainly used for testing
               sCRAP = file.next();
            }
         }      
      }
      catch(FileNotFoundException e)   //if the file isn't found instead of giving an error this catches it and simply states "file not found" and ends the program.
      {
         System.out.println("File not found");
            
      }            
      int[] outArr = new int[index];
      for (int j = 0; j < index; j++)
      {
         outArr[j] = data[j];// this array is the new array that is exactly long enough to hold the number of integers from the txt file
      }
      Arrays.sort(outArr);// sorts the array from smallest to largests
      for(int x = 0; x < outArr.length; x++)
      {
         System.out.println(outArr[x]);
            
      }   
         
   }   
}