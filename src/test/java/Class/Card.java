package Class;

public class Card {


    protected Image images;
    protected String value;
    protected String suit;
    protected String code;
    protected String image;

    public Image getImages() {
        return images;
    }

    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String getCode() {
        return code;
    }

    public String getImage() {
        return image;
    }

    public String printCard(){
        return "You are drawing "+ value +" "+suit;
    }
}
