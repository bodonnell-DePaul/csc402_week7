package csc402.week7;
import java.util.Objects;

enum Suit {
    DIAMONDS, CLUBS, HEARTS, SPADES
}

enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

class Card implements Comparable<Card> {
    private final Suit suit;
    private final Rank rank;
    

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card other) {
        // Custom comparison logic based on the game
        // For example, comparing by rank first, then by suit

        int rankComparison = this.rank.ordinal() - other.rank.ordinal();
        if( this.rank == other.getRank())
        {
            return this.suit.ordinal() - other.getSuit().ordinal();
        }
        if (rankComparison != 0) {
            return rankComparison;
        }

        return this.suit.ordinal() - other.suit.ordinal();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // @Override
    // public Card add(Card b) {

    //     // card1 += card2
    //     this.rank += b.getRank();
    //     this.suit += b.getSuit();
    //     if(this.rank > Rank.ACE){
    //         this.rank = Rank.ACE;
    //     }
    //     if(this.suit > Suit.SPADES){
    //         this.suit = Suit.SPADES;
    //     }

    //     //Card c = card1 + card2
    //     //return new Card(this.rank+ b.getRank(), this.suit);
        
    // }

    // @Override
    // public Card subtract(Card b) {
    //     // card1 -= card2
    //     this.rank -= b.getRank();
    //     this.suit -= b.getSuit();
    //     if(this.rank < Rank.TWO){
    //         this.rank = Rank.TWO;
    //     }
    //     if(this.suit < Suit.HEARTS){
    //         this.suit = Suit.HEARTS;
    //     }

    //     //Card c = card1 - card2
    //     //return new Card(this.rank- b.getRank(), this.suit);
    // }

    // @Override
    // public Card multiply(Card b) {
    //     // card1 *= card2
    //     this.rank *= b.getRank();
    //     this.suit *= b.getSuit();
    //     if(this.rank > Rank.ACE){
    //         this.rank = Rank.ACE;
    //     }
    //     if(this.suit > Suit.SPADES){
    //         this.suit = Suit.SPADES;
    //     }

    //     //Card c = card1 * card2
    //     //return new Card(this.rank* b.getRank(), this.suit);
    // }

    // @Override
    // public Card divide(Card b) {
    //     // card1 /= card2
    //     this.rank /= b.getRank();
    //     this.suit /= b.getSuit();
    //     if(this.rank < Rank.TWO){
    //         this.rank = Rank.TWO;
    //     }
    //     if(this.suit < Suit.HEARTS){
    //         this.suit = Suit.HEARTS;
    //     }

    //     //Card c = card1 / card2
    //     //return new Card(this.rank/ b.getRank(), this.suit);
    // }

    // @Override
    // public Card mod(Card b) {
    //     // card1 %= card2
    //     this.rank %= b.getRank();
    //     this.suit %= b.getSuit();
    //     if(this.rank < Rank.TWO){
    //         this.rank = Rank.TWO;
    //     }
    //     if(this.suit < Suit.HEARTS){
    //         this.suit = Suit.HEARTS;
    //     }

    //     //Card c = card1 % card2
    //     //return new Card(this.rank% b.getRank(), this.suit);
    // }

    // @Override
    // public Card negate() {
    //     // card1 = -card1
    //     this.rank = -this.rank;
    //     this.suit = -this.suit;
    //     if(this.rank < Rank.TWO){
    //         this.rank = Rank.TWO;
    //     }
    //     if(this.suit < Suit.HEARTS){
    //         this.suit = Suit.HEARTS;
    //     }

    //     //Card c = -card1
    //     //return new Card(-this.rank, -this.suit);
    // }


    //other operators
    //>=, <=, >, <, !=

}