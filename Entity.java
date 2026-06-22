/**
    This program is the superclass for the player and boss class.
    It holds the health variable and the damage method.
*/
public class Entity
{
  private int health;

  public Entity(int h){ // default constructor
    health = h;
  }
  /** 
    This program gets the health of the entity
    @return health returns the health value
  */
  public int getHealth(){
    return health;
  }
// This program allows entities to take damage
  public void takeDamage(int damage){
    health -= damage;
  }
  //Both getHealth and takeDamage are both public, giving the player and the boss access to these methods.
}