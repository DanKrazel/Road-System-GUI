package SwingDraw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import components.Vehicle;

public class drawVehicle extends Canvas{
	private ArrayList<Vehicle> vehicles;
	private graphics graph;
	
	public drawVehicle(graphics g) {
		vehicles = new ArrayList<Vehicle>();
		this.graph=g;
		for(int i=0;i<graph.getVehicles().size();i++) 
			vehicles.add(graph.getVehicles().get(i));
		}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		//vehicles = new ArrayList<Vehicle>();
		for(int i=0;i<graph.getVehicles().size();i++) {
			//System.out.println("test");
			//vehicles.add(graph.getVehicles().get(i));
			drawRotatedVehicle(g,(int)graph.getVehicles().get(i).getLastRoad().getStartJunction().getX()+10,
				(int)graph.getVehicles().get(i).getLastRoad().getStartJunction().getY()+10,
				(int)graph.getVehicles().get(i).getLastRoad().getEndJunction().getX()+10, 
				(int)graph.getVehicles().get(i).getLastRoad().getEndJunction().getY()+10,10,4);
		}
	}
	

	/*public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//vehicles = new ArrayList<Vehicle>();
		for(int i=0;i<graph.getVehicles().size();i++) {
			System.out.println("test");
			//vehicles.add(graph.getVehicles().get(i));
			drawRotatedVehicle(g,(int)graph.getVehicles().get(i).getLastRoad().getStartJunction().getX()+10,
				(int)graph.getVehicles().get(i).getLastRoad().getStartJunction().getY()+10,
				(int)graph.getVehicles().get(i).getLastRoad().getEndJunction().getX()+10, 
				(int)graph.getVehicles().get(i).getLastRoad().getEndJunction().getY()+10,10,4);
		}
	}*/
	
	private void drawRotatedVehicle(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
	    int dx = x2 - x1, dy = y2 - y1, delta = 10;
	    double D = Math.sqrt(dx*dx + dy*dy);
	    double xm = delta, xn = xm, ym = h, yn = -h, x;
	    double xm1 = delta + d, xn1 = xm1, ym1 = h, yn1 = -h, xx; 
	    double sin = dy / D, cos = dx / D;
	    x = xm*cos - ym*sin + x1;
	    xx = xm1*cos - ym1*sin + x1;
	    ym = xm*sin + ym*cos + y1;
	    ym1 = xm1*sin + ym1*cos + y1;
	    xm = x;
	    xm1 = xx; 
	    x = xn*cos - yn*sin + x1;
	    xx = xn1*cos - yn1*sin + x1; 
	    yn = xn*sin + yn*cos + y1;
	    yn1 = xn1*sin + yn1*cos + y1;
	    xn = x;
	    xn1 = xx;
	    int[] xpoints = {(int) xm1, (int) xn1,  (int) xn, (int) xm};
	    int[] ypoints = {(int) ym1, (int) yn1, (int) yn, (int) ym};
	    g.fillPolygon(xpoints, ypoints, 4);
	    g.setColor(Color.BLACK);
	    g.fillOval((int) xm1-2,(int) ym1-2,4,4);
	    g.fillOval((int) xn1-2,(int) yn1-2,4,4);
	    g.fillOval((int) xm-2,(int) ym-2,4,4);
	    g.fillOval((int) xn-2,(int) yn-2,4,4);
	    
	}
	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	public graphics getGraph() {
		return graph;
	}
	/*public void update(Vehicle vehicle) {
		double x=0,y=0;
		double xStart=vehicle.getLastRoad().getStartJunction().getX();
		double yStart=vehicle.getLastRoad().getStartJunction().getY();
		double xEnd=vehicle.getLastRoad().getEndJunction().getX();
		double yEnd=vehicle.getLastRoad().getEndJunction().getY();
		for(int i=0;i<10;i++) {
			if (xStart <= xEnd) {
				xStart += 10;
				//y += 10;
			this.repaint();
			}	
		}
	}*/

}
	
	

