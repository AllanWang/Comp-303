package comp303.textbook.module1;

import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by Allan Wang on 10/09/2017.
 */
public class MultiDeckTest {

    private Pair<MultiDeck, MultiDeck> init(Function<MultiDeck, MultiDeck> copyFun) {
        MultiDeck multiDeck = new MultiDeck(new ArrayList<MultiDeck.Deck>() {{
            add(new MultiDeck.Deck(2));
            add(new MultiDeck.Deck(3));
        }});

        //assert content matches
        MultiDeck multiDeckCopy = copyFun.apply(multiDeck);
        assertEquals(multiDeck.decks.size(), multiDeckCopy.decks.size());
        assertEquals(multiDeck.decks.get(0).getCards().size(), multiDeckCopy.decks.get(0).getCards().size());
        assertEquals(multiDeck.decks.get(0).getCards().get(0).hashCode(), multiDeckCopy.decks.get(0).getCards().get(0).hashCode());

        return new Pair<>(multiDeck, multiDeckCopy);
    }

    @Test
    public void shallowClone() {
        Pair<MultiDeck, MultiDeck> pair = init(MultiDeck::copy);
        MultiDeck multiDeck = pair.getKey();
        MultiDeck multiDeckCopy = pair.getValue();

        //assert deck removal affects both decks
        multiDeck.decks.get(0).removeCard(0);
        assertEquals(multiDeck.decks.get(0).getCards().size(), multiDeckCopy.decks.get(0).getCards().size());
        assertEquals(multiDeck.decks.get(0).getCards().get(0).hashCode(), multiDeckCopy.decks.get(0).getCards().get(0).hashCode());
    }

    @Test
    public void deepClone() {
        Pair<MultiDeck, MultiDeck> pair = init(MultiDeck::deepCopy);
        MultiDeck multiDeck = pair.getKey();
        MultiDeck multiDeckCopy = pair.getValue();

        //assert deck removal affects one deck only
        multiDeck.decks.get(0).removeCard(0);
        assertNotEquals(multiDeck.decks.get(0).getCards().size(), multiDeckCopy.decks.get(0).getCards().size());
        assertNotEquals(multiDeck.decks.get(0).getCards().get(0).hashCode(), multiDeckCopy.decks.get(0).getCards().get(0).hashCode());
    }
}
