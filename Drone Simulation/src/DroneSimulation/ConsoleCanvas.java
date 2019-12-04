package DroneSimulation;




/**the class that display the arena
 * */
public class ConsoleCanvas {
private String [][] canvas; // the 2d array to create the arena 
private int height, width; // the sizes of the arena 

/**the constructor of the class to create the arena
 * h: is the height of the arena
 * w: is the width of the arena*/
public ConsoleCanvas(int h, int w){
height = h; //height of the arena
width = w; // width of the arena
canvas = new String [h][w]; // this 2d array to store the height and widths of the arena as spaces and #
int i;
int j;
for ( i=0; i < height; i++) {  // a nested for loop to create the height and the width of the arena
	
	for( j=0; j< width; j++) {
		if(i==0 || i==height-1 || j==0|| j==width-1) {
			canvas[i][j] = "#"; // the border of the arena
		}
		else {
			canvas[i][j] = " "; // the inside of the arena
		}
	
			}
		}
	}
/**this method is to show the drone inside the arena
 * x: the horizontal position of the drone
 * y: the vertical position of the drone
 * z: the Symbol of the drone which is represented by D
 * */
public void showIt(int x, int y, Character z) {
	
 canvas[x][y]= z.toString(); // the inputs of the drone in the canvas
}
public String toString() {       // this method to return the canvas 2d array when we run the program
	String res = "the Arena"+"\n";	
	
	 for (int i=0; i <height; i++) {
		 
	    	for(int j=0; j<width; j++) 
	    		
	    	res= res +canvas[i] [j];
	    	
	    	res = res + "\n";
	    	
	    	}
	 
	 return res;
}
public static void main(String[] args) {
	ConsoleCanvas c = new ConsoleCanvas (20,20);	// create a canvas
	c.showIt(4,3,'D');								// add a Drone at 4,3
	System.out.println(c.toString());	



}}
