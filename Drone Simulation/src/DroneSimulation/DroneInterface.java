package DroneSimulation;
import java.awt.Container;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 * Simple program to show arena with multiple drones
* @author shsmchlr
 *
 */
public class DroneInterface {
	
	private Scanner s;								// scanner used for input from user
    private DroneArena myArena;				// arena in which drones are shown
    /**
    	 * constructor for DroneInterface
    	 * sets up scanner used for input and the arena
    	 * then has main loop allowing user to enter commands
     * @throws InterruptedException 
     * @throws FileNotFoundException 
     */
    public DroneInterface() throws InterruptedException, FileNotFoundException {
    	 s = new Scanner(System.in);			// set up scanner for user input
    	 myArena = new DroneArena(10, 10);	// create arena of size 20*6
    	 
        char ch = ' ';
        do {
        	System.out.print("Enter (A)dd drone, get (I)nformation, e(X)it, (D)isplay, (M)ove drones, (N)ew Arena, (L)oad file or (S)ave file >");
        	ch = s.next().charAt(0);
        	s.nextLine();
        	JFileChooser chooseFile;
			JFileChooser chooser = null;
			switch (ch) {
    			case 'A' :
    			case 'a' :
        					myArena.addDrone();	// add a new drone to arena
        					//doDisplay();
        					break;
        		case 'I' :
        		case 'i' :
        					System.out.print(myArena.toString());
            				break;
        		case 'x' : 	ch = 'X';				// when X detected program ends
        					break;
        		case 'D':
        		case 'd':
        			doDisplay();
        			break;
        		case 'M':
        		case 'm':
        			for(int i =0; i <10; i++) { // a for loop to make the drones move one step every 2 sec
        			myArena.moveAllDrones();
        	        doDisplay();
        	        TimeUnit.MILLISECONDS.sleep(200);
        			}
        			
        			break;
        		case 'N':
        		case 'n':
        			System.out.println("enter x for the arena size");
        			myArena.xmax= s.nextInt(); // saves the user input and resize x
        			System.out.println("enter y for the arena size");
        			myArena.ymax = s.nextInt(); // save the user input and resize y
        			
        			break;
        		case 'S':
        		case 's':
        		    StringBuilder sans = new StringBuilder(); // Create StringBuilder
                    sans.append(myArena.xmax + "\n" + myArena.ymax + "\n"); // Appending arenasize
                    ConsoleCanvas c = new ConsoleCanvas(myArena.xmax, myArena.ymax);
              
                    myArena.showDrones(c);
                    File outFile = new File("Arena.txt");
                    try {
                        FileWriter outFileWriter = new FileWriter(outFile); // Creates FileWriter referring to File
                        PrintWriter writer = new PrintWriter(outFileWriter); // Creates printwriter referring to FileWriter
                        writer.println(c.toString()); // Everything collected in toString is written to file.
                        writer.close(); //Closes writer.
                        System.out.println("Successfully written arena details to text file.");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
        		case 'L':
        		case 'l':
        		
        		   	

                    break;
        			
        			
        	}
    		} while (ch != 'X');						// test if end
        
       s.close();									// close scanner
    }
   
    	
    	
    

    
    
    /**
    /**
     * Display the drone arena on the console
     * 
     */
	void doDisplay() {
 	// determine the arena size 
    //  create a suitable sized ConsoleCanvas object
		ConsoleCanvas c = new ConsoleCanvas (myArena.xmax,myArena.ymax);
    // call showDrones suitably
		myArena.showDrones(c);
    // then use the ConsoleCanvas.toString method 
		System.out.print(c.toString());
    }

    
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		DroneInterface r = new DroneInterface(); // just call the interface
		r.doDisplay();
		System.out.println(r);
		
	}

}