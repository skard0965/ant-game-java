/**
 * <h1>Assignment #3 - Objects, simulation, and the harsh reality of survival - COMP 1405/1005</h1>
 *
 * @author Shadi Kardan #100734177
 * @version 1.1, 3-June-2014
 */
package assignment3.test;

import assignment3.Ant;

public class AntTest {

     /** The main() method is the starting point for the program.*/
	public static void main(String[] args) {
		testForage();
	}
	
	static void testForage() {
		System.out.println("==================    TEST FORAGE    ===========================");		
		for (int i = 0; i < 100; i++) {
			Ant a = new Ant();	
			System.out.print("Ant ");
			a.forage();
			System.out.println("health: " + a.health);
			System.out.println("foodFound: " + a.foodFound);
			System.out.println("----------------------------------------------------------------");
		}
	}
}
