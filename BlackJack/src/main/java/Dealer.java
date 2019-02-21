import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player{
    public Dealer() {
        super("Dealer", 0);
    }

    @Override
    public void printHand() {

        for (Card currentCard : hand){
            display.println(currentCard.toString());
        }
        display.println(name + "'s current hand value is: " + getHandValue()+ "%n" + "%n");
    }


    @Override
    public Integer giveBet() {
        return 0;
    }

    @Override
    public boolean hitOrStand() {
        if(getHandValue() < 16){
            display.println(name + " has decided to hit! %n");
            return true;
        }

        return false;
    }


    //List<Integer> playerBets = new ArrayList<>();

//    public void getPlayerBet(Player currentlyAddressedPlayer){
//        if (!currentlyAddressedPlayer.isComputer) {
//            Integer bet = display.getIntegerInput("What would you like to bet?");
//            currentlyAddressedPlayer.removeBalance(bet);
//            playerBets.add(bet);
//        }
//        else if(currentlyAddressedPlayer.isComputer){
//            Integer bet = ((ComputerPlayer) currentlyAddressedPlayer).giveBet();
//            playerBets.add(bet);
//        }
//        else{
//
//        }
//
//    }

//    public Card dealCard(Deck currentDeck){
//        return currentDeck.drawCard();
//    }

//    public boolean askToHit(){
//        String response = display.getStringInput("Would you like to hit or stand?");
//        if (response.equalsIgnoreCase("hit")){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

//    public void takePlayerHand(Player currentlyAddressedPlayer){
//        currentlyAddressedPlayer.clearHand();
//    }

//    public void giveWinnings(Player currentlyAddressedPlayer,Integer playerBet){
//         if(currentlyAddressedPlayer.getHandValue() > this.getHandValue() && currentlyAddressedPlayer.getHandValue() <= 21){
//            currentlyAddressedPlayer.addBalance(playerBet*2);
//        }
//    }

//    public void clearBets(){
//        playerBets.clear();
//    }

}
