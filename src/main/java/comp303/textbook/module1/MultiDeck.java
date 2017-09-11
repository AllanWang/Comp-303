package comp303.textbook.module1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Allan Wang on 10/09/2017.
 * <p>
 * Class holding a list of decks, which in turn holds a list of cards
 */
public class MultiDeck {

    static class Deck {
        //assume implementation exists

        private final List<Card> cards;

        Deck(int count) {
            this.cards = new ArrayList<>();
            for (int i = 0; i < count; i++) addCard();
        }

        Deck(List<Card> cards) {
            this.cards = cards;
        }

        /**
         * Returns cards without break encapsulation,
         * assuming that the implementation for {@link Card} is immutable
         *
         * @return list of cards in this deck
         */
        List<Card> getCards() {
            return new ArrayList<>(cards);
        }

        void removeCard(int index) {
            cards.remove(index);
        }

        void addCard() {
            cards.add(new Card() {
            });
        }
    }

    interface Card {
        //assume implementation exists
    }

    final List<Deck> decks;

    MultiDeck(List<Deck> decks) {
        this.decks = decks;
    }

    static MultiDeck copy(MultiDeck multiDeck) {
        return new MultiDeck(multiDeck.decks);
    }

    static MultiDeck deepCopy(MultiDeck multiDeck) {
        //deep copy each deck
        List<Deck> decks = multiDeck.decks.stream().map(deck -> new Deck(deck.getCards())).collect(Collectors.toList());
        return new MultiDeck(new ArrayList<>(decks));
    }
}
