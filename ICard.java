public interface ICard {

    /**
     * @return the rank of a given card
     */
    public String getRank();

    /**
     * Given a card, return the suit to which it belongs
     * @return one of - {"S", "H", "C", "D"}
     */
    public String getSuit();

    /**
     * Function to return the combined information about a card
     * Eg - Given - rank as 10 and suit as "S", return "10S"
     * Given rank as 1 and suit as "C", return "AC"
     * @return cardNumber and suit in one combined string (no space in between)
     */
    public String cardInfo();
}
