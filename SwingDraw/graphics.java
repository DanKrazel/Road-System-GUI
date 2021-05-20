package SwingDraw;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.ArrayList;
import java.util.List;

import components.Driving;
import components.Junction;
import components.LightedJunction;
import components.Road;
import components.Vehicle;

public class graphics extends Canvas{
	
	private ArrayList<Junction> junction;
	private ArrayList<Vehicle> vehicles;
	private ArrayList<LightedJunction> LightedJunc;
	private ArrayList<Road> roads;
	private Driving driving;
	private drawVehicle drawVehicle;
	
	public graphics(int numOfJunction,int numOfVehicles) {
		junction=new ArrayList<Junction>();
		vehicles=new ArrayList<Vehicle>();
		roads=new ArrayList<Road>();
		driving=new Driving(numOfJunction,numOfVehicles);
		junction=driving.getMap().getJunctions();
		vehicles=driving.getVehicles();
		roads=driving.getMap().getRoads();
		//drawVehicle=new drawVehicle();
					
		}
			
	public void paint(Graphics g) {
		//g.fillOval(10,10,10,10);
			Graphics2D g1= (Graphics2D)g;
			for(int i=0;i<junction.size();i++) {
				if (junction.get(i) instanceof LightedJunction) {
					if(((LightedJunction) junction.get(i)).getLights().getTrafficLightsOn()==true) {
						g1.fill(new Ellipse2D.Double(junction.get(i).getX(),junction.get(i).getY(),20,20));
						g1.setColor(Color.RED);
					}
					else {
					g1.fill(new Ellipse2D.Double(junction.get(i).getX(),junction.get(i).getY(),20,20));
					g1.setColor(Color.GREEN);
					}
				}
				else {
					g1.fill(new Ellipse2D.Double(junction.get(i).getX(),junction.get(i).getY(),20,20));
					g1.setColor(Color.BLACK);
					}
			}
			for(int i=0;i<junction.size();i++) {
				for(int j=0;j<junction.size();j++) {
					if(i!=j) {
						g1.setColor(Color.BLACK);
						g1.draw(new Line2D.Double(junction.get(i).getX()+10,
						junction.get(i).getY()+10,junction.get(j).getX()+10,junction.get(j).getY()+10));
					}
				}
			}
			/*for(int i=0;i<vehicles.size();i++) {
				drawVehicle=new drawVehicle(g1,vehicles.get(i));
			}*/
			drawVehicle=new drawVehicle(this);
			//drawVehicle.paintComponent(g1);
			drawVehicle.paint(g1);
			
		}
	
		  
	public drawVehicle getDrawVehicle() {
		return drawVehicle;
	}
		


	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}


	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


	public ArrayList<LightedJunction> getLightedJunc() {
		return LightedJunc;
	}


	public void setLightedJunc(ArrayList<LightedJunction> lightedJunc) {
		LightedJunc = lightedJunc;
	}


	public ArrayList<Road> getRoads() {
		return roads;
	}


	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}
	
	public static void main(String[]arg) {
		JFrame f=new JFrame();
		graphics g=new graphics(10,5);
		g.setBounds(10, 10, 766, 704);
		f.add(g);
		f.setSize(800,800);
		f.setVisible(true);
		
	}	
	
	
	
	
	
	
	/*public void paint(Graphics g) {
		//super.paint(g);
		Graphics2D g1=(Graphics2D)g;
		for(int i=0;i<roads.size();i++) {
			if(roads.get(i).getStartJunction() instanceof LightedJunction) { 
				if(((LightedJunction) roads.get(i).getStartJunction()).getLights().getTrafficLightsOn()) {
					g1.setColor(Color.RED);
					g1.fill(new Ellipse2D.Double(roads.get(i).getStartJunction().getX(),
							roads.get(i).getStartJunction().getY(), 20, 20));
				}
				else {
					g1.setColor(Color.GREEN);
					g1.fill(new Ellipse2D.Double(roads.get(i).getStartJunction().getX(),
							roads.get(i).getStartJunction().getY(), 20, 20));
				}
			}
			else
			{
				g1.fill(new Ellipse2D.Double(roads.get(i).getStartJunction().getX(),
						roads.get(i).getStartJunction().getY(), 20, 20));
			}
			
			
			
			if(roads.get(i).getEndJunction() instanceof LightedJunction) {
				if(((LightedJunction) roads.get(i).getEndJunction()).getLights().getTrafficLightsOn()) {
					g1.setColor(Color.RED);
					g1.fill(new Ellipse2D.Double(roads.get(i).getEndJunction().getX(),
							roads.get(i).getEndJunction().getY(), 20, 20));
				}
				else {
					g1.setColor(Color.GREEN);
					g1.fill(new Ellipse2D.Double(roads.get(i).getEndJunction().getX(),
							roads.get(i).getEndJunction().getY(), 20, 20));
				}
			}
			else
			{
				g1.fill(new Ellipse2D.Double(roads.get(i).getEndJunction().getX(),
						roads.get(i).getEndJunction().getY(), 20, 20));
			}
			
			g1.setColor(Color.BLACK);
			g.drawLine((int)(roads.get(i).getStartJunction().getX()), (int)(roads.get(i).getStartJunction().getY()),
					(int)(roads.get(i).getEndJunction().getX()), (int)(roads.get(i).getEndJunction().getY()));
			g.drawLine((int)(roads.get(i).getEndJunction().getX()), (int)(roads.get(i).getEndJunction().getY())
					,(int)(roads.get(i+1).getStartJunction().getX()), (int)(roads.get(i+1).getStartJunction().getY()));
			g1.draw(new Line2D.Double(roads.get(i).getStartJunction().getX()+10,
					roads.get(i).getStartJunction().getY()+10,
					roads.get(i).getEndJunction().getX()+10,
					roads.get(i).getEndJunction().getY()+10));
			
		}
		
		for(int i=0;i<vehicles.size();i++) {
			drawRotatedVehicle(g,(int)vehicles.get(i).getLastRoad().getStartJunction().getX()+10,
					(int)vehicles.get(i).getLastRoad().getStartJunction().getY()+10,
					(int)vehicles.get(i).getLastRoad().getEndJunction().getX()+10,
					(int)vehicles.get(i).getLastRoad().getStartJunction().getY()+10,10,4);
		}
		
		
		
	}*/




	/*public void checkStartJunction(Graphics g1,int i) {
		Graphics2D g2=(Graphics2D)g1;
		if(roads.get(i).getStartJunction() instanceof LightedJunction) {
			//if(((LightedJunction) junction.get(i)).getLights().getTrafficLightsOn()) {
			if(((LightedJunction) roads.get(i).getStartJunction()).getLights().getTrafficLightsOn()) {
				g2.setColor(Color.RED);
				//g.fillOval((int)(junction.get(i).getX()),(int)(junction.get(i).getY()), 20, 20);
				g2.fill(new Ellipse2D.Double(roads.get(i).getStartJunction().getX(),
						roads.get(i).getStartJunction().getY(), 20, 20));
			}
			else {
				g2.setColor(Color.GREEN);
				//g.fillOval((int)(junction.get(i).getX()),(int)(junction.get(i).getY()), 20, 20);
				g2.fill(new Ellipse2D.Double(roads.get(i).getStartJunction().getX(),
						roads.get(i).getStartJunction().getY(), 20, 20));
			}
		}
		else
		{
			//g.fillOval((int)(junction.get(i).getX()),(int)(junction.get(i).getY()), 20, 20);
			g2.fill(new Ellipse2D.Double(roads.get(i).getStartJunction().getX(),
					roads.get(i).getStartJunction().getY(), 20, 20));
		}
	}
	
	public void checkEndJunction(Graphics g1,int i) {
		Graphics2D g2=(Graphics2D)g1;
		if(roads.get(i).getEndJunction() instanceof LightedJunction) {
			//if(((LightedJunction) junction.get(i)).getLights().getTrafficLightsOn()) {
			if(((LightedJunction) roads.get(i).getEndJunction()).getLights().getTrafficLightsOn()) {
				g2.setColor(Color.RED);
				//g.fillOval((int)(junction.get(i).getX()),(int)(junction.get(i).getY()), 20, 20);
				g2.fill(new Ellipse2D.Double(roads.get(i).getEndJunction().getX(),
						roads.get(i).getEndJunction().getY(), 20, 20));
			}
			else {
				g2.setColor(Color.GREEN);
				//g.fillOval((int)(junction.get(i).getX()),(int)(junction.get(i).getY()), 20, 20);
				g2.fill(new Ellipse2D.Double(roads.get(i).getEndJunction().getX(),
						roads.get(i).getEndJunction().getY(), 20, 20));
			}
		}
		else
		{
			//g.fillOval((int)(junction.get(i).getX()),(int)(junction.get(i).getY()), 20, 20);
			g2.fill(new Ellipse2D.Double(roads.get(i).getEndJunction().getX(),
					roads.get(i).getEndJunction().getY(), 20, 20));
		}
	}*/
	 
	/*public static void main(String[]args) {
		graphics m=new graphics(10,3);
	    JFrame f=new JFrame(); 
	    f.add(m);
	    f.setSize(1000,1000);  
	    f.setVisible(true);
	}*/

			
			
	
}
