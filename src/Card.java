public class Card {
    private final int face;
    private final int suit;
    private final String[] faces = new String[]{null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private final String[] suits = new String[]{null, "Spades", "Hearts", "Clubs", "Diamonds"};

    public Card(int face, int suit) {
        this.face = face;
        this.suit = suit;
    }

    public int getFace() {
        return this.face;
    }

    public int getSuit() {
        return this.suit;
    }

    public String toString() {
        String var10000 = this.faces[this.face];
        return var10000 + " of " + this.suits[this.suit];
    }
}