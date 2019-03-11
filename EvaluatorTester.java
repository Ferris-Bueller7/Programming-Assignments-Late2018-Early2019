/** This is a simple tester to see if my code will break
 *    against errors that I feel would break unprepared codes
 * 
 *
 *
 * @author Ethan Covert
 * @version 12/6/18
 */
import java.util.Deque;
import java.util.ArrayDeque;
import java.math.BigInteger;
public class EvaluatorTester
{ 
   public static void main(String[] args)
   {
      boolean pass = true;
      Deque<String> test = new ArrayDeque<>();
      Deque<String> test2 = new ArrayDeque<>();
      BigInteger test3;
      test.add("1");
      test.add("+");
      test.add("2");
      test.add("-");
      test.add("3");
      if(test.toString().equals("[1, +, 2, -, 3]"))
      {
         pass = true;
      }
      else
      {
         pass = false;
         System.out.println("test 1: failed");
      }
      if(pass == true)
      {
         test2 = Evaluator.infixToPostfix(test);
         if(test2.toString().equals("[1, 2, +, 3, -]"))
         {
            pass = true;
         }
         else
         {
            pass = false;
            System.out.println("test 2: failed");
         }
      }
      if(pass == true)
      {
         BigInteger result = new BigInteger("0");
         test3 = new BigInteger(Evaluator.evalPostfix(test2).toString());
         if(test3.equals(new BigInteger("0")))
         {
            pass = true;
         }
         else
         {
            pass = false;
            System.out.println("test 3: failed");
         }
      }
      if(pass == true)
      {
         test.clear();
         test2.clear();
         test.add("1");
         test.add("+");
         test.add("(");
         test.add("5");
         test.add("+");
         test.add("6");
         test.add("*");
         test.add("12");
         test.add(")");         
         if(test.toString().equals("[1, +, (, 5, +, 6, *, 12, )]"))
         {
            pass = true;
         }
         else
         {
            pass = false;
            System.out.println("test 4: failed");
         }
      }
     if(pass == true)
     {
         test2 = Evaluator.infixToPostfix(test);        
         if(test2.toString().equals("[1, 5, 6, 12, *, +, +]"))
         {
            pass = true;
         }
         else
         {
            pass = false;
            System.out.println("test 5: failed");
         }
      }
      if(pass == true)
      {
         BigInteger result = new BigInteger("78");
         test3 = new BigInteger(Evaluator.evalPostfix(test2).toString());
         if(test3.equals(new BigInteger("78")))
         {
            pass = true;
         }
         else
         {
            pass = false;
            System.out.println("test 6: failed");
         }
      }
      if(pass == true)
      {
         test.clear();
         test2.clear();
         try
         {
            test.add(" ");
            test.add("2");
            test.add("+");
            test.add("5");
            Evaluator.infixToPostfix(test);
         }
         catch(IllegalArgumentException e)
         {
            pass = true;
         }
         catch(Exception e)
         {
            pass = false;
            System.out.print("test 7: failed");
            System.out.println("Wrong exception");
            return;
         }  
         test.clear();
         test2.clear();
         try
         {
            test.add("(");
            test.add("2");
            test.add("+");
            test.add("5");
            test.add(")");
            test.add(")");
            Evaluator.infixToPostfix(test);
         }
         catch(IllegalArgumentException e)
         {
            pass = true;
         }
         catch(Exception e)
         {
            pass = false;
            System.out.println("test 8: failed");
            System.out.println("Wrong exception");
            return;
         }
         test.clear();
         test2.clear();
         try
         {
            test.add("2");
            test.add("+");
            test.add("+");
            test.add("5");
            test.add("-");
            test.add("6");
            Evaluator.infixToPostfix(test);
         }
         catch(IllegalArgumentException e)
         {
            pass = true;
         }
         catch(Exception e)
         {
            pass = false;
            System.out.println("test 9: failed");
            System.out.println("Wrong exception");
            return;
         }    
      }   
      System.out.println("My code worked? "+ pass);
   }
}