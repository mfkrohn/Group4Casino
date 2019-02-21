import java.util.ArrayList;
import java.util.List;

public abstract class Player {

public String name;
public Integer balance;
public boolean isComputer;
public List<Card> hand = new ArrayList<>();
IOConsole display = new IOConsole();

    public Player(String name, Integer startingBalance) {
        this.name = name;
        this.balance = startingBalance;
        this.isComputer = false;
    }



    public void addCardtoHand(Deck deck){
        hand.add(deck.drawCard());
    }

    public Integer getHandSize(){
        return hand.size();
    }

    public void showFaceUpCard(){
        display.println(name + "'s face up card is a: " + hand.get(1).toString() + "%n");
    }

    public Integer getHandValue(){
        Integer handValue = 0;
        boolean hasAce = false;
        for (Card thisCard : hand){
            handValue += thisCard.blackJackValue;

            if ( thisCard.getCardName().equals("Ace")){
                hasAce = true;
            }
        }
        if( hasAce && handValue > 21){
            handValue -= 10;
        }
        if(handValue > 21){
            handValue = 0;
        }
        return handValue;
    }

    public void removeBalance(Integer bet){
        balance -= bet;
    }

    public void addBalance(Integer winnings){
        balance += winnings;
    }

    public void clearHand(){
        hand.clear();
    }



    public abstract void printHand();
    public abstract Integer giveBet();
    public abstract boolean hitOrStand();
}

