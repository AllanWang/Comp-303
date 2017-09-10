package comp303.textbook.module1;

import org.junit.Test;

import static comp303.textbook.module1.EnumeratedCard.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class EnumeratedCardTest {

    @Test
    public void test() {
        assertEquals(ACE_SPADES.suit, Suit.SPADES);
        assertEquals(ACE_SPADES.rank, Rank.ACE);

        assertEquals(FOUR_DIAMONDS.suit, Suit.DIAMONDS);

        assertNotEquals(TEN_CLUBS.rank, Rank.NINE);
        assertEquals(ACE_CLUBS, ACE_CLUBS);
        System.out.println("Suits & Rankings passed");
    }

}