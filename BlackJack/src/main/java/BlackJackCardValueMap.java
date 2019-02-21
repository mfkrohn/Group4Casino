import java.util.TreeMap;

public class BlackJackCardValueMap {

public TreeMap<String,Integer> cardValueMap = new TreeMap<>();



    public BlackJackCardValueMap(){
    cardValueMap.put("Two",2);
    cardValueMap.put("Three",3);
    cardValueMap.put("Four",4);
    cardValueMap.put("Five",5);
    cardValueMap.put("Six",6);
    cardValueMap.put("Seven",7);
    cardValueMap.put("Eight",8);
    cardValueMap.put("Nine",9);
    cardValueMap.put("Ten",10);
    cardValueMap.put("Jack",10);
    cardValueMap.put("Queen",10);
    cardValueMap.put("King",10);
    cardValueMap.put("Ace",11);

}

    public Integer get(String cardName) {
        return cardValueMap.get(cardName);
    }
}
