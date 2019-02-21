import java.util.ArrayList;
import java.util.List;

public class BlackJackSim {

    public static void main(String[] args) {
        IOConsole display = new IOConsole();
        String playAgain;
        Deck deck = new Deck(4);
        Player player1 = new HumanPlayer("Mike",10000);
        Player opponent1 = new computerPlayer(80);
        Player dealer = new Dealer();
        List<Player> playerList = new ArrayList<>();
        List<Integer> betList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(opponent1);
        playerList.add(dealer);
        //Iterator<Player> playerIterator = playerList.iterator();


        while (true) {
            //Acquire the bets from all the players and store the bets in a list
            for (Player currentPlayer : playerList) {

                betList.add(currentPlayer.giveBet());

            }

            display.println("Dealing the cards... %n");
            //Deal two cards to each player one by one
            for (int i = 0; i < 2; i++) {
                for (Player currentPlayer : playerList) {
                    currentPlayer.addCardtoHand(deck);
                }
            }
            //Display all the players hand's for the user to see.
            //The Dealer's face up card is shown here
            for (Player currentPlayer : playerList) {
                if (currentPlayer.name.equals("Dealer")) {
                    currentPlayer.showFaceUpCard();
                } else {
                    currentPlayer.printHand();
                }
            }
            //Cycle through each player asking them to hit or stand as much as they want
            //If player busts or hits 21 loop will break and switch to next player
            for (Player currentPlayer : playerList) {
                boolean stop = false;
                while (!stop) {
                    if (currentPlayer.hitOrStand()) {
                        currentPlayer.addCardtoHand(deck);
                    } else {
                        display.println(currentPlayer.name + " has decided to stand.");
                        stop = true;
                    }
                    currentPlayer.printHand();
                    if (currentPlayer.getHandValue() == 0) {
                        display.println(currentPlayer.name + " has busted! %n");

                        stop = true;
                    } else if (currentPlayer.getHandValue() == 21 && currentPlayer.getHandSize() == 2) {
                        display.println(currentPlayer.name + " has Black Jack! %n");
                        stop = true;
                    } else if (currentPlayer.getHandValue() == 21) {
                        display.println(currentPlayer.name + " has 21! %n");
                        stop = true;
                    }
                }
            }
            //Loop through each player to check if their hand is a winning hand!
            //If player has Black Jack, pay them more three times their bet instead of 2
            //After winnings are calculated the player will discard their hand
            Integer playerNum = 0;
            for (Player currentPlayer : playerList) {

                if (currentPlayer.name.equals("Dealer")) {
                    currentPlayer.clearHand();
                    break;
                }
                if (currentPlayer.getHandValue() == 21 && currentPlayer.getHandSize() == 2) {
                    currentPlayer.addBalance(betList.get(playerNum) * 3);
                    display.println(currentPlayer.name + " has won: $" + (betList.get(playerNum) * 3) + "!");
                    currentPlayer.clearHand();

                } else if (currentPlayer.getHandValue() > dealer.getHandValue()) {
                    currentPlayer.addBalance(betList.get(playerNum) * 2);
                    display.println(currentPlayer.name + " has won: $" + (betList.get(playerNum) * 2) + "!  Their new balance is: $" + currentPlayer.balance);
                    currentPlayer.clearHand();
                }
                else if (currentPlayer.getHandValue() == dealer.getHandValue()){
                    currentPlayer.addBalance(betList.get(playerNum));
                    display.println(currentPlayer.name + " has pushed.");
                    currentPlayer.clearHand();
                }
                else{
                    currentPlayer.clearHand();
                }
                playerNum++;
            }
            //All bets are cleared from the table and the user is asked if they want to play again
            betList.clear();
            playAgain = display.getStringInput("Would you like to continue?");
            if (playAgain.equalsIgnoreCase("yes")) {

            } else {
                break;
            }
            //If the deck is getting low on cards, make a new deck
            if(deck.getDeckSize() < 20){
                 deck = new Deck(4);
            }
            //Game starts over with players new balances saved.
        }
    }
}
