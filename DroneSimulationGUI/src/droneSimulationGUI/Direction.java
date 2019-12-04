package droneSimulationGUI;

import java.util.Random;
/**enum class to create the
 *  directions for the drones*/
public enum Direction { 
		    North,
		    East,
		    South,
	        West;
	/**this method to get the next direction
	 * if the drone can't move to its previous direction*/
public static Direction getRandomDirection() {
	            Random random = new Random(); // random variable for the directions
	            return values()[random.nextInt(values().length)];
	        }
		   //moves clockwise to next direction
		    public Direction next(Direction direction) {
		        if(direction == Direction.North){
		            direction = Direction.East;
		        }else  if(direction == Direction.East){
		            direction = Direction.South;
		        }else if(direction == Direction.South){
		            direction = Direction.West;
		        }else {
		            direction = Direction.North;
		        }

		        return direction;
		    }
	      public static void main(String[] args) {
	    	  
	    	   for (int i = 0; i < 10; i++) {
	               System.out.printf("Direction[%d] = %s%n", i, 
	                       Direction.getRandomDirection());
	            }
	    	      	   
	    	   System.out.println(getRandomDirection());
	      }
	    }
	

