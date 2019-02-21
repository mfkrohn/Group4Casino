import org.junit.Test;

import java.sql.SQLOutput;

public class DeckTest {


    @Test
    public void deckConstructorTest(){
        //Given
        Integer numberOfDecks = 2;
        //When
        Deck testDeck = new Deck(numberOfDecks);

        //Then
        for (int i = 0; i < testDeck.getDeckSize(); i++) {
            System.out.println(testDeck.getCardFromDeckAt(i).toString());
        }

    }
}
