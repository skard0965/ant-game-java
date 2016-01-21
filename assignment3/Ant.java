/**
 * <h1>Assignment #3 - Objects, simulation, and the harsh reality of survival - COMP 1405/1005</h1>
 *
 * @author Shadi Kardan #100734177
 * @version 1.1, 3-June-2014
 */
package assignment3;

import comp1405lib.BasicIO;

/** This class represents an ant in the colony. */
public class Ant {
	
	public int health;
	public int foodFound;
	
	/** Constructor for Ant objects */
	public Ant() {
		// Every ant starts with 10 health points.
		health = 10;
		// foodFound will be incremented at every step.
		foodFound = 0;
	}
	
	/** forage() determines randomly the luck an ant has while out searching for food each turn. */
	public void forage() {
		if (health>0) {
			double random = Math.random();
			// There is a 10% chance that the ant dies in a horrible accident (health = 0, return no food)
			if (random < 0.10) {
				health = 0;
				BasicIO.print("died in a horrible accident.\n");
			}
			// There is a 35% chance that the ant finds food. The amount found should be a random number between 1 and 5.
			else if (random < 0.45) {
				foodFound = (int) (Math.random() * 5 + 1);
				BasicIO.print("finds " + foodFound + " food!\n");
			}
			// There is a 50% chance that the ant finds no food.
			else if (random < 0.95) {
				BasicIO.print("returns empty handed.\n");
			}
			// And there is a 5% chance that the and finds sweet nectar! 
			// Her health is replenished (i.e., set to 10) and she brings back 10 food to the colony!
			else {
				health = 10;
				foodFound = 10;
				BasicIO.print("found sweet nectar! Health is now " + health + " and ant found " + foodFound + " foods! \n");
			}
		} else {
			BasicIO.print("is dead and will be purged.\n");
		}
	}
	
	/** Get health from a specific ant. */
	public int getHealth() {
		return health;
	}
	
	/** Set health from a specific ant. */
	public void setHealth(int health) {
		this.health = health;
	}

	/**	getFoodFound returns the food found for each step and then is reinitialized to 0. */
	public int getFoodFound() {
		int food = foodFound;
		foodFound = 0;
		return food;
	}
}
