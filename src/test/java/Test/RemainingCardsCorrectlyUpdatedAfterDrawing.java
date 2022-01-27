package Test;

import Class.DrawCard;
import Class.GanApiTest;
import Class.Shuffle;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class RemainingCardsCorrectlyUpdatedAfterDrawing extends GanApiTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRemainingCardsCorrectlyUpdatedAfterDrawing() {
        Shuffle shuffle = this.shuffleCards(1);
        String deckId = shuffle.getDeck_id();
        int stolenCard = 0;
        int initialDeck = shuffle.getRemaining();
        int lastRemain = 0;

        //Step 1: Assuming a new deck starts with 52 cards
        softAssert.assertEquals(52,shuffle.getDeck_id(),"you have started playing with "+shuffle.getDeck_id()+" cards instead of 52");
        System.out.println("You have a new deck starting with 52 cards");

        //step 2: Draw cards from the deck 5 times
        for (int i = 0; i < 5; i ++){

            //each time draw between 1 and 5 cards at random
            int random = (int)(Math.random() * ((5 - 1) + 1)) + 1;
            DrawCard drawCard = this.drawCard(deckId,random);
            stolenCard += random;

            for (int j = 0; j < drawCard.getCards().size(); j++){
                System.out.println(drawCard.getCards().get(j).printCard());
            }
            String code = drawCard.getCards().get(0).getCode();

            //Return the first drawn card back to the deck
            this.returningCardsToDeck(deckId,code);
            System.out.println("You are giving back to the drawn deck "+code);

            //reshuffled cards
            lastRemain = this.reshuffleCards(deckId, true).getRemaining();

        }

        //stop reshuffle cards in the 5 attempts
        this.reshuffleCards(deckId, false);

        //step 4: Verify that the correct number of cards are remaining in the deck
        int value = initialDeck - (stolenCard - 5);

        Assert.assertEquals(lastRemain,value,"The remaining cards are "+lastRemain+" instead of "+value);
        System.out.println("The remaining cards are "+lastRemain);

    }
}
