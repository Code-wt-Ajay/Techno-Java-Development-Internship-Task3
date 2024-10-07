
# Number Guess Game - Java Swing GUI Implementation

This project is a graphical version of the classic Number Guessing Game. It uses Java Swing for the graphical user interface (GUI) and follows basic game logic where players try to guess a randomly generated number within a specified range and a limited number of attempts. The game consists of multiple rounds, and each correct guess awards points.

## Table of Contents
- [Getting Started](#getting-started)
- [Code Walkthrough](#code-walkthrough)
- [Features](#features)
- [How to Run](#how-to-run)
- [Game Rules](#game-rules)

## Getting Started

### Prerequisites
Ensure that you have the following installed:
- Java Development Kit (JDK 8 or higher)
- An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse, or a command-line interface like Terminal or Command Prompt.

### Installation
1. Clone this repository.
2. Open the project in your IDE or navigate to the project directory in your terminal.
3. Compile and run the program.

## Code Walkthrough

### Main Class: `NumberGuessGameGUI`

```java
import javax.swing.*;       // Imports all components of Java Swing
import java.awt.*;          // Imports AWT classes for window-based applications
import java.awt.event.*;    // Imports event handling classes for handling user interactions
import java.util.Random;    // Imports Random class to generate random numbers
```

- **`javax.swing.*`**: Imports all Swing components for creating a graphical interface, such as `JFrame`, `JLabel`, `JButton`, etc.
- **`java.awt.*`**: Provides AWT (Abstract Window Toolkit) classes for graphics and window management.
- **`java.awt.event.*`**: Used for event handling, allowing the GUI to respond to user input (e.g., button clicks).
- **`java.util.Random`**: A class to generate random numbers that will be used in the guessing game.

---

```java
public class NumberGuessGameGUI {
    private static int MIN_RANGE = 1;                // Minimum number the player can guess
    private static int MAX_RANGE = 100;              // Maximum number the player can guess
    private static int MAX_ATTEMPTS = 6;             // Maximum number of guesses allowed per round
    private static int MAX_ROUNDS = 3;               // Maximum number of rounds in the game
```
Explanation of variables used:
- **`MIN_RANGE`**: Defines the lower bound for the random number that needs to be guessed (1).
- **`MAX_RANGE`**: Defines the upper bound for the random number that needs to be guessed (100).
- **`MAX_ATTEMPTS`**: Specifies the maximum attempts allowed to guess the number per round (6).
- **`MAX_ROUNDS`**: Sets the maximum number of rounds in the game (3).

... (continued in full detailed explanation)

## Features
- Java Swing-based GUI.
- Random number generation.
- Three rounds of gameplay.
- Score calculation based on attempts.

## How to Run
1. Compile the Java file:
```bash
javac NumberGuessGameGUI.java
```
2. Run the program:
```bash
java NumberGuessGameGUI
```

## Game Rules
- Each player gets 6 attempts per round.
- The goal is to guess a random number between 1 and 100.
- Points are awarded based on how many attempts were left when the correct guess was made.
- There are 3 rounds in total.

