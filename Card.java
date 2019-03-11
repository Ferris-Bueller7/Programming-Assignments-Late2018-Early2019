/**
  * This constructs a card based on the values used in the game   
  * running the card.
  *
  *    
  *  
  *  
  * @author Ethan Covert 
  * @version 10th October 2018
  *  
  */  
public class Card
{
   private String suit;
   private String cardValue;
   private String Str;

   
   /**
     * initializes the Card with one value 
     * for games that only require one value.
     * @param cardValue: is the single value passed in by user
     */
   public Card(String cardValue)
   {
      this.cardValue = cardValue;
 
   }
   
   
   /**
     * initializes the Card with two values 
     * for games requiring two values.
     * @param suit: value 1 passed in by user ex: suit
     * @param cardValue: value 2 passed in by user ex: value
     */
   public Card(String suit, String cardValue)
   {
      this.cardValue = cardValue;
      this.suit = suit;
   
   }
   
   /**
     * Determines which  
     * @return Str: Card in correct format
     */
   public String toString()
   {
      if(suit == null)
      {
         Str = "[" + cardValue + "]";
      }
      else
      {
         Str = "[" + suit + "," + cardValue + "]";
         
      }
      return Str;
   }

}