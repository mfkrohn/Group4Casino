import org.junit.Test;

import java.util.TreeMap;

public class Card {
public String cardName;
public String suit;
public Integer blackJackValue;
BlackJackCardValueMap cardValueMap = new BlackJackCardValueMap();


    public Card(String cardName, String suit) {
        this.cardName = cardName;
        this.suit = suit;

        this.blackJackValue = cardValueMap.get(cardName);
    }

    public String getCardName() {
        return cardName;
    }

    public String getSuit() {
        return suit;
    }

    public Integer getBlackJackValue() {
        return blackJackValue;
    }

    @Override
    public String toString(){
        return (cardName + " of " + suit);
    }
}


