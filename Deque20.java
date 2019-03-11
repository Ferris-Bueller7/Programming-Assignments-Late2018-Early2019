/**
  * This creates a generic deque class  
  * that can be applied to different types 
  * without using loops
  *
  * @author Ethan Covert
  * @version 6th November 2018
  */
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
public class Deque20<E>
{
   private ListNode<E> front;
   private ListNode<E> back;
   private int counter;
   
/** 
  * initializes front, back, and the counter to be empty
  */
   public Deque20()
   {
      front = null;
      back = null;
      counter = 0;
   }
   
/** 
  * places the given element at the front of the deque
  * making sure if its the only element in the deque that
  * it sets the front and the back
  * @param x this is the value chosen by the user
  */
   public void push(E x)
   {
      if(front == null)
      {
         ListNode<E> first = new ListNode<E>(); 
         first.data = x;
         front = first;
         back = first;
      }
      else
      {
         ListNode<E> temp = front;
         front = new ListNode<E>(); 
         front.data = x;
         front.next = temp;
         
      }
      counter ++;
   }
   
/** 
  * removes the first element of the list and returns it to 
  * the user
  * @return storage.data this is the element at front of list
  */
   public E pop() 
   {
      if(front == null)
      {
         throw new NoSuchElementException();
      }
      else
      {
         ListNode<E> newFront = new ListNode<E>();
         ListNode<E> storage = new ListNode<E>();
         storage.data = front.data;
         newFront = front.next;
         front = newFront;
         counter--;
         return storage.data;
      }
   }
     
/** 
  * this adds an element at the end of the deque
  * @param x this is the element the user wants to add to the end of the list
  */
   public void add(E x)
   {
      if(front == null)
      {
         ListNode<E> nEw = new ListNode<E>();
         nEw.data = x;
         front = nEw;
         back = nEw;
      }
      else
      {
         ListNode<E> temp = new ListNode<E>();
         temp.data = x;
         back.next = temp;
         back = back.next;
      }
      counter++;      
   } 
    
/** 
  * removes the first element of the deque and returns it to the user
  * @return pop()  pop does same thing as remove
  */
   public E remove()
   {
      return pop();
   }  
   
/** 
  * views the first element in the deque without removing it
  * @return temp.data this is the first element of the deque
  */
   public E peek() 
   {
      if(front == null)
      {
         throw new NoSuchElementException("EEE");      
      }
      else
      {
         ListNode<E> temp = new ListNode<E>();
         temp = front;
         return temp.data;
      } 
   } 
      
/** 
  * checks if the deque is empty
  * @return True/False if the deque is empty/has elements
  */
   public boolean isEmpty()
   {
      if(counter == 0)
      {
         return true;
      }
      else
         return false;
   } 
    
/** 
  * returns the size of the deque
  * @return counter this returns the current size of the deque
  */
   public int size()
   {
      return counter;      
   }
   
/** 
  * returns the elements in a clean organized form with brackets
  * and commas
  * @return results this is the elements formated into a readable manner
  */
   public String toString()
   {
      if(front == null)
      {
         return "[]";
      
      }
      else
      {
         String result = "[" + front.data;
         ListNode<E> current = front.next;
         while(current != null)
         {
            result = result + ", " + current.data;
            current = current.next;
         }
         result = result + "]";
         return result;
      }
   }
   
/**
  * This method constructs the rocket at the end of the testing code
  * @return rocket builds and returns contstructed rocket 
  */ 
   public String theRocket()
   {
      String rocket = top();
      rocket = rocket + topBox();
      rocket = rocket + name();
      rocket = rocket + topBox();
      rocket = rocket + top();
      return rocket;
   }
   
/**
  * This method constructs the top and bottom of the rocket
  * @return "" returns the pointed section
  */
   public String top()
   {
      System.out.println("       /\\    ");
      System.out.println("      /  \\   ");
      System.out.println("     /    \\  ");
      return "";
   }
   
/**
  * This method constructs the middle section of the rocket
  * @return "" returns the middle section
  */      
   public String topBox()
   {
      System.out.println("    +------+");
      System.out.println("    |      |");
      System.out.println("    |      |");
      System.out.println("    +------+");
      return "";
   }
   
/**
  * This method constructs the name section of the rocket
  * @return "" returns the name of the rocket
  */   
   public String name()
   {
      System.out.println("    |Extra |");
      System.out.println("    |Credit|");
      return "";
   }      
}