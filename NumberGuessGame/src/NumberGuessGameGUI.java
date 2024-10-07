import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NumberGuessGameGUI {
    private static int MIN_RANGE = 1;
    private static int MAX_RANGE = 100;
    private static int MAX_ATTEMPTS = 6;
    private static int MAX_ROUNDS = 3;

    private int currentRound = 1;
    private int currentAttempts = 0;
    private int totalScore = 0;
    private int numberToGuess;
    private Random random = new Random();

    private JFrame frame;
    private JTextField guessInput;
    private JLabel roundLabel, attemptLabel, scoreLabel, feedbackLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGuessGameGUI().createAndShowGUI());
    }

    public void createAndShowGUI() {
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 1));

        // Labels
        roundLabel = new JLabel("Round 1 of " + MAX_ROUNDS);
        attemptLabel = new JLabel("Attempts left: " + MAX_ATTEMPTS);
        scoreLabel = new JLabel("Total Score: 0");
        feedbackLabel = new JLabel("Enter your guess between " + MIN_RANGE + " and " + MAX_RANGE);

        guessInput = new JTextField();
        JButton submitButton = new JButton("Submit Guess");

        submitButton.addActionListener(new SubmitGuessListener());

        // Adding components to frame
        frame.add(roundLabel);
        frame.add(attemptLabel);
        frame.add(scoreLabel);
        frame.add(feedbackLabel);
        frame.add(guessInput);
        frame.add(submitButton);

        startNewRound();

        frame.setVisible(true);
    }

    // Starts a new round by resetting the necessary variables
    private void startNewRound() {
        numberToGuess = random.nextInt(MAX_RANGE) + MIN_RANGE;
        currentAttempts = 0;
        updateUI();
    }

    // Updates the UI labels with current game information
    private void updateUI() {
        roundLabel.setText("Round " + currentRound + " of " + MAX_ROUNDS);
        attemptLabel.setText("Attempts left: " + (MAX_ATTEMPTS - currentAttempts));
        scoreLabel.setText("Total Score: " + totalScore);
    }

    // Listener class for handling guess submissions
    private class SubmitGuessListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String guessText = guessInput.getText();
            try {
                int guess = Integer.parseInt(guessText);

                currentAttempts++;
                if (guess == numberToGuess) {
                    int score = MAX_ATTEMPTS - currentAttempts;
                    totalScore += score;
                    feedbackLabel.setText("Congrats! You guessed it right! Score: " + score);
                    nextRound();
                } else if (guess < numberToGuess) {
                    feedbackLabel.setText("The number is greater than " + guess);
                } else {
                    feedbackLabel.setText("The number is less than " + guess);
                }

                if (currentAttempts == MAX_ATTEMPTS) {
                    feedbackLabel.setText("You've used all attempts! The number was: " + numberToGuess);
                    nextRound();
                }

                updateUI();
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Please enter a valid number!");
            }
            guessInput.setText("");
        }

        // Moves to the next round or ends the game if all rounds are completed
        private void nextRound() {
            if (currentRound < MAX_ROUNDS) {
                currentRound++;
                startNewRound();
            } else {
                feedbackLabel.setText("Game Over! Your total score is: " + totalScore);
                guessInput.setEnabled(false); // Disable input after the game ends
            }
        }
    }
}
