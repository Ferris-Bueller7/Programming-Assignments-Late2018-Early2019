/**
  * This creates a deck of cards that can have one value or two
  * values for different types of games. 
  *  
  * @author Ethan Covert 
  * @version 12th October 2018
  */ 
import java.io.FileNotFoundException;
import java.util.Random;
public class Deck
{
   private Card[] newDeck;
   private boolean tORf;
   private Card nextCard;
   private int counter = 0;
   

   /**  
     * Creates a deck with 2 values 
     * @param x  the size of the first parameters being passed in
     * @param y: the size of the second parameters being passed in
     */
   public Deck(String[] x, String[] y)
   { 
      newDeck = new Card[x.length * y.length];
      int k = 0;
      for(int i = 0; i < x.length; i++)
      {
         for(int j = 0; j < y.length; j++)
         {
            Card arr = new Card(x[i], y[j]);
            newDeck[k] = arr;
            k++;
         
         }
      }   
      
   }
   
   
   /**
     * Creates a deck of cards with only one value.
     * @param z: is the size of the deck being used.
     */
   public Deck(String[] z)
   {
      newDeck = new Card[z.length];
      for(int i = 0; i < z.length; i++)
      {
         Card arr = new Card(z[i]);
         newDeck[i] = arr;
      }
   }
   
   
   /**
     * Combines the first Deck and the second deck into a single deck for use.
     *
     */
   public Deck()
   {
      this(new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"}, 
      new String[] {"H","D","S","C"}); 
   
   }
   
   
   /**
     * This method checks if the deck has a next card and if it does it gives
     * the user the next card.
     * @return nextCard: the next card in the deck.
     */
   public Card next()
   {

      hasNext();
      if(tORf)
      {
         nextCard = newDeck[counter];
         counter++;
      }
      else
      {
         throw new IllegalStateException();
      }
      
      return nextCard;      
   }
   
   
   /**
     * This method checks if the number of cards used(counter) 
     * is less than the total amount of cards
     * @return tORf: true if there is a next card and false if there isn't
     */
   public boolean hasNext()
   {
      if(counter < newDeck.length)
      {
         tORf = true;    
      } 
      else
      {
         tORf = false;
      }
      return tORf;
   }
   
   
   /**
     * This method returns the amount of remaining in the deck
     * that hasn't been used.
     * @return remainder: returns the amount of cards left.
     */
   public int remaining()
   {
      int remainder = 0;
      remainder = newDeck.length - counter;
      return remainder;
   } 
   
   
   /**
     * This finds the amount of cards
     * in the current deck.
     * @return deckSize: the number of cards in deck.
     */
   public int size()
   {
      int deckSize = newDeck.length;
      return deckSize;
   }
   /**
     * This resets the Cards used to 0
     * and randomizes the order of the  
     * cards.
     */
   public void shuffle()
   {
      Random rand = new Random();
      int[] arr;
      counter = 0;
      for(int i = 0; i < newDeck.length; i++)
      {
         int randomPosition = rand.nextInt(newDeck.length);
         Card temp = newDeck[i];
         newDeck[i] = newDeck[randomPosition];
         newDeck[randomPosition] = temp;
      }
      
   }
}   