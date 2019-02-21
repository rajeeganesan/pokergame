public interface IPokerHand {
    /**
     * Given a String of cards as input, return the formatted String
     * For example, given - "1 S 2 C 4 C 5 D 6 H"
     * @return "AS 2C 4C 5D 6H" (No trailing spaces)
     */
    public String formattedHand();

    /**
     * Return the highest hand possible by the given set of cards
     * For example, given - "1 S 2 S 3 S 4 S 5 S"
     * @return "STRAIGHT FLUSH"
     */
    public String bestHand();


    /**
     * Given two poker hands return which hand wins.
     * @param p, another poker hand to compare with the first hand
     * @return 0 for a tie, 1 if Player 1 wins, 2 if player 2 wins
     */
    public int compareHands(PokerHand p);
}
