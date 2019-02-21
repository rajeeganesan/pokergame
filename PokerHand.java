import java.util.Scanner;

/* author: rajee ganesan
   login: cs11wki
   date: jan 30 2019
   file: pokerhand.java
   sources of help: various tutors, starter cod
   description: creates methods for inputting a hand, determining the
   poker hand and best possible option, and comparing hands.
   note: the words rank & card are used interchangeable in the project.
*/


/**
 * Class to store a hand of cards
 */
public class PokerHand implements IPokerHand{
// variable declarations
	private final int SIZE = 5;
	private String hand;
	int[] numberVal = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	String[] cardVal = {"A", "1", "2", "3", "4", "5", "6", "7",
                            "8", "9", "10","J", "Q", "K"};
        Card [] cards = new Card[SIZE]; 
    

    /**
     *Constructor for the class
     *@param hand, String entered by the user
     *Use the constructor to initialze the card array
    **/ 
    PokerHand(String hand){
       this.hand = hand;  
    }



   /**
    * method to format inputted hands
    * @param null
    * formats hand in rank+suit format
   **/   
   public String formattedHand(){
      String[] inputHand = hand.split(" "); // splits hand into array
      if (inputHand.length != 10){ // checks for garbage input
	return ""; // if so, returns empty string
      }
      int[] cardNumber = new int[SIZE]; // creates array for ranks
      String[] suit = new String[SIZE]; // creates array for suits
	for (int i = 0; i < inputHand.length; i+= 2){
	   cardNumber[i/2] = Integer.parseInt(inputHand[i]); // gets rank
	} // inputs suits into suit array
	for (int i = 1; i < inputHand.length; i+=2){
	   suit[(i/2)] = inputHand[i]; // gets suit
	} // inputs cards into card array
	for (int i = 0; i < SIZE; i++){ 
	   cards[i] = new Card(cardNumber[i],suit[i]); // puts rank & suit together
	} // inputs values into formatted card array
      String playerHand = ""; // creates empty string
       	for (Card given: cards ){
	   playerHand = playerHand + given.cardInfo() + " "; 
	} //creates string for the formatted output
      String newPlayerHand = playerHand.substring(0, playerHand.length()-1);
   return  newPlayerHand; // returns formatted string after deleting space 
   }
 

 
   /**
    * method to determine for straight flush
    * @param null
    * returns true/false based on output for straightFlush
   **/ 
   public boolean straightFlush(){
      boolean straightFlush = true; // initializes variable
      String[] inputHand = hand.split(" "); //splits stiring	
      int[] cards = new int[5]; // cards array
      for (int i = 0; i < inputHand.length; i += 2){
	cards[i/2] = Integer.parseInt(inputHand[i]);
      } //inputs rank into card array
      String[] suit = new String[5]; // suit array
      for (int i = 1; i < inputHand.length; i += 2){
	suit[i/2] = inputHand[i];
      } // inputs suits into suit array
      String flushSuit = suit[2]; // sets suit for flush
      if (cards[0] == 1 && cards[4] == 13){ // checks for aces
	if (suit[0].equals(flushSuit) && suit[4].equals(flushSuit)){
	for (int j = 1; j < 4; j++){
	   if(cards[j] + 1 == cards[j+1] && suit[j].equals(suit[j+1])){
	      straightFlush = true; // ensures suits are equal & incrementing
	   }
	   else{
	      straightFlush = false;
	      break;
	   }
	}
	}
	else{
	   straightFlush = false;
        }
      }
      else{
         for (int i = 1; i <5; i++){ // checks for incrementing
	    if (cards[i-1] == cards[i] -1 && suit[i].equals(suit[i-1])){
               straightFlush = true; // ensures suits are equal & incrementing
	    }
	    else if (cards[4]-1 == cards[0] && suit[i].equals(suit[i-1])){
	       straightFlush = true; // checks incrementing
	    }
	    else{
	       straightFlush = false;
	       break;
	    }
	 }
      }
   return straightFlush; // returns true/false based on output
   }



