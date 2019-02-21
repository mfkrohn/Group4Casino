import java.util.Random;

public class computerPlayer extends Player {

    public Integer probToHit;
    public Integer probToSplit;
    public Integer[] betList;
    Random randomNum = new Random();

    public computerPlayer(Integer probToHit) {
        super("Davis",10000);

            this.probToHit = probToHit;
            this.probToSplit = 100;
            this.betList = new Integer[]{20, 100, 100, 100, 100, 500, 500, 500, 1000, 5000};



//            case 2:
//                this.name = "Poor and Scared";
//                this.balance = 500;
//                this.probToHit = 50;
//                this.probToSplit = 50;
//                this.betList = new Integer[]{5, 5, 5, 5, 5, 5, 5, 10, 10, 20};
//                this.isComputer = true;
//                break;
//
//                default:
//                break;


        }



    public Integer giveBet(){
        Integer bet = betList[randomNum.nextInt(betList.length-1)];
        removeBalance(bet);
        display.println(name + " has bet: $" + bet + ", their remaining balance is: $" +balance);
        return bet;
    }

    public void printHand(){
        for (Card currentCard : hand){
            display.println(currentCard.toString());
        }
        display.println(name + "'s current hand value is: " + getHandValue()+ "%n" + "%n");
    }

    public boolean hitOrStand(){
        if (getHandValue() != 21){
        if(randomNum.nextInt(99) < probToHit){
            display.println(name + " has decided to hit! %n");
            return true;
        }
        return false;
        }
        return  false;
    }
}
