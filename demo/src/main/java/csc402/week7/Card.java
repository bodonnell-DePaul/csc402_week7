package csc402.week7;
import java.util.Objects;

enum Suit {
    DIAMONDS, CLUBS, HEARTS, SPADES
}

enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

class Card implements Comparable<Card> {
    private Suit suit;
    private Rank rank;
    

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

    
    public Card add(Card b) 
    {

        // card1 += card2
        int newRankOrdinal = this.rank.ordinal() + b.getRank().ordinal();
        if(newRankOrdinal > Rank.ACE.ordinal()){
            this.rank = Rank.ACE;
        }
        if(this.suit.ordinal() > Suit.SPADES.ordinal()){
            this.suit = Suit.SPADES;
        }

        return this;
        //Card c = card1 + card2
        //return new Card(this.rank+ b.getRank(), this.suit);
        
    }

    public Card subtract(Card b) 
    {
        // card1 -= card2
        int newRankOrdinal = this.rank.ordinal() - b.getRank().ordinal();
        if(newRankOrdinal < Rank.ACE.ordinal()){
            this.rank = Rank.ACE;
        }
        if(this.suit.ordinal() < Suit.SPADES.ordinal()){
            this.suit = Suit.SPADES;
        }

        return this;
    }

    public Card divide(Card b) 
    {
        // card1 /= card2
        int newRankOrdinal = this.rank.ordinal() / b.getRank().ordinal();
        if(newRankOrdinal < Rank.ACE.ordinal()){
            this.rank = Rank.ACE;
        }
        if(this.suit.ordinal() < Suit.SPADES.ordinal()){
            this.suit = Suit.SPADES;
        }

        return this;
    }

    public Card multiply(Card b) 
    {
        // card1 *= card2
        int newRankOrdinal = this.rank.ordinal() * b.getRank().ordinal();
        if(newRankOrdinal > Rank.ACE.ordinal()){
            this.rank = Rank.ACE;
        }
        if(this.suit.ordinal() > Suit.SPADES.ordinal()){
            this.suit = Suit.SPADES;
        }

        return this;
    }

    // Implementing the other operators
    public Card mod(Card b) 
    {
        // card1 %= card2
        int newRankOrdinal = this.rank.ordinal() % b.getRank().ordinal();
        if(newRankOrdinal < Rank.ACE.ordinal()){
            this.rank = Rank.ACE;
        }
        if(this.suit.ordinal() < Suit.SPADES.ordinal()){
            this.suit = Suit.SPADES;
        }

        return this;
    }

    public Card and(Card b) 
    {
        // card1 &= card2
        int newRankOrdinal = this.rank.ordinal() & b.getRank().ordinal();
        if(newRankOrdinal < Rank.ACE.ordinal()){
            this.rank = Rank.ACE;
        }
        if(this.suit.ordinal() < Suit.SPADES.ordinal()){
            this.suit = Suit.SPADES;
        }

        return this;
    }

    public Card or(Card b) 
    {
        // card1 |= card2
        int newRankOrdinal = this.rank.ordinal() | b.getRank().ordinal();
        if(newRankOrdinal > Rank.ACE.ordinal()){
            this.rank = Rank.ACE;
        }
        if(this.suit.ordinal() > Suit.SPADES.ordinal()){
            this.suit = Suit.SPADES;
        }

        return this;
    }

    public Card xor(Card b) 
    {
        // card1 ^= card2
        int newRankOrdinal = this.rank.ordinal() ^ b.getRank().ordinal();
        if(newRankOrdinal > Rank.ACE.ordinal()){
            this.rank = Rank.ACE;
        }
        if(this.suit.ordinal() > Suit.SPADES.ordinal()){
            this.suit = Suit.SPADES;
        }

        return this;
    }

    public Card not() 
    {
        // card1 = ~card1
        int newRankOrdinal = ~this.rank.ordinal();
        if(newRankOrdinal < Rank.ACE.ordinal()){
            this.rank = Rank.ACE;
        }
        if(this.suit.ordinal() < Suit.SPADES.ordinal()){
            this.suit = Suit.SPADES;
        }

        return this;
    }

    
    //other operators
    //>=, <=, >, <, !=

}