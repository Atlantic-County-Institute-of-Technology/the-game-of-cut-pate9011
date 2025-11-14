import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerScore = 0;
        int computerScore = 0;
        int roundsToWin = 3;
        int totalRounds = 5;
        int round = 1;
        System.out.println("Welcome to the Game of Cut!");
        while (playerScore < roundsToWin && computerScore < roundsToWin && round <= totalRounds) {
            System.out.println("\n--- Round " + round + " ---");
            Deck deck = new Deck();
            deck.shuffle();
            int deckSize = 52;
            int playerCutPos = -1;


            while (playerCutPos < 0 || playerCutPos >= deckSize - 1) {
                System.out.print("Choose a position to cut the deck (1 to 51): ");
                if (scanner.hasNextInt()) {
                    playerCutPos = scanner.nextInt() - 1;
                } else {
                    scanner.next();
                }
            }
            Card playerCard = deck.removeCard(playerCutPos);
            deckSize--;
            System.out.println("You chose: " + playerCard);

            Random rand = new Random();
            int compStart = playerCutPos;
            if (compStart >= deckSize) compStart = deckSize - 1;
            int computerCutPos = rand.nextInt(deckSize - compStart) + compStart;
            Card computerCard = deck.removeCard(computerCutPos);
            System.out.println("Computer chose: " + computerCard);

            // 3. Compare cards
            int winner = compareCards(playerCard, computerCard);
            if (winner > 0) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (winner < 0) {
                System.out.println("Computer wins this round!");
                computerScore++;
            } else {
                System.out.println("It's a tie!");
            }
            System.out.println("Score: You " + playerScore + " - Computer " + computerScore);
            round++;
        }
        System.out.println("\n--- Game Over ---");
        if (playerScore > computerScore) {
            System.out.println("Congratulations! You win the Game of Cut!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins the Game of Cut! Better luck next time.");
        } else {
            System.out.println("It's a draw!");
        }
        scanner.close();
    }

    private static int compareCards(Card player, Card computer) {
        if (player.getFace() > computer.getFace()) {
            return 1;
        } else if (player.getFace() < computer.getFace()) {
            return -1;
        } else {
            if (player.getSuit() < computer.getSuit()) {
                return 1;
            } else if (player.getSuit() > computer.getSuit()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}