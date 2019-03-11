/* This is the code I designed to test my Deque20 class
   be sure to run it and tell me what you think :)
*/
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
public class Deque20Test
{
   public static void main(String[] args)
   {
      boolean pass;
      Deque20<String> test = new Deque20<String>();
      
   /* These initially test if the peek, remove, and pop methods work
   and throw an exception.
   The program will end as soon as it finds an error making testing
   earier.
   */ 
      try
      {
         test.peek();
         pass = false;
         System.out.println("peek: I dont feel so hot check me");
         System.out.println(pass);
         return;       
      }
      catch(NoSuchElementException e)
      {
         pass = true;
         System.out.println("peek: feeling good all systems green");
      }
      catch(Exception e)
      {
         pass = false;
         System.out.println("Close but no Cigar");
         System.out.println(pass);
         return;
      }
      try
      {
         test.remove();
         pass = false;
         System.out.println("remove: not running too hot check me");
         System.out.println(pass);
         return;       
      }
      catch(NoSuchElementException e)
      {
         pass = true;
         System.out.println("remove: Roger all is well here");
      }
      catch(Exception e)
      {
         pass = false;
         System.out.println("remove: not running too hot check me");
         System.out.println(pass);
         return;
      }
      try
      {
         test.pop();
         pass = false;  
         System.out.println("pop: SYSTEM FAILURE MAYDAY MAYDAY!");
         System.out.println(pass);
         return;
      }
      catch(NoSuchElementException e)
      {
         pass = true;
         System.out.println("pop: all systems stablizing");
      }
      catch(Exception e)
      {
         pass = false;
         System.out.println("pop: oof not too hot check me");
         System.out.println(pass);
         return;
      }
      
   // loads the deque with values testing .push and .add 
      test.push("apples");
      test.add("grapes");
      test.push("bananas");
      System.out.println(test);
      test.peek();
   //test if .size , .isEmpty , and peek change when values are added in deque
      if(test.size() !=3 || test.isEmpty() == true || test.peek() != "bananas")
      {
         pass = false;
         System.out.println("better check your size, isEmpty, or peek method");
         System.out.println(pass);
         return;
      }
      test.add("oranges");
      test.remove();
      test.pop();
      test.pop();
      test.remove();
      if(test.size() !=0 || test.isEmpty() == false)
      {
         pass = false;
         System.out.println("Size or isEmpty still not working bro");
         System.out.println(pass);
         return;
      }
      try
      {
         test.peek();
         pass = false;
         System.out.println("WOAH THERE CHECK YOUR PEEK AGAIN");
         System.out.println(pass);
         return;
      }
      catch(NoSuchElementException e)
      {
         pass = true;
         System.out.println("pop: Cabin door sealed and ready for launch");
      }
      catch(Exception e)
      {
         pass = false;
         System.out.println("close but no cigar");
         System.out.println(pass);
         return;
      }
      test.add("red");
      test.add("yellow");
      test.push("green");
      test.push("blue");
      test.push("orange");
      test.push("pink");
      test.push("silver");
      test.add("black");      
      if(test.remove() != "silver")
      {
         System.out.println("check your remove again bud");
         System.out.println(pass);
         return;
      } 
      test.add("purple");
      if(test.pop() != "pink" || test.peek() != "orange")
      {
         System.out.println("WRONG check peek or pop");
         System.out.println(pass);
         return;
      } 
      if(test.size() == 7 && test.isEmpty() == false)
      {
         pass = true;
         System.out.print("Final checks completed launch is a go");
         System.out.println(" commencing launch countdown procedure");
         System.out.println();
      }
      if(pass == true)
      {
         System.out.println("main engines: System Green");
         System.out.println("communications: System Green");
         System.out.println("electric power: System Green");
         System.out.println("fuel cells: System Green");
         System.out.println("orbital maneuvering: System Green");
         System.out.println("tank and booster conducter: System Green");
         System.out.println("payload test conducter: System Green");
         System.out.println("launch processing system: System Green");
         System.out.println("support test manager: System Green");
         System.out.println("flight director: System Green");
         System.out.println("ALL SYSTEMS GREEN LIFTOFF IN Tminus 3");
         try
         {
            Thread.sleep(1000);
         }
         catch(InterruptedException ex)
         {
            Thread.currentThread().interrupt();
         }
         for(int i = 0; i < 3; i++)
         {
            for(int j = 0; j < 3; j++)
            {
               System.out.println();
            }
         }
         for(int k = 3; k >= 1; k--)
         {   
            System.out.println("    We have lift of in: "+ k);
            try
            {
               Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
               Thread.currentThread().interrupt();
            }
         }   
         System.out.println();
         System.out.println();
         System.out.println();
         test.theRocket();
         System.out.println();
         for(int i = 0; i < 11; i++)
         {
            System.out.println("   /|      |\\"); 
            try
            {
               Thread.sleep(500);
            }
            catch(InterruptedException ex)
            {
               Thread.currentThread().interrupt();
            }
            for(int j = 0; j < 5; j++)
            {
               System.out.println("  //|      |\\\\");
            }
         }
         System.out.println();
         System.out.println();
         System.out.print(" Lift off: Success AKA: " + pass);
      }
      else
      {
         System.out.println(pass);
      }      
   }
}