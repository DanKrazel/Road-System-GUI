package SwingDraw;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import components.Driving;

import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLayeredPane;
import java.awt.Polygon;

public class GUI implements ActionListener{

	private JFrame frame;
	private JPanel panel;
	private JButton btnNewButton,btnNewButton_1,btnNewButton_2,btnNewButton_3,btnNewButton_4;
	private CreateRoadSystem road;
	private moveVehicle moveVeh;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		setFrame(new JFrame());
		getFrame().setTitle("Road system");
		getFrame().setSize(800,800);
		frame.getContentPane().setBackground(Color.WHITE);
		
		btnNewButton = new JButton("Create road system");
		btnNewButton.setBounds(0, 720, 231, 21);
		btnNewButton.addActionListener(this);
		frame.getContentPane().setLayout(null);
		getFrame().getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Start");
		btnNewButton_1.setBounds(230, 720, 143, 21);
		btnNewButton_1.addActionListener(this);
		frame.getContentPane().setLayout(null);
		getFrame().getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Stop");
		btnNewButton_2.setBounds(371, 720, 125, 21);
		getFrame().getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Resume");
		btnNewButton_3.setBounds(498, 720, 153, 21);
		getFrame().getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Info");
		btnNewButton_4.setBounds(651, 720, 135, 21);
		getFrame().getContentPane().add(btnNewButton_4);
		
		/*graphics graphics_ = new graphics(10, 3);
		graphics_.setBounds(10, 10, 766, 704);
		frame.getContentPane().add(graphics_);*/
		
		JMenuBar menuBar = new JMenuBar();
		getFrame().setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Background");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Blue");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("None");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Vehicles color");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Blue");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Magenta");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Orange");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Random");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Help");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Help");
		mnNewMenu_3.add(mntmNewMenuItem_7);
		

	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			road=new CreateRoadSystem(this);
			road.getFrame().setVisible(true);
		}
		
		if(e.getSource()==btnNewButton_1) {
			graphics g1=road.getGraphics();
			//moveVehicle moveVeh=new moveVehicle(g1,g1.getDrawVehicle());
			moveVeh=new moveVehicle(g1);
			moveVeh.start();
		}
		
		if(e.getSource()==btnNewButton_2) {
			
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void addFrame(Component component) {
		frame.getContentPane().add(component);
	}
}

