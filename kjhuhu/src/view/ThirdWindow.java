
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.Game;
import exceptions.NotEnoughGoldException;


public class ThirdWindow implements ActionListener{
	private JFrame frame = new JFrame();
	private static String name = SecondWindow.getUserInput();
	private static Game gamie;
	private static String cityname;
	private JLabel label;
	private ImageIcon Image;
	private JPanel panel;
    private JButton Rome, Sparta, Cairo;
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    Font FONTY;
	
	ThirdWindow() throws IOException {
		
		try {
			 FONTY = Font.createFont(Font.TRUETYPE_FONT, new File("FONTY.ttf")).deriveFont(25f);
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("FONTY.ttf")));
		} 
		catch (IOException|FontFormatException e) {
		}
		

		Image = new ImageIcon("MAP1.png");
		label = new JLabel(Image);
		label.setBounds(0, 0, 1920, 1080);;
		
		Cairo = new JButton ("Cairo");
		Cairo.addActionListener(new ActionListener()
	     {  
	        
	         public void actionPerformed(ActionEvent e2)
	         { 
	        	try {
					gamie = new Game(name,"Cairo");
					cityname ="Cairo";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	frame.dispose();
	        	
	    		try {
	    			FourthWindow s = new FourthWindow();
	    		} catch (IOException e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    		}
	         }});
		Cairo.setFont(FONTY);
		Cairo.setBounds(900, 500, 150, 50);
		label.add(Cairo);
		
		Rome = new JButton ("ROME");
		Rome.addActionListener(new ActionListener()
	     {  
	        
	         public void actionPerformed(ActionEvent e2)
	         { 
	        	try {
					gamie = new Game(name,"Rome");
					cityname ="Rome";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	frame.dispose();
	        	
	    		try {
	    			FourthWindow s = new FourthWindow();
	    		} catch (IOException e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    		}
	         }});
		Rome.setFont(FONTY);
		Rome.setBounds(300, 600, 150, 50);
		label.add(Rome);
		
		Sparta = new JButton("SPARTA");
		Sparta.addActionListener(new ActionListener()
	     {  
	        
	         public void actionPerformed(ActionEvent e2)
	         { 
	        	try {
					gamie = new Game(name,"Sparta");
					cityname ="Sparta";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	frame.dispose();
	        	
	    		try {
	    			FourthWindow s = new FourthWindow();
	    		} catch (IOException e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    		}
	        	
	         }});
		Sparta.setFont(FONTY);
		Sparta.setBounds(300, 200, 150, 50);
		label.add(Sparta);
		
		frame = new JFrame();
		frame.setSize( 1920, 1080);
		frame.setTitle("EmpireBuilding");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);	
		frame.add(label);
		frame.setVisible(true);
		device.setFullScreenWindow(frame);
		
		
	}
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		ThirdWindow.name = name;
	}

	public static String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public static Game getGamie() {
		return gamie;
	}
	public void setGamie(Game gamie) {
		this.gamie = gamie;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	
		try {
			FourthWindow s = new FourthWindow();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws IOException  {
        new ThirdWindow();
}
}
