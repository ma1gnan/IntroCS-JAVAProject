import java.util.Scanner;
// This program deals players turn
public class Player extends Entity
{
  
  private int currentScore;
  /**
    This program calls the entity constructor to access the health variable
    @param pHealth sets player health
  */
  public Player(int pHealth){// default constructor: pHealth = 25
    super(pHealth);
    currentScore = 0;
  }
  /**
    This program starts the player turn or catches the illegal exception
    Error handling
  */
  public void playerTurn(Boss boss){
    //the program continues to catch an exception until the input is correct
    while(true){
      try{
        String option = playerturnStart();
        playerChoice(option, boss);
        break;
      } catch(IllegalArgumentException e){
        //Illegal argument exception is unchecked
        System.out.println(e);
      }
    }
  }
  /**
    Displays the players choices; takes input with scanner
    @return string output: the players choice
  */
  public String playerturnStart(){
    Scanner play = new Scanner(System.in);
    System.out.println("Player's turn:");
    System.out.println("Choose your attack:");
    System.out.println("sword: deals 5 damage (needs to roll 2 or higher)(10 points)");
    System.out.println("bow: deals 10 damage (needs to roll 4 or higher)(20 points)");
    System.out.println("lightning: deals 20 damage (needs to roll 6 or higher)(50 points)");
    System.out.println("fire: deals 30 damage (needs to roll 8 or higher)(100 points)");
    return play.next();
  }
  // playerTurnstart, playerchoice, throws illegal argument exception
  public void playerChoice(String choice, Boss boss){
    if(choice.equals("sword")){
      useSword(boss);
    } else if(choice.equals("bow")){
      useBow(boss);
    } else if(choice.equals("lightning")){
      useLightning(boss);
    } else if(choice.equals("fire")){
      useFire(boss);
    } else {
      throw new IllegalArgumentException("Doesn't have correct input");
    }
  }
  /**
    This program deals the sword attack if the dice roll is greater than or equal to 2
    the boss takes 5 damage to its health and the player gains 10 points 
    @param boss calls the boss class to update the health
  */
  public void useSword(Boss boss){
    System.out.println("Player chose sword!");
    int rand = (int) (Math.random() * (12)) + 1;
    if(rand >= 2){
        System.out.println("The attack hits! You gain 10 points!");
        System.out.println("------------------------------------");
        boss.takeDamage(5);
        addPoints(10);
    } else {
      System.out.println("Attack misses! No points given.");
      System.out.println("-------------------------------");
    }
  }
  /**
    This program deals the bow attack if the dice roll is greater than or equal to 4
    the boss takes 10 damage to its health and the player gains 20 points
    @param boss calls the boss class to update the health
  */
  public void useBow(Boss boss){
    System.out.println("Player chose bow!");
    int rand = (int) (Math.random() * (12)) + 1;
    if(rand >= 4){
        System.out.println("The attack hits! You gain 20 points!");
        System.out.println("------------------------------------");
        boss.takeDamage(10);
        addPoints(20);
    } else {
      System.out.println("Attack misses! No points given.");
      System.out.println("-------------------------------");
    }
  }
  /**
    This program deals the lightning attack if the dice roll is greater than or equal to 6
    the boss takes 20 damage to its health and the player gains 50 points
    @param boss calls the boss class to update the health
  */
  public void useLightning(Boss boss){
    System.out.println("Player chose lightning!");
    int rand = (int) (Math.random() * (12)) + 1;
    if(rand >= 6){
        System.out.println("The attack hits! You gain 50 points!");
        System.out.println("------------------------------------");
        boss.takeDamage(20);
        addPoints(50);
    } else {
      System.out.println("Attack misses! No points given.");
      System.out.println("-------------------------------");
    }
  }
  /**
    This program deals the fire attack if the dice roll is greater than or equal to 8
    the boss takes 30 damage to its health and the player gains 100 points
    @param boss calls the boss class to update the health
  */
  public void useFire(Boss boss){
    System.out.println("Player chose fire!");
    int rand = (int) (Math.random() * (12)) + 1;
    if(rand >= 8){
        System.out.println("The attack hits! You gain 100 points!");
        System.out.println("-------------------------------------");
        boss.takeDamage(30);
        addPoints(100);
    } else {
      System.out.println("Attack misses! No points given.");
      System.out.println("-------------------------------");
    }
  }
  /**
    This program updates the players point 
    @param points the points the player has
  */
  public void addPoints(int points){
    currentScore += points;
  }
  /**
    This program returns the current score
    @return currentScore returns the current score
  */
  public int getCurrentScore(){
    return currentScore;
  }
  
}