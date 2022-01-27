package Class;

import java.util.List;

public class DrawCard {

    protected Boolean success;
    protected String deck_id;
    protected Integer remaining;
    protected List<Card> cards;

    public Boolean getSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public List<Card> getCards() {
        return cards;
    }
}
