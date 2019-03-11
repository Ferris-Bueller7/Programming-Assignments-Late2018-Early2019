/**
  * This codes main purpose is to convert infix expressions 
  *   to postfix expressions and solve them
  * 
  *
  * @Author Ethan Covert
  * @Version 6 December 2018  
  */
import java.util.Deque;
import java.util.ArrayDeque;
import java.math.BigInteger;
import java.util.Stack;
import java.util.Queue;
import java.lang.IllegalArgumentException;
public class Evaluator
{  
   static Stack<String> operatorHolder;
/**
  * This method checks to see if the expression given by the user 
  *   can be converted to an infix expression
  * @param in inputs a deque that is copied 
  * @return result returns the postfix expression    
  */ 
   public static Deque<String> infixToPostfix(Deque<String> in)
   {
      Deque<String> copy = new ArrayDeque<String>(in);
      Deque<String> cantFoolMe = new ArrayDeque<String>(in);
      operatorHolder = new Stack<>();
      Deque<String> theFinal = new ArrayDeque<String>();
      int counter = 0;
      try{
      while(cantFoolMe.isEmpty() == false)
      {
         String temp2;
         String temp1 = cantFoolMe.pop();
         if(validOperator(temp1) == true) 
         {
            temp2 = cantFoolMe.pop();
            if(temp2.equals("(") || temp2.equals(")"))
            {
               counter++;
            }
            else if(validOperator(temp2) == true)
            {
               throw new IllegalArgumentException();
            } 
         }   
         else if(temp1.equals("(") || temp1.equals(")"))
         {
            counter++;   
         }     
      }
      if(counter % 2 != 0)
      {
         throw new IllegalArgumentException();
      }
      while(copy.isEmpty() == false)
      {
         
         if(isInt(copy.peek()) == true) 
         {
           String temp = copy.pop();
           theFinal.add(temp);        
         }
         else if(copy.peek().equals("(")) 
         {
            String temp = copy.peek();
            operatorHolder.push(temp);
            copy.pop();
         }
         else if(copy.peek().equals(")")) 
         {
            copy.remove();
            while(operatorHolder.peek().equals("(") != true) 
            {
               theFinal.add(operatorHolder.pop());
            }
            operatorHolder.pop();     
         }
         else if(validOperator(copy.peek()) == true && 
            operatorHolder.empty() == true || 
               operatorHolder.peek().equals("("))     
         { 
            String temp = copy.pop();
            operatorHolder.push(temp);
            
         }
         else if(validOperator(copy.peek()) == true && 
            higherPrecedence(copy.peek()) == true || 
               equalPrecedence(copy.peek()) == true && 
                  leftToRight(copy.peek()) != true)
         {
            String temp = copy.pop();
            operatorHolder.push(temp);         
         }
         else if(validOperator(copy.peek()) == true && 
            higherPrecedence(copy.peek()) != true || 
               equalPrecedence(copy.peek()) == true && 
                  leftToRight(copy.peek()) == true)         
         {
            while(operatorHolder.empty() != true)
            {
               if(higherPrecedence(copy.peek())
                == false || equalPrecedence(copy.peek()) == true && 
                  leftToRight(copy.peek()) == true)
               {
                  theFinal.add(operatorHolder.pop());
               }
            }   
            String temp = copy.pop();
            operatorHolder.push(temp);
            
         }
         else
         {
            throw new IllegalArgumentException();
         }
      }
      if(copy.peek() == null);
      {
         while(operatorHolder.isEmpty() != true)
         {
            theFinal.add(operatorHolder.pop());
         }
      }
      } catch(Exception e) {
         throw new IllegalArgumentException();
      }
      
      return theFinal;
   }
/**
  * This method calculates the postfix expression     
  * @param in inputs a postfix expression 
  * @return result returns a stack with a single element for an answer    
  */    
   public static BigInteger evalPostfix(Deque<String> in)
   {
      Deque<String> calculations = new ArrayDeque<>(in);
      Stack<BigInteger> result = new Stack<>();
      while(calculations.isEmpty() == false)
      {
         if(isInt(calculations.peek()) == true)
         {
            result.push(new BigInteger(calculations.remove()));
         }
         else if(validOperator(calculations.peek()) == true)
         {
           BigInteger first = result.pop();
           BigInteger second = result.pop();
           switch(calculations.peek())
           {
            case "*":
               result.push(second.multiply(first));
               calculations.pop();   
               break;
            case "/": 
               result.push(second.divide(first));
               calculations.pop();
               break;
            case "+":     
               result.push(second.add(first));
               calculations.pop();
               break;
            case "-": 
               result.push(second.subtract(first));
               calculations.pop();
               break;
            case "%": 
               result.push(first.remainder(second));
               calculations.pop();
               break;
            default: throw new IllegalArgumentException();
           }
         }
      
      }
      return result.pop();
   }
/**
  * This method checks to see if the incoming value is a valid 
  *   operator
  * @param test is the incoming value being tested 
  * @return boolean returns true or false    
  */    
   public static boolean validOperator(String test)
   {
      switch(test)
      {
         case "+": 
            return true;
         case "-": 
            return true;
         case "%": 
            return true;
         case "/": 
            return true;
         case "*": 
            return true;
         default : 
            return false;
      }
   }
/**
  * This method checks to see if the incoming value given by the user 
  *   is a BigInteger
  * @param test is the incoming value being tested 
  * @return boolean if value is a Big Int    
  */   
   public static boolean isInt(String test)
   {
      boolean tORF = true;
      try
      {
         BigInteger trial = new BigInteger(test);    
      }
      catch(IllegalArgumentException e)
      {
         tORF =false;
      }
      return tORF;
   }
/**
  * This method checks to see if the incoming operator  
  *   has higher precedence than the value on the operator stack
  * @param test is the value being compared to the top of the stack 
  * @return boolean returns true if incoming value has higher precedence    
  */    
   public static boolean higherPrecedence(String test)
   {
      
      if(test.equals("*") || test.equals("/") || test.equals("%"))
      {
         if(operatorHolder.peek().equals("*") || 
            operatorHolder.peek().equals("/") || 
            operatorHolder.peek().equals("%"))
         {
            return false;
         }
         else
         {
            return true;
         }
      }   
      else   
      {
         return false;
      }
   }
/**
  * This method checks to see if the incoming operator has equal 
  *   precendence  to the top of the stack 
  * @param test operator being compared to top of stack 
  * @return true if operators have equal precendce    
  */   
   public static boolean equalPrecedence(String test)
   {
      if(test.equals("*") || test.equals("/") || test.equals("%"))
      {
         if(operatorHolder.peek().equals("*") || 
            operatorHolder.peek().equals("/") ||
            operatorHolder.peek().equals("%"))
         {
            return true;
         }
         else
         {
            return false;
         }
      }   
      else if(test.equals("+") || test.equals("-"))
      {
         if(operatorHolder.peek().equals("+") || 
            operatorHolder.peek().equals("-"))   
         {
            return true;
         }
         else
         {
            return false;
         }
      }
      else
      {
         throw new IllegalArgumentException();
      }
   }
/**
  * This method checks if operator is left to right associative
  * @param test operator if its left to right associative 
  * @return true if operator is left to right associative    
  */      
   public static boolean leftToRight(String test)
   {
      if(equalPrecedence(test) == true)
      {
         if(operatorHolder.peek().equals("*") || 
            operatorHolder.peek().equals("/"))
         {
            return true;
         }
         else if(operatorHolder.peek().equals("-") || 
            operatorHolder.peek().equals("+"))
         {
            return true;
         }
         else if(operatorHolder.peek().equals("%"))
         {
            return true;
         }
      }
      return false;
   }
}
