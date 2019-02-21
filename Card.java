/* author: rajee ganesan
 * login: cs11wki
 * date: jan 28 2019
 * file: card.java
 * sources of help: n/a
 * description: creates methods to be used in pokerhand.java, such
 * as recieving the rank and switching to a string, the suit of a card
 * and combining both to create a card.


/**
 * Class that stores the information related to one card of the deck
 */
public class Card implements ICard {

    private String rank;
    private String suit; //You can add more instance variables if you want
    private int cardNumber;
    int[] numberVal = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    String[] cardVal = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
		        "J", "Q", "K"};
  

    /**
     *Constructor for the class
     *@param cardNumber,suit From the PokerHand's class constructor
     *call the constructor to the card class by passing the cardNumber
     *and the suit of the Card
     *
    **/ 
    Card(int cardNumber, String suit){
        this.cardNumber = cardNumber;
	this.suit = suit;
    }

    /**
     * getsuit method
     * @param  null
     * returns the suit of a card
     **/   
    public String getSuit(){
	return suit;
    }



    /** 
     * helper method for indexOf
     * @param array array and number inputted by user
     * returns index of where the number is found in the array
     **/  
    public static int indexOf(int[] array, int number){
	int returnVal = 0; // initializes
	for (int i = 0; i < array.length;i++)
	    if (number == array[i]){
		returnVal = i; // finds array value at index
	        break;
	    }
         
       return returnVal; // returns array value
     }


    /** 
     * helper method for indexOfNth
     * @param array array and string inputted by user
     * returns index of where the string is found in the array
     **/
    public static int indexOfNth(String[] array, String phrase){
	int returnVal = 0; // initializes
	for (int i = 0; i < array.length; i++)
	if (phrase == array[i]){
		returnVal = i; // finds index of string value
		break;
	}
	return returnVal; // returns array value
 	 }



    /**
     * method getrank
     * @param null
     * returns the rank of the given card
     **/  
    public String getRank(){
        int number = cardNumber; // initializes
	int indexValue = indexOf(numberVal,number); // finds rank equivalent
        String retVal = cardVal[indexValue]; 
	return retVal; // returns rank equivalent
    }


    /**
     * method cardInfo
     * @param null
     * returns a combination of both the rank and the card
     **/ 
    public String cardInfo(){
         int number = cardNumber;
	 int indexVal = indexOf(numberVal, number);
	 String newRank = cardVal[indexVal]; // finds rank
         String combo = newRank + suit; // combines
         return combo; // returns combined value
    }

// examples
    public static void main(String args[]){
	Card example = new Card(13, "D");
	System.out.println(example.getRank());
	System.out.println(example.getSuit());
	System.out.println(example.cardInfo());

    }
}
