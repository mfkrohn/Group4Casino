import org.junit.Assert;
import org.junit.Test;

public class CardTest {


    @Test
    public void cardConstructorTest() {
        //Given
        String actualSuit = "Spade";
        String actualCardName = "ace";
        Integer actualValue = 11;
        Card testCard = new Card(actualCardName, actualSuit);
        //When
        Integer expectedValue = testCard.getBlackJackValue();
        String expectedSuit = testCard.getSuit();
        String expectedCardName = testCard.getCardName();
        //Then
        Assert.assertEquals(expectedSuit,actualSuit);
        Assert.assertEquals(expectedCardName, actualCardName);
        Assert.assertEquals(expectedValue,actualValue);
    }
}
