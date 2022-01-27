package Class;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GanApiTest {

    @Test
    public Shuffle shuffleCards(int deck_count)  {

        Response response = get("http://deckofcardsapi.com/api/deck/new/shuffle/?deck_count="+deck_count);

        return response.getBody().as(Shuffle.class);

    }

    public DrawCard drawCard(String deckId, int count) {
        Response response = get("http://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=" + count);

        return response.as(DrawCard.class);
    }

    public ReshuffleCards reshuffleCards(String deckId, boolean remaining) {
        String url = "http://deckofcardsapi.com/api/deck/" + deckId + "/shuffle/";

        if (remaining){
            url += "?remaining=true";
        }

        Response response = get(url);

        return response.as(ReshuffleCards.class);

      }

    public ReturningCardsToDeck returningCardsToDeck(String deckId, String cardCode) {
        Response response = get("http://deckofcardsapi.com/api/deck/" + deckId + "/return/?cards="+cardCode);

        return response.as(ReturningCardsToDeck.class);

    }
}
