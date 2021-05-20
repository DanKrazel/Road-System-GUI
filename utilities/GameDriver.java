/**
 * 
 */
package utilities;

import javax.swing.JFrame;

import SwingDraw.graphics;
import components.Driving;

/**
 * @author Sophie Krimberg
 *
 */
public class GameDriver {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Driving driving=new Driving(10, 20);
		driving.drive(20);
	}

}
