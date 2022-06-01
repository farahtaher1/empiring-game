package view;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import engine.City;
import engine.Game;
import units.Status;

//-----map view-----
public class SixthWindow implements ActionListener {
	private ImageIcon Image, rome, cairo, sparta;
	private JButton Initiate;
    private int counter,distance,turnsundersiege,j;
	private JLabel label,label1,label2,label3,label4,label5;
	private String target,cityundersiege;
	private JFrame frame;
	private JButton Rome, Cairo, Sparta;
	String ss;
	Font FONTY;
	JTextArea hiii;
	City cityy;
	String city = FifthWindow.ss;
	private Game x =FifthWindow.game;
	int idlearmy;
	String name = FifthWindow.ss;
int turnsunderseige;
String cityunderseige;
	 SixthWindow(){
		 frame = new JFrame();
			frame.setSize(1600, 1200); 
			frame.setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("EmpireBuilding");	
			
			frame.setVisible(true);
			 hiii = new JTextArea();
		     hiii.setBounds(100, 200, 600, 100);
		     frame.add(hiii);
		     City c = null;
			label = new JLabel();
			try {
				
				 FONTY = Font.createFont(Font.TRUETYPE_FONT, new File("FONTY.ttf")).deriveFont(25f);
			     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("FONTY.ttf")));
			} 
			catch (IOException|FontFormatException e) {
			}
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
		Cairo.setEnabled(false);
		Rome.setEnabled(false);
		Sparta.setEnabled(false);
		if(x.getCurrentTurnCount()>50||x.getPlayer().getControlledCities().size()==x.getAvailableCities().size()||x.getPlayer().getControlledArmies().size()==0) {
			frame.dispose();
			SeventhWindow s = new SeventhWindow();
		}
		Cairo.addActionListener( new ActionListener()
			     {  
		        
			         public void actionPerformed(ActionEvent e2)
			         { 
			        	 ss="Cairo";
			           	 frame.dispose();
			          try {
						FourthWindow s = new FourthWindow();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			           	
			         } });
			         

		Rome.addActionListener( new ActionListener()
		{  

		    public void actionPerformed(ActionEvent e2)
		    { ss="Rome";
		  	 frame.dispose();
		  	try {
				FourthWindow s = new FourthWindow();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    } });
		    
		Sparta.addActionListener( new ActionListener()
		{  

		    public void actionPerformed(ActionEvent e2)
		    {  ss = "Sparta";
		   
		   	 frame.dispose();
		   	try {
				FourthWindow s = new FourthWindow();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    } });
			for (int j=0;j<x.getPlayer().getControlledCities().size();j++) {
				if ( x.getPlayer().getControlledCities().get(j).getName().equals("Sparta")) {
						
						Sparta.setEnabled(true);
				}
				
				if ( x.getPlayer().getControlledCities().get(j).getName().equals("Rome")) {
				
					Rome.setEnabled(true);
				}
				if ( x.getPlayer().getControlledCities().get(j).getName().equals("Cairo")) {
					
					Cairo.setEnabled(true);
				
			}
	
		for (int lang=0; lang <x.getAvailableCities().size();lang++){
					if (x.getAvailableCities().get(lang).getTurnsUnderSiege()>3){
						frame.dispose();
						EighthWindow z=new EighthWindow();
					}
				}

		
		//if clicking on controlled city button-- close this window and open cityview aka 7thwindow
		


	
	
	    
		for (int i=0; i<x.getPlayer().getControlledArmies().size(); i++){
	  		if (x.getPlayer().getControlledArmies().get(i).getCurrentStatus()==Status.IDLE) {
				 for (int z=0; z<x.getPlayer().getControlledArmies().get(i).getUnits().size();z++) {
					if (x.getPlayer().getControlledArmies().get(i).getUnits().get(z) instanceof units.Archer) {
							
							hiii.append("Archer"+"Level"+x.getPlayer().getControlledArmies().get(i).getUnits().get(z).getLevel()+"\n"+
							"CURRENT SOldier"+x.getPlayer().getControlledArmies().get(i).getUnits().get(z).getCurrentSoldierCount()+"\n"+
							"Max Soldiers"+x.getPlayer().getControlledArmies().get(i).getUnits().get(z).getMaxSoldierCount()+"\n");
						}else 
							if (x.getPlayer().getControlledArmies().get(i).getUnits().get(z) instanceof units.Cavalry) {
								
								hiii.append("Cavalry"+"Level"+x.getPlayer().getControlledArmies().get(i).getUnits().get(z).getLevel()+"\n"+
								"CURRENT SOldier"+x.getPlayer().getControlledArmies().get(i).getUnits().get(z).getCurrentSoldierCount()+"\n"+
								"Max Soldiers"+x.getPlayer().getControlledArmies().get(i).getUnits().get(z).getMaxSoldierCount()+"\n");
							}else {
								//label that says type is infantry
								

								hiii.append("Infantry"+"Level"+x.getPlayer().getControlledArmies().get(i).getUnits().get(z).getLevel()+"\n"+
								"CURRENT SOldier"+x.getPlayer().getControlledArmies().get(i).getUnits().get(z).getCurrentSoldierCount()+"\n"+
								"Max Soldiers"+x.getPlayer().getControlledArmies().get(i).getUnits().get(z).getMaxSoldierCount()+"\n");
						//label for each
					
							}
					}
	  		}
	  		else if (x.getPlayer().getControlledArmies().get(i).getCurrentStatus()==Status.MARCHING) {
	  			target= x.getPlayer().getControlledArmies().get(i).getTarget();
	  			distance=x.getPlayer().getControlledArmies().get(i).getDistancetoTarget();
				hiii.append("Target: "+ target+"/n"+ "Distance: " + distance+"/n");
	  		}
	  		else {
	  			for (int t=0; j<x.getAvailableCities().size();t++) {
		  			if (x.getAvailableCities().get(t).getName()==x.getPlayer().getControlledArmies().get(i).getCurrentLocation()) {
		  				turnsundersiege=x.getAvailableCities().get(t).getTurnsUnderSiege();
		  				cityundersiege=x.getPlayer().getControlledArmies().get(i).getCurrentLocation();
						hiii.append("Turns under siege: "+"/n"+ turnsundersiege+"/n"+cityundersiege+"/n");
		  			}
	  		}
		}
	  		
		
		
		
hiii.append("Target:"+target+"\n"+"DISTANCE"+distance+"\n "+"TURNSUNDERSIEGE"+turnsundersiege+"\n"+"CityunderSiege"+cityundersiege);

}}
//}
//		label1= new JLabel("Idle Controlled Armies: "+counter);
//		label1.setBounds(100,50,200,100);
//		frame.add(label1);
//		//labels for marching/sieging armies
//		label2 = new JLabel(" Marching Controlled Armies"+ target +distance);
//		
//		label2.setBounds(100,100,200,100);
//		
//		frame.add(label2);
	
//		label3 = new JLabel("Turns Under Seige"+Integer.toString(turnsundersiege));
//		label3.setBounds(100, 150, 200, 100);
//		frame.add(label3);
//		label4 = new JLabel("City Under Seige"+cityundersiege);
//		label4.setBounds(100, 200, 200, 100);
//		frame.add(label4);
//		
//	JTextArea f = new JTextArea();
//	f.setBounds(100,50,200,100);
	
	 }	
	 
	public static void main(String args[]) throws IOException  {
		 System.out.println("it WORKS");
		 
   	     new SixthWindow();
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
