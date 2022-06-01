//package view;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.FlowLayout;
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
//import javax.swing.JTextField;
//
//public class SecondWindow  implements ActionListener {
//	static String username;
//	private JFrame frame;
//	private JTextField Text;
//	private JLabel label;
//	private JButton submit;
//	private JPanel panelTitle, panelStart,panelText;
//	Font GameFont;
//	Font GameFont2;
//	private static String userInput ="";
//	
//	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
//	
//	SecondWindow() throws IOException {
//		try {
//			 GameFont = Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")).deriveFont(60f);
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
//	
//		frame = new JFrame();
//		frame.setSize(1500,1000);
//		
//		frame.getContentPane().setBackground(Color.black);
//		frame.setLayout(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("EmpireBuilding");
//		
//		
//		panelTitle = new JPanel();
//		panelTitle.setBounds(500,300,450,80);  // 300, 50, 300, 50
//		panelTitle.setBackground(Color.black);
//		
//		label = new JLabel("ENTER YOUR NAME");
//	
//		label.setFont(GameFont);
//		label.setForeground(Color.white);
//		panelTitle.add(label);
//		frame.add(panelTitle);
// 
//		panelStart = new JPanel();
//		panelStart.setBounds(630,450,200,70); // 300, 100, 150, 100
//		panelStart.setBackground(Color.black);
//		
//        submit = new JButton("ENTER");
//		submit.addActionListener(this);
//		submit.setForeground(Color.black);
//		submit.setBounds(300,400,150,300);
//		submit.setFont(GameFont2);
//	    panelStart.add(submit);
//	    frame.add(panelStart);
//     	frame.setVisible(true);
//     	
//     	panelText = new JPanel();
//		panelText.setBounds(650,400,150,40); // 300, 100, 150, 100
//		panelText.setBackground(Color.black);
//     
//        Text = new JTextField (10);
//	    Text.setBounds(0, 0, 0, 0);
//	    panelText.add(Text);
//	    frame.add(panelText);
//	    device.setFullScreenWindow(frame);
//	    
//	    		
//	}
//	
//	public static String getUserInput() {
//		return userInput;
//	}
//
//	public static void main(String args[]) throws IOException {
//	          new SecondWindow();
//	  }
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		frame.dispose();
//		username =Text.getText();
//	
//		try {
//			ThirdWindow s = new ThirdWindow();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//	}
//	
//}
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SecondWindow implements ActionListener { // extends jpanel
    private JFrame frame;
    private JTextField Text;
    private JLabel label;
    private JButton submit;
    private JPanel panelTitle, panelStart,panelText;
    Font GameFont;
    Font GameFont2;
    private static String userInput ="";
    
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    
    SecondWindow() throws IOException {
        try {
             GameFont = Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")).deriveFont(60f);
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
        frame.setSize(1600,1200);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("EmpireBuilding");
        
        
        panelTitle = new JPanel();
        panelTitle.setBounds(500,300,450,80);  // 300, 50, 300, 50
        panelTitle.setBackground(Color.black);
        
        label = new JLabel("ENTER YOUR NAME");
    
        label.setFont(GameFont);
        label.setForeground(Color.white);
        panelTitle.add(label);
        frame.add(panelTitle);
 
        panelStart = new JPanel();
        panelStart.setBounds(630,450,200,70); // 300, 100, 150, 100
        panelStart.setBackground(Color.black);
        
        submit = new JButton("ENTER");
        submit.addActionListener(this);
        submit.setForeground(Color.black);
        submit.setBounds(300,400,150,300);
        submit.setFont(GameFont2);
        panelStart.add(submit);
        frame.add(panelStart);
         frame.setVisible(true);
         
         panelText = new JPanel();
        panelText.setBounds(650,400,150,40); // 300, 100, 150, 100
        panelText.setBackground(Color.black);
     
        Text = new JTextField (10);
        Text.setBounds(0, 0, 0, 0);
        panelText.add(Text);
        frame.add(panelText);
        device.setFullScreenWindow(frame);
        
                
    }
    
    public static String getUserInput() {
        return userInput;
    }

    public static void main(String args[]) throws IOException {
              new SecondWindow();
      }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        try {
            ThirdWindow s = new ThirdWindow();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
    }
    
}
