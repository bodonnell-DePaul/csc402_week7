package csc402.week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {
    private DeckOfCards deck;
    private List<Card> playerHand;
    private List<Card> dealerHand;

    public BlackjackGame() {
        deck = new DeckOfCards();
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }

    public void dealInitialHands() {
        deck.shuffle();
        playerHand.add(deck.dealCard());
        playerHand.add(deck.dealCard());
        dealerHand.add(deck.dealCard());
        dealerHand.add(deck.dealCard());
    }

    public void showHands(boolean showDealerHand) {
        System.out.println("Player's hand:");
        for (Card card : playerHand) {
            System.out.println(card);
        }
        System.out.println("Player's hand value: " + calculateHandValue(playerHand));

        System.out.println("\nDealer's hand:");
        if (showDealerHand) {
            for (Card card : dealerHand) {
                System.out.println(card);
            }
            System.out.println("Dealer's hand value: " + calculateHandValue(dealerHand));
        } else {
            System.out.println(dealerHand.get(0));
            System.out.println("Hidden card");
        }
    }

    public int calculateHandValue(List<Card> hand) {
        int value = 0;
        int aceCount = 0;
        for (Card card : hand) {
            switch (card.getRank()) {
                case TWO: value += 2; break;
                case THREE: value += 3; break;
                case FOUR: value += 4; break;
                case FIVE: value += 5; break;
                case SIX: value += 6; break;
                case SEVEN: value += 7; break;
                case EIGHT: value += 8; break;
                case NINE: value += 9; break;
                case TEN: case JACK: case QUEEN: case KING: value += 10; break;
                case ACE: value += 11; aceCount++; break;
            }
        }
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }
        return value;
    }

    public void playerTurn(Scanner scanner) {
        while (true) {
            System.out.println("Do you want to (h)it or (s)tand?");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("h")) {
                playerHand.add(deck.dealCard());
                showHands(false);
                if (calculateHandValue(playerHand) > 21) {
                    System.out.println("Player busts! Dealer wins.");
                    return;
                }
            } else if (action.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println("Invalid action. Please enter 'h' or 's'.");
            }
        }
    }

    public void dealerTurn() {
        while (calculateHandValue(dealerHand) < 17) {
            dealerHand.add(deck.dealCard());
        }
        showHands(true);
        if (calculateHandValue(dealerHand) > 21) {
            System.out.println("Dealer busts! Player wins.");
        }
    }

    public void determineWinner() {
        int playerValue = calculateHandValue(playerHand);
        int dealerValue = calculateHandValue(dealerHand);

        if (playerValue > 21) {
            System.out.println("Player busts! Dealer wins.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts! Player wins.");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins!");
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlackjackGame game = new BlackjackGame();
        game.dealInitialHands();
        game.showHands(false);
        game.playerTurn(scanner);
        if (game.calculateHandValue(game.playerHand) <= 21) {
            game.dealerTurn();
            game.determineWinner();
        }
        scanner.close();
    }
}