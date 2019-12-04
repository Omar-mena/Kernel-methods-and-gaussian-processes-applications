package droneSimulationGUI;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

/**
 * a class to create the size of the arena
 */
public class DroneArena {
	public int xmax, ymax; // define the arena size
	private Drone b; // a drone object from the drone class
	private Random a;// a variable to generate a random number
	public ArrayList<Drone> manyDrones;// an array list to store all drones

	/**
	 * the constructor for the class x: the size of the horizontal line y: the size
	 * of the vertical line
	 */
	public DroneArena(int x, int y) {
		xmax = x;// initialise variables from the class to be used in the constructor
		ymax = y;
		a = new Random(); // the variable to generate a random number
		manyDrones = new ArrayList<Drone>(); // an array list to store all drones

	}

	/**
	 * a method to add a new drone to the array list manyDrones
	 */
	public void addDrone() {
		int a1; // a the x random variable
		int a2; // a the y random variable
		Direction z = Direction.getRandomDirection(); // the direction variable that specify the direction of the drone

		do { // a do while loop that adds drones in a random positions
			a1 = a.nextInt(xmax - 1);
			a2 = a.nextInt(ymax - 1);
		} while ((getDroneAt(a1, a2) != null) || (a1 == 0) || (a1 == xmax - 1) || (a2 == 0) || (a2 == ymax - 1)); // this
																													// condition
																													// make
																													// sure
																													// the
																													// drone
																													// positions
																													// are
																													// within
																													// the
																													// arena

		b = new Drone(a1, a2, z); // creating the new drone
		manyDrones.add(b); // adding the new drone in the array list
	}

	/**
	 * a method to check if the positions of the new drones that will be added wont
	 * be the same as the old drones x: the horizontal position y: the vertical
	 * position
	 */
	public Drone getDroneAt(int x, int y) {
		Drone AB = null; // Initialising the Drone to null

		for (Drone b : manyDrones) { // checking all the drones positions inside manyDrones

			if (b.isHere(x, y) == true) { // using the isHere method to check the positions are not taken
				AB = b;
			}
		}
		if (AB == null) {
			return null;
		}

		else {
			return AB;
		}

	}

	/**
	 * the method that moves all the drones in their direction
	 */
	void moveAllDrones() {
		for (int i = 0; i < manyDrones.size(); i++) { // a for loop to go through each drone in the array list and move
														// it using the tryToMove method
			manyDrones.get(i).tryToMove(this);
		}
	}

	/**
	 * a method to show the drones using displayDrone method and the input would be
	 * a ConsoleCanvas object c
	 */
	public void showDrones(MyCanvas c) {
		for (int i = 0; i < manyDrones.size(); i++) { // a for loop to go through each drone in the array list and
														// display it
			manyDrones.get(i).displayDrone(c);
		}
	}

	/**
	 * a method to check if the drone can move to the next position using getDroneAt
	 * method x: the horizontal position y: the vertical position
	 */
	public boolean canMoveHere(int x, int y) {
		if (x < this.xmax - 1 && y < this.ymax - 1 && x != 0 && y != 0 && getDroneAt(x, y) == null) { // if within the
																										// border of the
																										// arena and no
																										// drone is
																										// there
			return true;
		} else {
			return false;
		}
	}

	/**
	 * returning the output of the program to string in the console
	 */
	public String toString() {
		String s = "The size of the Arena is " + xmax + " by " + ymax + " whith " + "\n";
		for (int i = 0; i < manyDrones.size(); i++) { // a for loop to output every drone inside the array list
			s = s + "\n" + manyDrones.get(i) + "\n";

		}
		return s;
	}

	static public void main(String[] args) {
		DroneArena a = new DroneArena(21, 9); // create drone arena
		a.addDrone();
		for (int ct = 0; ct < 3; ct++) {

			a.moveAllDrones();

			System.out.println(a.toString());
		}

	}
}
