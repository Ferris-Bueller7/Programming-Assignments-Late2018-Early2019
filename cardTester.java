import java.util.Arrays;

public class cardTester
{
   public static void main(String[] args)
   {   
         
     
     
        boolean pass = true;
        String[] list1 = {"Hello", "World"};
        String[] list2 = {"Apple", "Pumpkin"};
        
        Deck cards = new Deck(list1);
        String res = "";
        while (cards.hasNext()) {
            res = res+cards.next();
        }
        pass = pass && res.equals("[Hello][World]");
        pass = pass && (cards.remaining()==0);
        pass = pass && (cards.size()==2);
 
        try { cards.next(); pass = false; }
        catch(IllegalStateException e) { }
        catch(Exception e) { pass = false; }
   
        cards = new Deck(list1,list2);
        res = "";
        while (cards.hasNext()) {
            res = res+cards.next();
        }
        pass = pass && res.equals("[Hello,Apple][Hello,Pumpkin][World,Apple][World,Pumpkin]");
        cards.shuffle();
        res = "";
        while (cards.hasNext()) {
            res = res+cards.next();
        }
        System.out.println(res);

        cards = new Deck();
        res = "";
        while (cards.hasNext()) {
            res = res+cards.next();
        }
        pass = pass && ((res.indexOf("[A,\u2666]")==5)||(res.indexOf("[A,D]")==5));
        pass = pass && (cards.remaining()==0);
        pass = pass && (cards.size()==52);

        System.out.println(pass);
    }
    
} 
     //  String[] array1 = {"A","B","C","D","E"};
//       String[] array2 = {"\u2665","\u2666","\u2660"};
//       Deck deck = new Deck(array1, array2);
//       //Card curCard = deck.next();
//       //String cardsString = curCard.toString();
//      //  while (deck.hasNext()) {
// //          curCard = deck.next();
// //          cardsString = cardsString + " " + curCard.toString();
// //       }
// //       System.out.println(cardsString.equals("[A,1] [A,2] [B,1] [B,2] [C,1] [C,2]"));
//      // System.out.println(Arrays.toString(deck));
//       Deck cards = new Deck(array1, array2);
//       //System.out.println(cards.remaining());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       //System.out.println(cards.hasNext());
//       //System.out.println(cards.remaining());
//       //System.out.println(cards.next());      
//       //System.out.println(cards.hasNext());
//      // System.out.println(cards.remaining());
//       //System.out.println(cards.size() + "\n");
//       
//       //System.out.println(cards);
//       cards.shuffle();
//       //System.out.println(cards);
//       System.out.println();
//       //System.out.println(cards.remaining());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       System.out.println(cards.next());
//       //System.out.println(cards.hasNext());
//       //System.out.println(cards.remaining());
//       //System.out.println(cards.next());      
//       //System.out.println(cards.hasNext());
//       //System.out.println(cards.remaining());
//       //System.out.println(cards.size() + "\n");
//       
//       Deck card2 = new Deck(new String[]{"X","Y","Z"});
//       System.out.println(card2);
//       System.out.println(card2.next());
//       System.out.println(card2.next());
//       System.out.println(card2.hasNext());
//       System.out.println(card2.next());
//       System.out.println(card2.hasNext());
//       
      
    


      
 
 
 
   //  //String[] array1 = {"A"}; 
//     String[] array1 = {"A","B","C"};
//     String[] array2 = {"1","2"};
//     Deck cards = new Deck(array1, array2); 
//     Card curCard = cards.next();
//    
// //CODE I ADDED SECTION REMOVE BEFORE YOU SUBMIT vvvvvvvv   
//              
// //    //  //String[] array1 = {"A"};
// // //     //String[] array2 = {"1","2"};
// // //     boolean check = cards.hasNext();
// // //     System.out.println(check);    
// //      Card cURCard = cards.next();
// //      Card CURCard = cards.next();
// //      //Card curCard1 = cards;
// // //     //System.out.println(curCard1);
// //      System.out.println(curCard);
// //      System.out.println(cURCard);
// //      System.out.println(CURCard);
// //      cards.shuffle();
// //      Card curCard1 = cards.next();
// //      System.out.println(curCard1);
// // //     //int total = cards.remaining();
// //         //System.out.
// 
// 
// //CODE I ADDED SECTION REMOVE BEFORE YOU SUBMIT ^^^^^^^^
// 
// 
//    String cardsString = curCard.toString();
//    while (cards.hasNext())
//    {
//       curCard = cards.next();
//       cardsString = cardsString + " " + curCard.toString();
//    }
//    System.out.println(cardsString.equals("[A,1] [A,2] [B,1] [B,2] [C,1] [C,2]"));
//    
//    
//    
//    }
// 
// 
// 




