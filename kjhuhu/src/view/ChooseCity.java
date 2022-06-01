package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Game;

public class ChooseCity {
private JLabel label;
private JFrame frame;
String s;
private Game game;
private JButton Cairo,Rome,Sparta;
String city;
public ChooseCity() {
frame = new JFrame();
frame.setSize(800,600); // changed size of screen
frame.getContentPane().setBackground(Color.black);
frame.setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setTitle("EmpireBuilding");
frame.setVisible(true);
Cairo = new JButton ();
Cairo.setText("Cairo");
Rome = new JButton ();
Rome.setText("Rome");
Sparta = new JButton();
Sparta.setText("Sparta");
Rome.setBounds(200, 100, 100, 50);
Cairo.setBounds(200, 200, 100, 50);
Sparta.setBounds(200, 300, 100,50);
frame.add(Cairo);
frame.add(Sparta);
frame.add(Rome);
Cairo.setEnabled(true);
Rome.setEnabled(true);
Sparta.setEnabled(true);
 game = FourthWindow.game;
city = ThirdWindow.getCityname();
Cairo.addActionListener( new ActionListener()
     {  
    
         public void actionPerformed(ActionEvent e2)
         { 
        	 s="Cairo";
           	 frame.dispose();
           	 SixthWindow s = new SixthWindow();
         } });
         

Rome.addActionListener( new ActionListener()
{  

public void actionPerformed(ActionEvent e2)
{ s="Rome";
	 frame.dispose();
	 SixthWindow s = new SixthWindow();
} });

Sparta.addActionListener( new ActionListener()
{  

public void actionPerformed(ActionEvent e2)
{  s = "Sparta";
	 frame.dispose();
	 SixthWindow s = new SixthWindow();
} });

for(int h=0;h<game.getAvailableCities().size();h++) {
	if(game.getAvailableCities().get(h).getName().equals(city)) {
		if(city.equals("Sparta"))
			Sparta.setEnabled(false);
	}
 if (city.equals("Cairo"))
 		Cairo.setEnabled(false);
 if (city.equals("Rome"))
	 Rome.setEnabled(false);
 
}

}

}
