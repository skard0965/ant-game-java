/**
 * <h1>Assignment #3 - Objects, simulation, and the harsh reality of survival - COMP 1405/1005</h1>
 *
 * @author Shadi Kardan #100734177
 * @version 1.1, 3-June-2014
 */
package assignment3;

import comp1405lib.BasicIO;

/** The Colony class will maintain an array of worker ants (initially empty with room for 100 ants)
 *  an amount of food (initially 10), and 3 methods: breedWorker(), step(), and purge(). */
public class Colony {
	
	/** array of worker ants */
	public Ant[] workers;
	
	/** Counter of number of workers. */
	public int numWorkers;
	
	/** food amount left in the colony */
	public int foodAmount;
	
	/**Constructor for Colony objects*/
	public Colony() {
		workers = new Ant[100];
		numWorkers = 0;
		foodAmount = 10;
	}

	/** breedWorker() creates a new Ant and adds it to the colony's list of worker ants.
	 * Creating a worker costs 5 of the colony's food. */
	public void breedWorker() {
		BasicIO.println();
		
		if (foodAmount < 5) {
			BasicIO.println("Your colony doesn't have enough food to breed a worker!");
		} else {
			BasicIO.println("Breeding worker...");
			
			// We create a new Ant and we add it to the colony.
			Ant ant = new Ant();
			
			// Ant has been added to the colony
			if (numWorkers < 100) {
				workers[numWorkers] = ant;
				numWorkers++;
				foodAmount = foodAmount - 5;
			} else {
				BasicIO.println("Worker Ants reached the maximum of 100 ants...");
			}
		}
	}
	
	/** step() proceeds the simulation by one turn, and handles the automatic behaviour of the colony.
	 * Namely, this method will control the behaviour of each ant in the colony.
	 * Each turn each ant should eat one food from the colony's food supply.
	 * If there is not enough food, the ant will lose one point of health instead. */
	public void step() { 
		if (numWorkers == 0) {
			BasicIO.println("\nNo worker, nothing to do.");
		}
		else {
			// Each turn each ant should eat one food from the colony's food
			// supply
			for (int i = 0; i < numWorkers; i++) {
				if (null != workers[i]) {
					// We don't want let dead ant to eat food!
					if (workers[i].getHealth() > 0) {
						if (foodAmount > 0) {
							// If there is food, 1 food is taken.
							foodAmount--;
						}
						else {
							// If there isn't food, one health point is taken.
							workers[i].setHealth(workers[i].getHealth() - 1);
						}
					}
				}
			}

			// All dead ants should then be purged from the colony
			purge();
			
			if (numWorkers == 0) {
				BasicIO.println("Last ant just died.");
			} else {
				BasicIO.println("\nStep results:");

				for (int i = 0; i < numWorkers; i++) {
					BasicIO.print("Ant #" + i + " (H: " + workers[i].health + ") ");
					// Lastly, each ant will then forage for food
					workers[i].forage();
					// Any food found will be added back into the colony's food supply.
					foodAmount += workers[i].getFoodFound();
				}

				// We purge the ant that are killed during the forage
				purge();
			}
		}
		BasicIO.println();
		
	}
	
	/** purge() scans the list of worker ants, and any ants with 0 health are removed from the list.
	 * For each dead ant add 1 to the food supply, because ants recycle! */
	public void purge() {
		int deadCount = 0;
		for (int i = 0; i < numWorkers; i++) {
			int antHealth = 0;
			if(null != workers[i]) {
				antHealth = workers[i].getHealth();
			}
			if (antHealth <= 0) {
				deadCount++;			
			} else {
				workers[i-deadCount] = workers[i];
			}
		}
		numWorkers -= deadCount;
		foodAmount += deadCount;
	}
	
	/** menu() is where every turn starts from. */
	public void menu() {
		// Simulation should repeat until the colony is out of both ants and enough food to make more ants.
		while(numWorkers > 0 || foodAmount >= 5) {
			BasicIO.println("=================================================");
			// Each turn the user should be prompted with the current state of the colony (number of ants, and food supply)
			BasicIO.println("Your colony has " + numWorkers + " ant" + " and " + foodAmount + " food" + ", Your Majesty.");
			// A menu should be displayed with two options: to breed a new worker (for a cost of 5 food), or do nothing (no new ants for a cost of 0 food)
			BasicIO.print("What would you like to do?\n0. Do nothing\n1. Breed worker (costs 5 food)\n> ");
			int userOption = BasicIO.readInt();
			if (userOption == 0) { // Do nothing
				step();			
			} else if (userOption == 1) { // Breed Worker
				breedWorker();
				step();
			} else {
				// Your code should check the user's input for errors and ask again if it was invalid.
				BasicIO.println("Invalid input. Please enter either 1 or 0.\n");
			}
		}		
		BasicIO.println("\nThere is not enough food or ant to continue. Game over.");
	}
	
	
    /**
     * The main() method is the starting point for the program.
     *
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		// We instantiate a new colony and call the menu method.
		Colony c = new Colony();
		c.menu();
	}
}
