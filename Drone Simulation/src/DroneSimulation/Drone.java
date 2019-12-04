package DroneSimulation;

import java.util.Random;
/**this class will create the Drones 
 * */
public class Drone {
	public int x, y;
	private int droneId, dx, dy; // x and y will be the positions of the drone and the dx and dy are the difference in the new positions
	private Direction z; // a variable to be used to show direction for each drone randomly
	public static int droneNum = 0; // the number for each different drone
 
	public Drone(int bx, int by) { // another constructor to initialise new arguments in the main constructor 
		this(bx, by, Direction.North);
	}
/** bx: is the horizontal position for the drone
 * by: is the vertical position for the drone
 * bz: the direction from the direction class
 * */
public Drone(int bx, int by, Direction bz) {
	// initialise variables from the class to be used in the constructor
	x = bx;
	y = by;
	droneId = droneNum++;  // increasing the number each time a drone is added
	dx = 1; // the movement of the drone in the horizontal line
	dy = 1; // the movement of the drone in the vertical line
	z = bz;
	
}

/**sx: to see if x has this position already
 * sy: to see if y has this position already
 * */
public boolean isHere(int sx, int sy) {  // this method to check if sx and sy in the same positions as x and y
	if ((x == sx) && (y == sy)) {
		return true;  // if it is not it returns true
	
	} else {
		return false; // otherwise it return false
	}

}
/**nx: setting the x 
 * ny: setting the y
 * */
public void setXY(int nx, int ny) { 
	x = nx;
	y = ny;
}
/** This method to be used in DroneArena class
 * in Show drones method using ConsoleCanvas object c
 */
public void displayDrone(ConsoleCanvas c) { 
c.showIt(x, y, 'D'); // using the showIt method in console Canvas class to show the place of the drone within the arena as D

}

/**a method to move drones in the same direction that 
 * they assigned too and to check if the the moving possible, using a DroneArena Object area*/
boolean tryToMove(DroneArena area){
    int nx = x;
    int ny = y;

    //puts the drone in next position
    if(z == Direction.North){
    	nx = x - dx;
    }else if(z == Direction.East){
    	ny= y +dy;
    }else if(z == Direction.South){
    	nx = x + dx;
    }else if(z == Direction.West){
    	ny = y-dy;
    }

    //looks to see if drone can be moved here
    if(area.canMoveHere(nx, ny)){
        //moves drone to new position
        x = nx;
        y = ny;
        return true;
    }else{
        //if drone can not be moved, turn the direction round one
        z = z.next(z);
        return false;
    }
}
/**returning the output of the program to string in the console
 * */
public String toString() {
	
	return "Drone "+ droneId + " at "+ x +", "+ y + " at direction " + z ;
	
	
}
public static void main(String[] args) {
	Drone d = new Drone(5, 3, Direction.East);		// create drone
	System.out.println(d.toString());	// print where is
	
	
	
}
}
