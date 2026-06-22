# IntroCS-JAVAProject
Georgia State University CSC 1302 - Group Project

By: Deborah Maignan & Joseph Thekveli
# Dice Boss Fighter

## Overview

Dice Boss Fighter is a text-based Java game where the player battles a powerful boss using a variety of attacks. The game combines strategy, probability, object-oriented programming concepts, file handling, inheritance, exception handling, and ArrayList data structures.

The objective is to defeat the boss before your health reaches zero. Each attack has a different damage output, success rate, and score reward, creating a risk-versus-reward gameplay experience.

---

## Features

* Turn-based combat system
* Four unique player attacks
* Randomized attack success using a 12-sided die
* Boss attacks determined by a 6-sided die
* Score tracking system
* Top 3 high-score leaderboard
* File handling for scoreboard storage
* Error handling for invalid player input
* Object-oriented design using inheritance

---

## Game Rules

### Player

Starting Health: **25 HP**

The player may choose one of four attacks each turn:

| Attack    | Damage | Required Roll | Points Awarded |
| --------- | ------ | ------------- | -------------- |
| Sword     | 5      | 2 or higher   | 10             |
| Bow       | 10     | 4 or higher   | 20             |
| Lightning | 20     | 6 or higher   | 50             |
| Fire      | 30     | 8 or higher   | 100            |

A random number from **1–12** is generated to determine whether the attack succeeds.

### Boss

Starting Health: **30 HP**

The boss uses a single attack called **Death Slash**. Damage depends on a random 6-sided die roll:

| Dice Roll | Result    |
| --------- | --------- |
| 1         | Miss      |
| 2–3       | 5 Damage  |
| 4–5       | 10 Damage |
| 6         | 15 Damage |

---

## Scoring System

Points are awarded only when an attack successfully hits the boss.

Higher-risk attacks provide significantly higher rewards:

* Sword = 10 points
* Bow = 20 points
* Lightning = 50 points
* Fire = 100 points

When the player defeats the boss, the final score is recorded.

If the player loses, the score is not saved.

---

## Program Structure

### Main.java

Controls the overall game flow.

Responsibilities:

* Displays menu options
* Starts the game
* Quits the application
* Displays top three scores
* Calls the game engine (`runGame()`)

### Entity.java

Superclass for both the Player and Boss classes.

Contains:

* Health variable
* `getHealth()`
* `takeDamage()`

Demonstrates inheritance.

### Player.java

Handles all player-related actions.

Responsibilities:

* Attack selection
* Dice roll calculations
* Score management
* Input validation
* Exception handling

### Boss.java

Handles boss behavior.

Responsibilities:

* Random attack selection
* Damage calculations
* Player health reduction

### Scoreboard.java

Stores and manages scores.

Responsibilities:

* ArrayList score storage
* Bubble sort implementation
* Top 3 score calculation
* File writing and reading

---

## Object-Oriented Programming Concepts

### Inheritance

`Player` and `Boss` inherit from the `Entity` superclass.

```java
public class Player extends Entity
public class Boss extends Entity
```

Shared functionality:

* Health management
* Damage handling

### Encapsulation

The health variable is private within the `Entity` class and can only be accessed through public methods.

```java
private int health;
```

### Exception Handling

Invalid attack choices are handled using an `IllegalArgumentException`.

```java
throw new IllegalArgumentException("Doesn't have correct input");
```

This prevents the program from crashing due to invalid user input.

---

## Data Structures Used

### ArrayList

Used in the `Scoreboard` class to store completed game scores.

```java
ArrayList<Integer> scoreList;
```

### Bubble Sort

The scoreboard sorts scores from highest to lowest before displaying the top three.

---

## File Handling

The game stores the highest scores in:

```text
topthreescore.txt
```

Functions:

* Writes top three scores
* Reads scores from file
* Displays leaderboard

Example output:

```text
1st Place: 120
2nd Place: 100
3rd Place: 80
```

---

## Sample Gameplay

```text
Welcome!
Enter Start, Quit, or Top three scores

start

Player's turn:
Choose your attack:

sword
bow
lightning
fire

Player chose fire!
The attack hits! You gain 100 points!

Boss used death slash for 10 damage.

Player Health: 15
Boss Health: 0

Great job! You beat the boss!
Final Score: 100
```

---

## UML Relationship

```text
          Entity
             |
     ----------------
     |              |
   Player         Boss
```

Entity provides:

* health
* getHealth()
* takeDamage()

Player and Boss inherit these behaviors.

---

## Challenges Encountered

### Game Engine Logic

One challenge was managing score tracking while running multiple games. Initially, the game returned a boolean value to indicate victory. This was later changed to return the player's score as an integer, allowing the score to be added directly to the scoreboard after each successful game.

### Scoreboard Organization

The original implementation occasionally produced duplicate leaderboard values. This issue was solved by sorting the score list in descending order using Bubble Sort and selecting the first three values as the top scores.

---

## How to Run

### Compile

```bash
javac *.java
```

### Execute

```bash
java Main
```

---

## Learning Outcomes

This project demonstrates:

* Java classes and objects
* Inheritance
* Encapsulation
* Exception handling
* Random number generation
* File I/O
* ArrayLists
* Sorting algorithms
* Event-controlled loops
* Turn-based game logic

## Conclusion

Dice Boss Fighter is a probability-based turn-based combat game that demonstrates several fundamental Java programming concepts. Through inheritance, file handling, exception management, ArrayLists, and sorting algorithms, the project combines gameplay mechanics with practical software development techniques. The game provides an engaging risk-versus-reward system while showcasing object-oriented design principles.
