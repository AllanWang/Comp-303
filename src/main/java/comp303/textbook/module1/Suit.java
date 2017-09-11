package comp303.textbook.module1;

/**
 * Created by Allan Wang on 10/09/2017.
 */
public enum Suit {
    SPADES(Color.BLACK),
    HEARTS(Color.RED),
    CLUBS(Color.BLACK),
    DIAMONDS(Color.RED);

    private final Color color;

    public Color color() {
        return color;
    }

    Suit(Color color) {
        this.color = color;
    }

    public enum Color {
        RED, BLACK;
    }
}
