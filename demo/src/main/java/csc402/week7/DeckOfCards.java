package csc402.week7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<Card> deck;

    public DeckOfCards() {
        deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            return null;
        }
        return deck.remove(deck.size() - 1);
    }

    public int remainingCards() {
        return deck.size();
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        System.out.println("Dealing cards:");
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.dealCard());
        }
        System.out.println("Remaining cards: " + deck.remainingCards());
    }
}