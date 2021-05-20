package SwingDraw;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JSlider;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import java.awt.Color;
import java.awt.Dimension;

public class CreateRoadSystem implements ActionListener,ChangeListener {

	private JFrame frame;
	private JSlider slider,slider_1;
	private JTextField txtNumberOfJunctions;
	private JTextField txtNumberOfVehicles;
	private JSplitPane splitPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private int valueSlider=0;
	private int valueSlider1=0;
	private graphics g;
	private GUI gui;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[]arg) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateRoadSystem window = new CreateRoadSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	/*public CreateRoadSystem() {
		initialize();
	}*/
	public CreateRoadSystem(GUI gui) {
		this.gui=gui;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,300);
		frame.setTitle("Create road system");
		frame.setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{53, 36, 43, 44, 63, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		txtNumberOfJunctions = new JTextField();
		txtNumberOfJunctions.setBorder(null);
		txtNumberOfJunctions.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNumberOfJunctions.setEditable(false);
		txtNumberOfJunctions.setText("Number of junctions");
		GridBagConstraints gbc_txtNumberOfJunctions = new GridBagConstraints();
		gbc_txtNumberOfJunctions.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumberOfJunctions.gridx = 0;
		gbc_txtNumberOfJunctions.gridy = 0;
		frame.getContentPane().add(txtNumberOfJunctions, gbc_txtNumberOfJunctions);
		txtNumberOfJunctions.setColumns(11);
		
		slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(20); 
		slider.setMinimum(3);
		slider.setValue(10);
		//slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.addChangeListener(this);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 0);
		gbc_slider.gridx = 0;
		gbc_slider.gridy = 1;
		frame.getContentPane().add(slider, gbc_slider);
		
		txtNumberOfVehicles = new JTextField();
		txtNumberOfVehicles.setBorder(null);
		txtNumberOfVehicles.setText("Number of vehicles");
		txtNumberOfVehicles.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNumberOfVehicles.setEditable(false);
		txtNumberOfVehicles.setColumns(11);
		GridBagConstraints gbc_txtNumberOfVehicles = new GridBagConstraints();
		gbc_txtNumberOfVehicles.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumberOfVehicles.gridx = 0;
		gbc_txtNumberOfVehicles.gridy = 2;
		frame.getContentPane().add(txtNumberOfVehicles, gbc_txtNumberOfVehicles);
		
		slider_1 = new JSlider();
		slider_1.setMinorTickSpacing(1);
		slider_1.setValue(10);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMaximum(50);
		slider_1.setMajorTickSpacing(5);
		slider_1.addChangeListener(this);
		GridBagConstraints gbc_slider_1 = new GridBagConstraints();
		gbc_slider_1.insets = new Insets(0, 0, 5, 0);
		gbc_slider_1.fill = GridBagConstraints.HORIZONTAL; 
		gbc_slider_1.gridx = 0;
		gbc_slider_1.gridy = 3;
		frame.getContentPane().add(slider_1, gbc_slider_1);
		
		splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.anchor = GridBagConstraints.SOUTH;
		gbc_splitPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 4;
		frame.getContentPane().add(splitPane, gbc_splitPane);
		
		btnNewButton = new JButton("OK");
		btnNewButton.setMaximumSize(new Dimension(300, 21));
		btnNewButton.setPreferredSize(new Dimension(285, 35));
		btnNewButton.addActionListener(this);
		splitPane.setLeftComponent(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setPreferredSize(new Dimension(60, 21));
		btnNewButton_1.addActionListener(this);
		splitPane.setRightComponent(btnNewButton_1);
	}
	
	public void stateChanged(ChangeEvent event) {
		valueSlider=slider.getValue();
		valueSlider1=slider_1.getValue();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			g=new graphics(valueSlider,valueSlider1);
			g.setBounds(10, 10, 1000, 1000);
			gui.getFrame().getContentPane().add(g);
			gui.getFrame().setVisible(true);
			frame.setVisible(false);
		}
		if(e.getSource()==btnNewButton_1)
			frame.dispose();
	}
	
	public graphics getGraphics() {
		return g;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