  /** 
   * helper method for fourOfAKind determination
   * @param null
   * returns t/f value based on output for fourofakind  
  **/
   public boolean fourOfAKind(){
      boolean fourOfAKind = true; // initializes variable
      String[] inputHand = hand.split(" "); // splits hand
      int[] cards = new int[5]; // creates rank array
      for (int i = 0; i < inputHand.length; i +=2){ 
         cards[i/2] = Integer.parseInt(inputHand[i]);
      }  // inputs ranks into card array
      String[] suit = new String[5]; 
      for (int i = 1; i < inputHand.length; i += 2){ // creates suit array
         suit[i/2] = inputHand[i];
      } // inputs suits into suit array
      int fourOfAKindRank = cards[2]; // rank of middle card
      for(int i = 0; i < 4; i++){ // fourofakind loop
         if (cards[0] == fourOfAKindRank){ // checks if four starts @ 0
	    for(int g= 1; g < 4; g++){ 
	       if(suit[g+1] != suit[g] && cards[g]== fourOfAKindRank){
	          fourOfAKind = true; // checks if ranks are equal
	       }
	       else{
		  fourOfAKind = false;
		  break;
	       }
	    }
	 }
	 else if (cards[4] == fourOfAKindRank){ //checks if four starts @ 1
	    for (int j = 1; j < 4; j++){
	       if(suit[j+1] != suit[j] && cards[j] == fourOfAKindRank){
	          fourOfAKind = true; // checks if ranks are equal
	       }
	       else{
	          fourOfAKind = false;
		  break;
	       }
	    }
	  }
	  else{
	     fourOfAKind = false;
	     break;   
	  }
      }
   return fourOfAKind; // returns true/false based on output
   }





  /** helper method for full house determination
   * @param null
   * returns t/f value based on output for full house
  **/  
   public boolean fullHouse(){
      boolean fullHouse = false; //initializes variable
      String[] inputHand = hand.split(" "); // splits
      int[] cards = new int[5]; 
      for (int i = 0; i < inputHand.length; i +=2){ // cards array
         cards[i/2] = Integer.parseInt(inputHand[i]);
      } // inputs rank into cards array
      String[] suit = new String[5]; // suit array
      for (int i = 1; i < inputHand.length; i += 2){
	 suit[i/2] = inputHand[i];
      } // inputs suit into suit array
      int fullHouseRank = cards[2]; // rank of three series
      if (cards[0] == fullHouseRank){ // checks if three is first
         for (int g = 0; g < 2; g++){
            if (suit[g+1]!= suit[g] && cards[g] == fullHouseRank){ 
	       for (int j = 3; j < 4; j++){ // checks if ranks are equal
		  if (suit[j+1] != suit[j] && cards[j] == cards[j+1]){
		     fullHouse = true; // checks for two
		  } 
		  else{
		     fullHouse = false;
		     break;
		  } 
	       }
	    }	
	    else{
	       fullHouse = false;
	       break;
	    }
	 }
      }
      else if (cards[4] == fullHouseRank){ // checks if two is first
         for(int k = 2; k < 4; k++){
	    if((!suit[k+1].equals(suit[k])) && cards[k] == fullHouseRank){
	       for (int r = 0; r < 1; r++){ // checks if ranks are equal
	          if((!suit[r+1].equals(suit[r])) && cards[r] == cards[r+1]){
		     fullHouse = true; // checks for two
		  }
		  else{
		     fullHouse = false;
		     break;
		  }
	       }
	    }
      	    else{
               fullHouse = false; // if otherwise
	       break;
      	    }
	}
      }
      else{
         fullHouse = false; 		
      }
   return fullHouse; // returns true or false based on output
   }



