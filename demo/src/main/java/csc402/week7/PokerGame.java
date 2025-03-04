package csc402.week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PokerGame {
    private DeckOfCards deck;
    private List<Card> playerHand;
    private List<Card> computerHand;

    public PokerGame() {
        deck = new DeckOfCards();
        playerHand = new ArrayList<>();
        computerHand = new ArrayList<>();
    }

    public void dealHands() {
        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            playerHand.add(deck.dealCard());
            computerHand.add(deck.dealCard());
        }
    }

    public void showHands() {
        System.out.println("Player's hand:");
        for (Card card : playerHand) {
            System.out.println(card);
        }
        System.out.println("\nComputer's hand:");
        for (Card card : computerHand) {
            System.out.println(card);
        }
    }

    public String determineWinner() {
        Collections.sort(playerHand);
        Collections.sort(computerHand);

        Card playerHighest = playerHand.get(playerHand.size() - 1);
        Card computerHighest = computerHand.get(computerHand.size() - 1);

        System.out.println("\nPlayer's highest card: " + playerHighest);
        System.out.println("Computer's highest card: " + computerHighest);

        
        int comparison = playerHighest.compareTo(computerHighest);
        if (comparison > 0) {
            return "Player wins!";
        } else if (comparison < 0) {
            return "Computer wins!";
        } else {
            return "It's a tie!";
        }
    }

    public static void main(String[] args) {
        PokerGame game = new PokerGame();
        game.dealHands();
        game.showHands();
        System.out.println("\n" + game.determineWinner());
    }
}