package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.City;
import engine.Game;
import units.Status;

public class FifthWindow {
	private ImageIcon Image, rome, cairo, sparta;
	private JButton Rome, Cairo, Sparta;
    private int counter,distance,turnsundersiege,j;

	private String target,cityundersiege;

	private JPanel panelTitle,panelStart;
	private JFrame frame,frame2,frame3;
	private JLabel label,label2,label3;
	Font TitleFont=new Font("Penumbra Half Serif Std",Font.PLAIN,10);
	Font StartFont=new Font("Penumbra Half Serif Std",Font.PLAIN,50);
	 static Game game;
	 boolean flagsparta=false;
	boolean flagrome=false;
	boolean flagcairo=false;
	 String city =ThirdWindow.getCityname() ;
	 City c ;
	 int idlearmy;
	 static String ss;
public FifthWindow() {
game = FourthWindow.game;
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
    Rome.setBounds(600, 100, 100, 50);
    Cairo.setBounds(600, 200, 100, 50);
    Sparta.setBounds(600, 300, 100,50);
    frame.add(Cairo);
    frame.add(Sparta);
    frame.add(Rome);
Cairo.setEnabled(false);
Rome.setEnabled(false);
Sparta.setEnabled(false);
if(game.getCurrentTurnCount()>50||game.getPlayer().getControlledCities().size()==game.getAvailableCities().size()||game.getPlayer().getControlledArmies().size()==0) {
	frame.dispose();
	SeventhWindow s = new SeventhWindow();
}
	for (int lang=0; lang < game.getAvailableCities().size();lang++){
					if (game.getAvailableCities().get(lang).getTurnsUnderSiege()>3){
						frame.dispose();
						EighthWindow x=new EighthWindow();
					}
				}
Cairo.addActionListener( new ActionListener()
	     {  
        
	         public void actionPerformed(ActionEvent e2)
	         { 
	        	 ss="Cairo";
	           	 frame.dispose();
	           	SixthWindow s = new SixthWindow();
	         } });
	         

Rome.addActionListener( new ActionListener()
{  

    public void actionPerformed(ActionEvent e2)
    { ss="Rome";
  	 frame.dispose();
  	SixthWindow s = new SixthWindow();
    } });
    
Sparta.addActionListener( new ActionListener()
{  

    public void actionPerformed(ActionEvent e2)
    {  ss = "Sparta";
   
   	 frame.dispose();
   	SixthWindow s = new SixthWindow();
    } });
	for (int j=0;j<game.getPlayer().getControlledCities().size();j++) {
		if ( game.getPlayer().getControlledCities().get(j).getName().equals("Sparta")) {
				flagsparta=true;
				Sparta.setEnabled(true);
		}
		
		if ( game.getPlayer().getControlledCities().get(j).getName().equals("Rome")) {
			flagsparta=true;
			Rome.setEnabled(true);
		}
		if ( game.getPlayer().getControlledCities().get(j).getName().equals("Cairo")) {
			
			Cairo.setEnabled(true);
			flagsparta=true;
	}
	}
	

		 
		 
		 
		 
}

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	





		public static void main(String[] args) throws IOException {
	
	    	  new FifthWindow();	  
		}
}


