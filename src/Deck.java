public class Deck {
    private Card[] cards;

    public Deck() {
        cards = new Card[52];
        populateDeck();
    }

    public void populateDeck() {
        int index = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int face = 1; face <= 13; face++) {
                cards[index++] = new Card(face, suit);
            }
        }
    }

    // Shuffle the deck
    public void shuffle() {
        java.util.Random rand = new java.util.Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public Card removeCard(int index) {
        if (index < 0 || index >= cards.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        Card removed = cards[index];
        Card[] newCards = new Card[cards.length - 1];
        for (int i = 0, j = 0; i < cards.length; i++) {
            if (i != index) {
                newCards[j++] = cards[i];
            }
        }
        cards = newCards;
        return removed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.length; i++) {
            sb.append(i + 1).append(": ").append(cards[i]).append("\n");
        }
        return sb.toString();
    }
}