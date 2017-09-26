package comp303.textbook.module1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class EnumeratedCardTest {

    @Test
    public void test() {
        assertEquals(EnumeratedCard.ACE_SPADES.suit, Suit.SPADES);
        assertEquals(EnumeratedCard.ACE_SPADES.rank, Rank.ACE);
        assertEquals(EnumeratedCard.FOUR_DIAMONDS.suit, Suit.DIAMONDS);
        assertNotEquals(EnumeratedCard.TEN_CLUBS.rank, Rank.NINE);
    }

}