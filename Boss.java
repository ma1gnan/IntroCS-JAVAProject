/**
  This program deals the boss turn 
*/
public class Boss extends Entity
{
  //the entity constructor is called to give Boss access to the health variable; bHealth sets the boss health
  public Boss(int bHealth){ // default constructor: bHealth = 30
    super(bHealth);
  }
  /**
    this program determines the boss attach using 6 sided die
    @param player 
  */
  public void bossTurn(Player player){
    int bossDice = (int) (Math.random() * 6) + 1;
    if(bossDice == 1){
      System.out.println("Boss attack missed!");
    } else if(bossDice == 2 || bossDice == 3){
      System.out.println("Boss used death slash for 5 damage.");
      player.takeDamage(5);
    } else if(bossDice == 4 || bossDice == 5){
      System.out.println("Boss used death slash for 10 damage.");
      player.takeDamage(10);
    } else if(bossDice == 6){
      System.out.println("Boss used death slash for 15 damage.");
      player.takeDamage(15);
    }
  }
  
}