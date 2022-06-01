package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.City;
import engine.Game;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Status;

public class Unitrecruiting implements ActionListener {
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	private JPanel panelTitle,panelStart;
	private JFrame frame;
	JComboBox combo;
	private JButton startButton;
	private JLabel label;
	private int idlearmy;

	private JButton Archer,Cavalry,Infantry,Cairo,Rome,Sparta;
	Font TitleFont=new Font("Penumbra Half Serif Std",Font.PLAIN,10);
	private Game x = FourthWindow.game;
	int counterofArcher,counterofInf,countofCav;
	String city = FifthWindow.ss;
	String target;
	String cityundersiege;
	int turnsundersiege;
	int distance;
//	City c ;
	City q ;
	Army a ;
	JTextArea hi;
	JTextArea hiii;
	int Level1,MaxSold1,CurrentSold1,Level2,MaxSold2,CurrentSold2,Level3,MaxSold3,CurrentSold3;
	public Unitrecruiting() {
	
		frame = new JFrame();
		frame.setSize(1500,1000); // changed size of screen
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("EmpireBuilding");
		frame.setVisible(true);
		device.setFullScreenWindow(frame);
		
	    Cairo = new JButton("Cairo ");
	     Cairo.addActionListener(this);
	     Cairo.setFont(TitleFont);
	     Cairo.setBounds(500, 500, 200, 50);
	     frame.add(Cairo);
	     Sparta = new JButton("Sparta ");
	     Sparta.addActionListener(this);
	     Sparta.setFont(TitleFont);
	     Sparta.setBounds(200, 500, 200, 50);
	     frame.add(Sparta);
	     Rome = new JButton("Rome ");
	     Rome.addActionListener(this);
	     Rome.setFont(TitleFont);
	    Rome.setBounds(700, 500, 200, 50);
	     frame.add(Rome);
	     Cairo.setEnabled(true);
	    Rome.setEnabled(true);
	     Sparta.setEnabled(true);
	     for(int k =0;k<x.getPlayer().getControlledCities().size();k++) {
	    	 if(x.getPlayer().getControlledCities().get(k).getName().equals("Sparta")) {
	    		 Sparta.setEnabled(false);
	    	 }
	    	 if(x.getPlayer().getControlledCities().get(k).getName().equals("Cairo")) {
	    		 Cairo.setEnabled(false);
	    	 }
	    	 if(x.getPlayer().getControlledCities().get(k).getName().equals("Rome")) {
	    		 Rome.setEnabled(false);
	    	 }
	    	 
	     }
	     
	     String[] ff = {"mana","farah"};
	    
	     combo = new JComboBox(ff);
	     combo.setBounds(40, 500, 100, 300);
	    
	     frame.add(combo);
	     
	     
	     
	     JButton endturn = new  JButton();
			endturn.setBounds(30, 500, 100, 50);
			endturn.setText("End Turn");
			frame.add(endturn);
			endturn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(x.getCurrentTurnCount()<40) {
					x.endTurn();
					//label4.setText(Integer.toString(game.getCurrentTurnCount()));
				}
					else {
					 JOptionPane.showConfirmDialog(null, "you have 10 turns left!!", "warning!", JOptionPane.CANCEL_OPTION);	
					}
					
				}
		
				
			});
			
			
	    JButton InitiateArmy = new JButton();
	     InitiateArmy.setBounds(500,300,200,50);
	     frame.add(InitiateArmy);
	     InitiateArmy.setText("InitiateArmy");
	     InitiateArmy.addActionListener(new ActionListener()
			{  

			    public void actionPerformed(ActionEvent e2)
			    { 
			    	for(int h =0;h<x.getPlayer().getControlledCities().size();h++) {
						if(x.getPlayer().getControlledCities().get(h).getName().equals(city)) {
							q =x.getPlayer().getControlledCities().get(h);
							break;
						}}
						for(int r =0;r<q.getDefendingArmy().getUnits().size();r++) {
							
						}

					
					
					//if clicking on controlled city button-- close this window and open cityview aka 7thwindow
				}
			    });
	     hi = new JTextArea();
	     hi.setBounds(10, 10, 600, 100);
	     frame.add(hi);
	     
	     
	     hiii = new JTextArea();
	     hiii.setBounds(100, 200, 600, 100);
	     frame.add(hiii);
	     City c = null;
	    
//	     Cairo.addActionListener(new ActionListener()
//		{  
//
//		    public void actionPerformed(ActionEvent e2)
//		    { for(int u =0;u<x.getPlayer().getControlledArmies().get(h))
//		    	x.targetCity(army,"Cairo");
//		    }
// });
//	     Sparta.addActionListener(new ActionListener()
//			{  
//
//			    public void actionPerformed(ActionEvent e2)
//			    {
//			    	x.targetCity(army,"Sparta");
//			    }
//			    });
//	     Rome.addActionListener(new ActionListener()
//			{  
//
//			    public void actionPerformed(ActionEvent e2)
//			    {
//			    	x.targetCity(army,"Rome");
//			    }
//			    });
//	  
     for(int y=0;y<x.getPlayer().getControlledCities().size();y++) {
	    	 if(x.getPlayer().getControlledCities().get(y).getName().equals(city)) {
	    		 c = x.getPlayer().getControlledCities().get(y);
	    		 System.out.print(c.getName());
	    	 }
	     }
//	     for(int u =0;u<c.getDefendingArmy().getUnits().size();u++) {
//	    	
//	    		 if(c.getDefendingArmy().getUnits().get(u) instanceof units.Archer ) {
//	    			 counterofArcher++;
//	    			
//	    			Level1= c.getDefendingArmy().getUnits().get(u).getLevel();
//	    			CurrentSold1=c.getDefendingArmy().getUnits().get(u).getCurrentSoldierCount();
//	    			MaxSold1=c.getDefendingArmy().getUnits().get(u).getMaxSoldierCount();
//	    		 }
//	    		 if(c.getDefendingArmy().getUnits().get(u) instanceof units.Cavalry) {
//	    			 countofCav++;
//	    			 Level2= c.getDefendingArmy().getUnits().get(u).getLevel();
//		    			CurrentSold2=c.getDefendingArmy().getUnits().get(u).getCurrentSoldierCount();
//		    			MaxSold2=c.getDefendingArmy().getUnits().get(u).getMaxSoldierCount();
//	    		 }
//	    		 if( c.getDefendingArmy().getUnits().get(u) instanceof units.Infantry) {
//	    			 counterofInf++;
//	    			 Level3= c.getDefendingArmy().getUnits().get(u).getLevel();
//		    			CurrentSold3=c.getDefendingArmy().getUnits().get(u).getCurrentSoldierCount();
//		    			MaxSold3=c.getDefendingArmy().getUnits().get(u).getMaxSoldierCount();
//	    		 }
//	    	 }

				
	
			//------armies stationed in city stats-----
	    
			for(int m =0;m<x.getPlayer().getControlledArmies().size();m++) {
				
				if(c.getName()==x.getPlayer().getControlledArmies().get(m).getCurrentLocation()) {
					
					for (int n=0; n<x.getPlayer().getControlledArmies().get(m).getUnits().size();n++) {
							hi.append("Level"+x.getPlayer().getControlledArmies().get(m).getUnits().get(n).getLevel()+"\n"+
							x.getPlayer().getControlledArmies().get(m).getUnits().get(n).getCurrentSoldierCount()+"\n"+
							x.getPlayer().getControlledArmies().get(m).getUnits().get(n).getMaxSoldierCount()+"\n");
							//label for each
					}
				}
	    
		
			}}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String [] args) {
		new Unitrecruiting();
	
	}
}