   /** helper method for flush
    * @param null
    * returns t/f value based on output for flush 	
   **/
   public boolean flush(){
      boolean flush = false; // initializes flush variable
      String[] inputHand = hand.split(" "); // splits string
      int[] cards = new int[5];
      for (int i = 0; i < inputHand.length;i+= 2){ // cards array
         cards[i/2] = Integer.parseInt(inputHand[i]);
      } // inputs ranks into array
      String[] suit = new String[5];
      for (int i = 1; i < inputHand.length; i+= 2){ // suit array
         suit[i/2] = inputHand[i];
      } // inputs suits into array
      String flushSuit = suit[2]; // finds suit of all cards
      for(int j = 0; j < 4; j++){
         if(suit[j].equals(flushSuit)){ // checks for same suit
	    flush = true;
	 }
	 else{ // returns otherwise
	    flush = false;
	    break;
	 }
      }
   return flush; // returns true or false based on output
   } 		   
    


   /** helper method for straight determination
    * @param null
    * returns t/f value based on output for straight
    **/   
   public boolean straight(){
      boolean straight = false; //initializes return value
      String[] inputHand = hand.split(" "); // splits hand
      int[] cards = new int[5];
      for (int i = 0; i < inputHand.length; i+= 2){ // cards array
         cards[i/2] = Integer.parseInt(inputHand[i]);
      } // inputs ranks into array
      String[] suit = new String[5]; // suit array
      for (int i =1; i < inputHand.length; i+=2){
         suit[i/2] = inputHand[i];
      } // inputs suits into array
      if(cards[0] == 1 && cards[4] == 13){ // checks for aces
         for(int g = 1; g < 4; g++){ 
	    if(cards[g]+1 == cards[g+1]){ // checks increment
	       straight = true;
	    }
	    else{
	       straight = false;
	       break;
	    }
	 }
      }
      else{ // not aces
         for(int g = 0;  g < 4; g++){
	    if (cards[g]+1 == cards[g+1]){ // checks increment
	       straight = true;
	    }
	    else{
	       straight = false;
	       break;
	    }
	 }
      }
   return straight; // returns true or false based on output
   }




   /** 
    * helper method for threeofakind determination
    * @param null
    * returns t/f value based on output for three of a kind
    **/ 
   public boolean threeOfAKind(){
      boolean threeOfAKind = true; // initializes variable
      String[] inputHand = hand.split(" "); // splits string
      int[] cards = new int[5];
      for(int i = 0; i < inputHand.length; i += 2){ // cards array
         cards[i/2] = Integer.parseInt(inputHand[i]);
      } // inputs ranks into card array
      String[] suit = new String[5]; // suit array
      for(int i = 1; i < inputHand.length; i += 2){
         suit[i/2] = inputHand[i];
      } // inputs suits into suit array
      int three = cards[2]; // finds rank for three of a kind
      for(int j = 0; j < 4; j++){
         if (cards[0] == three){ // checks threeofakind start @ zero
	    for(int g = 0; g < 2; g++){
	       if (cards[g] == cards[g+1]){ // checks for incrementing
	          threeOfAKind = true;
	       }
	       else{
	          threeOfAKind = false;
		  break;
	       }
	    }
	 }
	 else if (cards[1] == three){ // checks if threeofakind start @ 1
	    for (int k = 1; k < 3; k++){
	       if (cards[k] == cards[k+1]){ // checks for incrementing
	          threeOfAKind = true;
	       }
	       else{
	          threeOfAKind = false;
		  break;
	       }
	    }
	 }
         else if (cards[4] == three){ // checks if threeofakind start @ 2
	    for(int r = 2; r < 4; r++){
	       if (cards[r] == cards[r+1]){ // checks for incrementing
	          threeOfAKind = true;
	       }
	       else{
	       threeOfAKind = false;
	       break;
	       }
	    }
         }
         else{ // if otherwise
	    threeOfAKind = false;
	 }
      }
   return threeOfAKind; // returns true or false based on output
   }



