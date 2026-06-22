import java.io.*;
import java.util.*;
class Main 
{
  /** 
    This program starts the game
  */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scan = new Scanner(System.in);
    Scoreboard scoreboard = new Scoreboard();
    System.out.println("Welcome!");
    boolean begin = true;
    //score board is created; scanner is used to take input
    //boolean begin is used to start the program(game engine) as a loop
    while(begin)
    {
      // prompt user for next action; using scanner to take input
      // goes to entity class to start the game
      System.out.println("Enter Start, Quit, or Top three scores");
      String userInput = scan.nextLine();
      userInput = userInput.toLowerCase();
      if (userInput.equals("start"))
      {
        // completion gets the score from the runGame method
        //score is 0 if the player loses; else it adds the score to scoreboard
        int completion = runGame();
        if(completion == 0){
          System.out.println("The boss beat you! Better luck next time.");
        } else {
          System.out.println("Great job! You beat the boss!");
          scoreboard.addToList(completion);
        }
        //if player selects no, the program stops completely.
        System.out.println("Would you like to keep going?");
        userInput = scan.nextLine();
        if(userInput.equals("no")){
          System.out.println("The program is quitting.");
          break;
        }
      }
      // finds the top 3 and prints top 3 scores from the scoreboard
      else if(userInput.equals("top three scores"))
      {
        scoreboard.findTopThree();
        scoreboard.setScoreboard();
      } else if(userInput.equals("quit")){
        //quitting stops the program completely by breaking the loop.
        System.out.println("The program is quitting.");
        break;
      }
      else
      {
        // prints invalid input and restarts welcome loop 
        System.out.println("Error! Incorrect Input; please try again.");
      }
    }
  }
  //This program runs the game through the player and boss turns
  // until player wins or loses
  //@return: the score of the game as an integer
  public static int runGame(){
    //creates a new player and boss
    boolean victory = false;
    int score = 0;
    Player player = new Player(25);
    Boss boss = new Boss(30);
    while(player.getHealth() > 0 && boss.getHealth() > 0 && !victory){
      player.playerTurn(boss);
      if(boss.getHealth() <= 0){
        victory = true;
        break;
      }
      boss.bossTurn(player);
      System.out.println("Player Health:" + player.getHealth());
      System.out.println("Boss Health:" + boss.getHealth());
    }
    if(victory){
      System.out.println("Final Score: " + player.getCurrentScore());
      score = player.getCurrentScore();
    } else {
      score = 0;
    }
    return score;
  }
}