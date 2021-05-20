package SwingDraw;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.*;
import components.Vehicle;

public class moveVehicle implements Runnable{//implements Runnable {
	private Thread myThread;
	private drawVehicle drawVeh;
	private Vehicle vehicle;
	private graphics g;
	private boolean suspended;
	double x_coord;
	double y_coord;
	private int speed,
       x_flag, y_flag, size;


	
	public moveVehicle(graphics g){
		//this.drawVeh=drawVeh;
		size=4;
		this.g=g;
		myThread=new Thread(this);
		myThread.start();
	}
	/*public void start()
	{
		Thread th = new Thread (this);
		th.start();
	}
	public void destroy() {
		
	}*/
	synchronized public void start() {
		suspended = false;
		notify();
	}
	
	synchronized public void  stop() {
	    suspended = true;
	}
	
	public void run() {
        Thread me = Thread.currentThread();
        while (myThread == me) 
        {
            synchronized(this) {
            while(suspended) {
               try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
            }
			//System.out.println(g.getDrawVehicle().getGraph().getVehicles().get(0).getLastRoad().getStartJunction()
					 // .getX());
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
	             e.printStackTrace();
		     }
			update();
			g.getDrawVehicle().repaint();	
        }
	}
	
            
		
	  public void update() 
	    { 
		  /*for(int i=0;i< g.getDrawVehicle().getVehicles().size();i++) {
			  System.out.println(g.getDrawVehicle().getVehicles().get(i).getLastRoad().getStartJunction()
					  .getX());
			  g.getDrawVehicle().getVehicles().get(i).getLastRoad().getStartJunction()
			  .setX((int)g.getDrawVehicle().getVehicles().get(i).getLastRoad().getStartJunction().getX()+10);
			  g.getDrawVehicle().getVehicles().get(i).getLastRoad().getStartJunction()
		  .setY((int)g.getDrawVehicle().getVehicles().get(i).getLastRoad().getStartJunction().getY()+10);
			  
			  g.getDrawVehicle().getVehicles().get(i).getLastRoad().getEndJunction()
			  .setX((int)g.getDrawVehicle().getVehicles().get(i).getLastRoad().getEndJunction().getX()+10);
			  g.getDrawVehicle().getVehicles().get(i).getLastRoad().getEndJunction()
		  .setY((int)g.getDrawVehicle().getVehicles().get(i).getLastRoad().getEndJunction().getY()+10);
		  }*/
		  	for(int i=0;i<g.getDrawVehicle().getVehicles().size();i++) {
		  	  double x=0;
			  while(x<g.getDrawVehicle().getVehicles().get(0).getLastRoad().getLength()) {
			  g.getDrawVehicle().getVehicles().get(0).getLastRoad().getStartJunction()
			  .setX((int)g.getDrawVehicle().getVehicles().get(0).getLastRoad().getStartJunction().getX()+
					  (int)(g.getDrawVehicle().getVehicles().get(0).getLastRoad().getLength()/10));
			  g.getDrawVehicle().getVehicles().get(0).getLastRoad().getStartJunction()
			  .setY((int)g.getDrawVehicle().getVehicles().get(0).getLastRoad().getStartJunction().getX()+
					  (int)(g.getDrawVehicle().getVehicles().get(0).getLastRoad().getLength()/10));
			  g.getDrawVehicle().getVehicles().get(0).getLastRoad().getEndJunction()
			  .setX((int)g.getDrawVehicle().getVehicles().get(0).getLastRoad().getEndJunction().getX()+
					  (int)(g.getDrawVehicle().getVehicles().get(0).getLastRoad().getLength()*0.1));
			  g.getDrawVehicle().getVehicles().get(0).getLastRoad().getEndJunction()
			  .setY((int)g.getDrawVehicle().getVehicles().get(0).getLastRoad().getEndJunction().getX()+
					  (int)(g.getDrawVehicle().getVehicles().get(0).getLastRoad().getLength()*0.1));
			  //}
			  x+=(g.getDrawVehicle().getVehicles().get(0).getLastRoad().getLength())/
					  10;
		  /*double length=g.getDrawVehicle().getVehicles().get(0).getLastRoad().getLength();
		  x_coord=g.getDrawVehicle().getVehicles().get(0).getLastRoad().getStartJunction().getX();
		  y_coord=g.getDrawVehicle().getVehicles().get(0).getLastRoad().getStartJunction().getY();
		  speed=g.getDrawVehicle().getVehicles().get(0).getVehicleType()
				  .getAverageSpeed();
		  x_coord += speed*x_flag;
		  g.getDrawVehicle().getVehicles().get(0)
	        .getLastRoad().getStartJunction().setX((int)x_coord);
		  y_coord += speed*y_flag;
		  g.getDrawVehicle().getVehicles().get(0)
	        .getLastRoad().getStartJunction().setY((int)y_coord);
		  

		    if(x_coord > length-size)
		    {
		    	x_flag = -1;
		        x_coord = length-size;
		        g.getDrawVehicle().getVehicles().get(0)
		        .getLastRoad().getStartJunction().setX((int)x_coord);
		        
		    }
		    else if(x_coord < 0)
		    {
		    	x_flag = 1;
		        x_coord = 0;
		        g.getDrawVehicle().getVehicles().get(0)
		        .getLastRoad().getStartJunction().setX((int)x_coord);
		    }
	
		    if(y_coord > length-size)
		    {
		    	y_flag = -1;
		        y_coord = length-size;
		        g.getDrawVehicle().getVehicles().get(0)
		        .getLastRoad().getStartJunction().setY((int)y_coord);
		    }
		    else if(y_coord < 0)
		    {
		    	y_flag = 1;
		        y_coord = 0;
		        g.getDrawVehicle().getVehicles().get(0)
		        .getLastRoad().getStartJunction().setX((int)y_coord);
		    }*/
	    }
}
		  

	    




