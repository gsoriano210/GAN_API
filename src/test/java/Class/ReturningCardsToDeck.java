package Class;

public class ReturningCardsToDeck {

protected Boolean success;
protected String deck_id;
protected Boolean shuffled;
protected Integer remaining;
protected Piles piles;

    public Boolean getSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public Boolean getShuffled() {
        return shuffled;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public Piles getPiles() {
        return piles;
    }
}
class Piles{

    protected Discard discard;

    public Discard getDiscard() {
        return discard;
    }
}

class Discard{
    protected Integer remaining;

    public Integer getRemaining() {
        return remaining;
    }
}