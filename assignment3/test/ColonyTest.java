/**
 * <h1>Assignment #3 - Objects, simulation, and the harsh reality of survival - COMP 1405/1005</h1>
 *
 * @author Shadi Kardan #100734177
 * @version 1.1, 3-June-2014
 */
package assignment3.test;

import assignment3.Ant;
import assignment3.Colony;
import comp1405lib.BasicIO;


public class ColonyTest {

	/**
	 * Simple method to convert the workers array into a String
	 * 
	 */
	static String workersToString(Colony c) {
		String workersStr = "[ ";
		for (int i = 0; i < c.numWorkers; i++) {
			String antHealth = "null";			
			if (null != c.workers[i]) {
				antHealth = Integer.toString(c.workers[i].getHealth());
			}
			if (i < c.numWorkers -1) {
				workersStr += i + ":" + antHealth + " ";
			} else {
				workersStr += i + ":" + antHealth;
			}
		}		
		workersStr += " ]";
		return workersStr;
	}
	
    /** The main() method is the starting point for the program. */
	public static void main(String[] args) {
		testPurge1();
		testPurge2();
		testStep();
		testTooManyAnts();
		testCannotPlay();
		testLastAntJustDied();
	}
	
	static void testPurge1() {
		BasicIO.println("=== TEST PURGE ===");

		Colony c = new Colony();		
		c.numWorkers = 5;
		c.foodAmount = 0;
		Ant a0 = new Ant();
		a0.setHealth(7);
		c.workers[0] = a0;
		Ant a1 = new Ant();
		a1.setHealth(0);
		c.workers[1] = a1;
		Ant a2 = new Ant();
		a2.setHealth(4);
		c.workers[2] = a2;
		Ant a3 = new Ant();
		a3.setHealth(0);
		c.workers[3] = a3;
		Ant a4 = new Ant();
		a4.setHealth(9);
		c.workers[4] = a4;
		BasicIO.println("Before purge: " + workersToString(c));
		BasicIO.println("foodAmount: " + c.foodAmount);
		BasicIO.println("numWorkers: " + c.numWorkers);
		c.purge();
		BasicIO.println("After purge: " + workersToString(c));
		BasicIO.println("foodAmount: " + c.foodAmount);
		BasicIO.println("numWorkers: " + c.numWorkers);		
	}

	static void testPurge2() {
		BasicIO.println("=== TEST PURGE ===");

		Colony c = new Colony();		
		c.numWorkers = 9;
		c.foodAmount = 0;
		Ant a0 = new Ant();
		a0.setHealth(7);
		c.workers[0] = a0;
		Ant a1 = new Ant();
		a1.setHealth(0);
		c.workers[1] = a1;
		Ant a2 = new Ant();
		a2.setHealth(4);
		c.workers[2] = a2;
		Ant a3 = new Ant();
		a3.setHealth(0);
		c.workers[3] = a3;
		Ant a4 = new Ant();
		a4.setHealth(9);
		c.workers[4] = null;
		Ant a5 = new Ant();
		a5.setHealth(9);
		c.workers[5] = a5;
		Ant a6 = new Ant();
		a6.setHealth(0);
		c.workers[6] = a6;
		Ant a7 = new Ant();
		a7.setHealth(1);
		c.workers[7] = null;
		Ant a8 = new Ant();
		a8.setHealth(3);
		c.workers[8] = a8;
		BasicIO.println("Before purge: " + workersToString(c));
		BasicIO.println("foodAmount: " + c.foodAmount);
		BasicIO.println("numWorkers: " + c.numWorkers);
		c.purge();
		BasicIO.println("After purge: " + workersToString(c));
		BasicIO.println("foodAmount: " + c.foodAmount);
		BasicIO.println("numWorkers: " + c.numWorkers);		
	}
	
	static void testStep() {
		BasicIO.println("=== TEST STEP ===");
		Colony c = new Colony();		
		Ant a0, a1, a2, a3, a4;
		c.numWorkers = 5;
		c.foodAmount = 0;
		a0 = new Ant();
		a0.setHealth(7);
		c.workers[0] = a0;
		a1 = new Ant();
		a1.setHealth(0);
		c.workers[1] = a1;
		a2 = new Ant();
		a2.setHealth(4);
		c.workers[2] = a2;
		a3 = new Ant();
		a3.setHealth(0);
		c.workers[3] = a3;
		a4 = new Ant();
		a4.setHealth(9);
		c.workers[4] = a4;
		
		BasicIO.println("Before step: " + workersToString(c));
		BasicIO.println("foodAmount: " + c.foodAmount);
		BasicIO.println("numWorkers: " + c.numWorkers);
		
		c.step();
		
		BasicIO.println("After step: " + workersToString(c));
		BasicIO.println("foodAmount: " + c.foodAmount);
		BasicIO.println("numWorkers: " + c.numWorkers);		
		
	}
		
	static void testTooManyAnts() {
		BasicIO.println("=== TEST TOO MANY ANTS FOR BREEDING WORKER ===");
		Colony c = new Colony();
		c.numWorkers = 100;		
		c.breedWorker();		
	}
	
	static void testCannotPlay() {
		BasicIO.println("=== TEST CANNOT PLAY ===");
		Colony c = new Colony();
		c.numWorkers = 0;
		c.foodAmount = 4;
		c.menu();		
	}
	
	static void testLastAntJustDied() { 
		BasicIO.println("=== TEST LAST ANT JUST DIED ===");
		Colony c = new Colony();
		Ant a = new Ant();
		a.health = 1;
		c.workers[0] = a;
		c.numWorkers = 1;
		c.foodAmount = 0;
		c.step();		
	}

}