   /** 
    * helper method for two pair determination
    * @param null
    * returns t/f value based on output for two pair
    **/  
   public boolean twoPair(){
      boolean twoPair = false; // initializes variable
      String[] inputHand = hand.split(" "); // splits string
      int[] cards = new int[5]; // cards array
      for(int i = 0; i < inputHand.length; i +=2){
         cards[i/2] = Integer.parseInt(inputHand[i]);
      } // inputs ranks into cards array
      String[] suit = new String[5]; // suit array
      for(int i = 1; i < inputHand.length; i += 2){
         suit[i/2] = inputHand[i];
      } // inputs suits into suit array
      if (cards[0] == cards[1]){ // checks if first two are a pair
         for(int j = 2; j < 3; j++){ // checks for second pair
            if( cards[j] == cards[j+1]){
	       twoPair = true;
	    }
	 }
	 for (int g = 3; g <4; g++){ // checks for second pair if not found
	    if(cards[g] == cards[g+1]){
	       twoPair = true;
	    }
         }
      }
      else if (cards[3] == cards[4]){ // checks if last two are a pair
         for(int k = 1; k < 2; k++){ // checks if first two were a pair
	    if(cards[k] == cards[k+1]){
	       twoPair = true;
	    }
	    else{
	       twoPair = false; // otherwise
	       break;
	    }
         }
      }
      else{
         twoPair = false; // no pairs
      }
   return twoPair; // reutrns true or false based on output
   }




   /**
    * helper method for one pair determination
    * @param null
    * returns t/f value based on output of one pair
    **/   
   public boolean onePair(){
      boolean onePair = true; // initializes variable
      String[] inputHand = hand.split(" "); // splits hand
      int[] cards = new int[5]; // cards array
      for(int i = 0; i< inputHand.length; i +=2){
         cards[i/2] = Integer.parseInt(inputHand[i]);
      } // inputs ranks into cards array
      String[] suit = new String[5]; // suit array
         for(int i = 1; i < inputHand.length; i +=2){
	    suit[i/2] = inputHand[i];
      } // inputs suits into suit array
      if (cards[0] == cards[1]){ // checks for pair in first two
         for(int k = 2; k < 4; k++){ // checks for other pairs
	    if (cards[k] != cards[k+1]){
	       onePair = true;
            }
            else{
	       onePair = false;
	       break;
            }
	 }
      }
      else if (cards[1] == cards[2]){ // checks for pair in 1 and 2
         for (int j = 3; j < 4; j++){
            if(cards[j] != cards[j+1]){ // checks for other pairs
	       onePair = true;
	    }
	    else{
	       onePair = false;
	       break;
            }
         }
      }
      else if (cards[2] == cards[3]){ // checks for pair in 2 and 3
         onePair = true;
      }
      else if (cards[3] == cards[4]){ // checks for pair in 3 and 4
         onePair = true;
      }
      else{ // otherwise
         onePair = false;
      }
   return onePair; // returns true or false based on output
   }
			


   /**
    * besthand method
    * @param null
    * evaluates and returns best hand possible  
    **/ 
   public String bestHand(){
      String retVal = ""; //empty string
      PokerHand givenHand = new PokerHand(hand); // creates new hand
      String[] givenHandInput = hand.split(" ");
      if(givenHandInput.length != 10){ // checks for garbage input
	return ""; // if so, returns empty string
      }
      if (givenHand.straightFlush()  == true){ // checks for hands in order
         retVal += "STRAIGHT FLUSH";
      }
      else if (givenHand.fourOfAKind() == true){
	 retVal += "FOUR OF A KIND";
      }
      else if (givenHand.fullHouse() == true){
	 retVal += "FULL HOUSE";
      }
      else if (givenHand.flush() == true){
         retVal += "FLUSH";
      }
      else if (givenHand.straight() == true){
	 retVal += "STRAIGHT";
      }
      else if (givenHand.threeOfAKind() == true){
	 retVal += "THREE OF A KIND";
      }
      else if(givenHand.twoPair() == true){
	 retVal += "TWO PAIR";
      }
      else if(givenHand.onePair() == true){
	 retVal += "ONE PAIR";
      }
      else{
	 retVal += "HIGH CARD";
      }
   return (retVal); // returns highest value hand
   }	


