public class HumanPlayer extends Player{

    public HumanPlayer(String name, Integer startingBalance) {
        super(name, startingBalance);
    }

    public void printHand(){
        for (Card currentCard : hand){
            display.println(currentCard.toString());
        }
        display.println(name + "'s current hand value is: " + getHandValue()+ "%n" + "%n");
    }

    public boolean hitOrStand(){
        String response = display.getStringInput("Would you like to hit or stand?");
        if (response.equalsIgnoreCase("hit")){
            display.println(name + " has decided to hit! %n");
            return true;
        }
        else{
            return false;
        }
    }

    public Integer giveBet(){
        Integer bet = display.getIntegerInput("What would you like to bet?");
            removeBalance(bet);
            display.println(name + " has bet: $" + bet + ", their remaining balance is: $" +balance);
            return bet;
    }

}
