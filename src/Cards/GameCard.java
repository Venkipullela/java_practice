package Cards;

import java.util.ArrayList;
import java.util.List;

public class GameCard {
    private String value;
    private CardColour colour;
    private CardType type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        List<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("K");
        letters.add("Q");
        letters.add("J");
        if(letters.contains(value) || (Integer.parseInt(value) < 10 && Integer.parseInt(value) > 1)){
            this.value = value;
        } else {
            throw new IllegalArgumentException("Invalid argument for CardValue: " + value);
        }
    }

    public CardColour getColour() {
        return colour;
    }

    public void setColour(CardColour colour) {
        this.colour = colour;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }
}
