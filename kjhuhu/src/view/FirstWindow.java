//package view;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.FontFormatException;
//import java.awt.GraphicsDevice;
//import java.awt.GraphicsEnvironment;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class FirstWindow  implements ActionListener {
//	private JPanel panelTitle,panelStart;
//	private JFrame frame;
//	private JButton startButton;
//	private JLabel label;
//	
//	Font GameFont;
//	Font GameFont2;
//	
//	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
//	
//	public FirstWindow() throws IOException {
//		try {
//			 GameFont = Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")).deriveFont(100f);
//		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")));
//		} 
//		catch (IOException|FontFormatException e) {
//
//		}
//		try {
//			 GameFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")).deriveFont(50f);
//		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")));
//		} 
//		catch (IOException|FontFormatException e) {
//
//		}
//		
//		frame = new JFrame();
//		frame.setSize(1500,1000); // changed size of screen
//		frame.getContentPane().setBackground(Color.black);
//		frame.setLayout(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("EmpireBuilding");
//	
//		panelTitle = new JPanel();
//		panelTitle.setBounds(410,280,600,150); // (100,100,600,150) changed bounds
//		panelTitle.setBackground(Color.black);
//		
//		label = new JLabel("EMPIREBUILDING");
//		label.setVerticalAlignment(JLabel.CENTER);
//		label.setHorizontalAlignment(JLabel.CENTER);
//		label.setForeground(Color.white);
//		label.setFont(GameFont);
//		panelTitle.add(label);
//		
//		
//		panelStart = new JPanel();
//		panelStart.setBounds(610, 500, 200, 100); // changed bounds
//    	panelStart.setBackground(Color.black);
//		
//		
//		startButton = new JButton("START");
//		startButton.addActionListener(this);
//		startButton.setBackground(Color.black);
//		startButton.setForeground(Color.black);
//		startButton.setFont(GameFont2);
//		panelStart.add(startButton);
//		frame.add(panelTitle);
//		frame.add(panelStart);
//     	frame.setVisible(true);
//     	device.setFullScreenWindow(frame);
//	}
//
//	public static void main(String[] args) throws IOException {
//		  System.out.println("it WORKS");
//    	  new FirstWindow();	  
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		frame.dispose();
//
//		try {
//			SecondWindow s = new SecondWindow();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
//
//}
package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import java.io.File;
import java.io.IOException;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

public class FirstWindow  implements ActionListener {
    private JPanel panelTitle,panelStart;
    private JFrame frame;
    private JButton startButton;
    private JLabel label;
    
    Font GameFont;
    Font GameFont2;
    
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    
    public FirstWindow()  {
        try {
             GameFont = Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")).deriveFont(100f);
             GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
             ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")));
        } 
        catch (IOException|FontFormatException e) {

        }
        try {
             GameFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")).deriveFont(50f);
             GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
             ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")));
        } 
        catch (IOException|FontFormatException e) {

        }
        
        frame = new JFrame();
        frame.setSize(1600, 1200); 
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("EmpireBuilding");
    
        panelTitle = new JPanel();
        panelTitle.setBounds(410,280,600,150); // (100,100,600,150) changed bounds
        panelTitle.setBackground(Color.black);
        
        label = new JLabel("EMPIREBUILDING");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.white);
        label.setFont(GameFont);
        panelTitle.add(label);
        
        
        panelStart = new JPanel();
        panelStart.setBounds(610, 500, 200, 100); // changed bounds
        panelStart.setBackground(Color.black);
        
        
        
        startButton = new JButton("START");
        startButton.addActionListener(this);
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.black);
        startButton.setFont(GameFont2);
        panelStart.add(startButton);
        frame.add(panelTitle);
        frame.add(panelStart);
         frame.setVisible(true);
         device.setFullScreenWindow(frame);
    }
//
    public static void main(String[] args){
          System.out.println("it WORKS");
          new FirstWindow();      
    }

    @Override
    public void actionPerformed(ActionEvent e){
        frame.dispose();
        if(e.getSource()==startButton) {
            try {
                SecondWindow s = new SecondWindow();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

}