   /**
    * comparehands method for class
    * @param p, pokerhand entered by user
    * compares hands of two players and returns 0 for tie, 1 for player
    * 1 winning, and 2 for player 2 winning.
    **/  	
   public int compareHands(PokerHand p){
      String[] listOfHands = {"STRAIGHT FLUSH", "FOUR OF A KIND", "FULL HOUSE",
                               "FLUSH", "STRAIGHT", "THREE OF A KIND",
                               "TWO PAIR", "ONE PAIR", "HIGH CARD"};
      int retVal = 0; // initializes return value
      int[] rankOfHand = {9,8,7,6,5,4,3,2,1,0}; // point value system
      String bestHand2 = p.bestHand(); // gets string of first  pokerHand
      PokerHand dos = new PokerHand(hand); // gets second pokerhand
      String bestHand1 = dos.bestHand(); // gets string of second pokerhand
      int index = 0; 
      int index2 = 0;
      for(int i = 0; i < listOfHands.length; i++){
         if (bestHand1.equals("")){ // checks for garbage input
		index = 9; // if so, returns empty string
      		break;
         }
         if (bestHand1.equals(listOfHands[i])){
               index = i; // finds index
	       break;
	    }
	    else index = 0;
       }
       for(int g = 0; g < listOfHands.length; g++){
	  if (bestHand2.equals("")){ // checks for garbage input
		index2 = 9; // if so, returns empty string
		break;
  	  }  
	  if (bestHand2.equals(listOfHands[g])){
		index2 = g; // finds index
		break;
	    }
            else index = 0;
       }		
   
      int rankIndex = rankOfHand[index]; // finds point
      int rankIndex2 = rankOfHand[index2] ;
      if (rankIndex > rankIndex2){ // checks which is higher
	retVal = 1; // player one wins
      }
      else if (rankIndex < rankIndex2){
	retVal = 2; // player two wins
     }
      else if (rankIndex == rankIndex2){
	retVal = 0; // tie
     }
     else{
	retVal = -1; // null (something is wrong)
      }
   return retVal; // returns winner
   }

//examples & testing
    public static void main(String[] args) {
        System.out.println("Enter Player 1's cards:");
        Scanner scanner = new Scanner(System.in);
	String givenHand = scanner.nextLine();
        PokerHand newHand = new PokerHand(givenHand); 
	System.out.println(newHand.formattedHand());
	System.out.println("STRAIGHT FLUSH:" + newHand.straightFlush());
	System.out.println("FOUROFAKIND: " + newHand.fourOfAKind());
    	System.out.println("FULL HOUSE: " + newHand.fullHouse());
	System.out.println("FLUSH: " + newHand.flush());
	System.out.println("STRAIGHT " + newHand.straight());
	System.out.println("THREE OF A KIND: " + newHand.threeOfAKind());
	System.out.println("TWO PAIR: " + newHand.twoPair());
	System.out.println("ONE PAIR: " + newHand.onePair());
	System.out.println( newHand.bestHand());
	
	System.out.println("Enter Player 2's cards:");
	Scanner sc = new Scanner(System.in);
	String playerTwoHand = scanner.nextLine();
	PokerHand newHand2 = new PokerHand(playerTwoHand);
	System.out.println(newHand2.formattedHand());
	System.out.println("STRAIGHT FLUSH: " + newHand2.straightFlush());
	System.out.println("FOUR OF A KIND: " + newHand2.fourOfAKind());
	System.out.println("FULL HOUSE: " + newHand2.fullHouse());
	System.out.println("FLUSH: " + newHand2.flush());
	System.out.println("STRAIGHT: " + newHand2.straight());
	System.out.println("THREE OF A KIND: " + newHand2.threeOfAKind());
	System.out.println("TWO PAIR: " + newHand2.twoPair());
	System.out.println("ONE PAIR: " + newHand2.onePair());
        System.out.println(newHand2.bestHand());
	System.out.println(newHand.compareHands(newHand2));
	}

}
