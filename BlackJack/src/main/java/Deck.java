import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

public String[] suits = new String[]{"Spades","Clubs","Diamonds","Hearts"};
public String[] cardTypes = new String[]{"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
public List<Card> deck = new ArrayList<>();
Random randomCard = new Random();

public Deck(Integer numberOfDecks) {
        for (int i = 0; i < numberOfDecks ; i++) {
            for (String currentSuit : suits) {
                for (String currentType : cardTypes) {
                    deck.add(new Card(currentType, currentSuit));
                }
            }
        }
    }

    public Card getCardFromDeckAt(Integer cardPosition) {
        return deck.get(cardPosition);
    }

    public Integer getDeckSize(){
        return deck.size();
    }

    public Card drawCard(){
    Integer grabRandomCard = randomCard.nextInt(deck.size());
    Card cardTaken = deck.get(grabRandomCard);
    deck.remove(deck.get(grabRandomCard));
    return cardTaken;
    }

}
