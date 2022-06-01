package view;
import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Building;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;

import java.awt.Image;
import java.awt.Label;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import engine.*;

import units.Army;
import units.Unit;

import javax.swing.*;





// need to update the treasury after recruit and building 
public class FourthWindow implements ActionListener {
	
	JTextArea hiii, hello;
	private JPanel panelTitle,panelStart;
	private JFrame frame;
	private JPanel panel;
	private JButton farmupgrade,marketupgrade,archerupgrade,stableupgrade,barrcksupdate,attack,map;
	private JLabel label,label2,label3,label4;
	Font TitleFont=new Font("Penumbra Half Serif Std",Font.PLAIN,10);
	Font StartFont=new Font("Penumbra Half Serif Std",Font.PLAIN,50);
	static Game game;

	String city ;
	City cityy ;
	City x;
	City q ;
	double costofArchery = 1500;
	double costofBarracks = 2000;
	double costofStable = 2500;
	double treasuryofPlayer ;
	String d;
	double costoffarm =1000;
	double costofmarket =1500;
	double costofcav= 600;
	double costofinfant =500;
	double costofarch=400;
	int counter1,counter2,counter3;
	public FourthWindow() throws IOException {
//		try {
//		     GraphicsEnvironment ge = 
//		         GraphicsEnvironment.getLocalGraphicsEnvironment();
//		     ge.register4Font(Font.createFont(Font.TRUETYPE_FONT, new File("GameFont.ttf")));
//		} 
//		catch (IOException|FontFormatException e) {
//		     //Handle exception
//		}
		city = ThirdWindow.getCityname();

		System.out.print(city);
		 game = ThirdWindow.getGamie();
		double foodofPlayer= game.getPlayer().getFood();

		treasuryofPlayer=game.getPlayer().getTreasury();
	    d =Double.toString(treasuryofPlayer);
		String c = Double.toString(foodofPlayer);
		String nameofPlayer =SecondWindow.getUserInput(); 
		frame = new JFrame();
		frame.setSize(1650,1000);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelTitle = new JPanel();
		panelTitle.setSize(100,150);
		panelTitle.setBackground(Color.black);
		
		if(game.getCurrentTurnCount()>50||game.getPlayer().getControlledCities().size()==game.getAvailableCities().size()||game.getPlayer().getControlledArmies().size()==0) {
			frame.dispose();
			SeventhWindow s = new SeventhWindow();
		}
//		
//		JTextArea fff = new JTextArea();
//		fff.setBounds(10,30,40,100);
//		frame.add(fff);
//		fff.append(nameofPlayer);
//		fff.append(Integer.toString(game.getCurrentTurnCount()));
//       fff.append(Integer.toString((int) game.getPlayer().getTreasury()));

		hiii = new JTextArea();
		hiii.setBounds(1000 , 5, 300,200);
		frame.add(hiii);
		hello = new JTextArea();
		hello.setBounds(1000, 600, 300, 200);
		
		label=new JLabel(nameofPlayer);
		label.setForeground(Color.white);
		label.setFont(TitleFont);
		panelTitle.add(label);
		int numberofturns = game.getCurrentTurnCount();
		String f = Integer.toString(numberofturns);
		label4 = new JLabel(f);
		label4.setForeground(Color.pink);
		label4.setFont(TitleFont);
		label4.setBounds(200, 5, 30, 10);
		frame.add(label4);
		label2 = new JLabel(d);
		label3 = new JLabel(c);
		label2.setForeground(Color.white);
		label2.setFont(TitleFont);
		panelTitle.add(label2);
		label3.setForeground(Color.white);
		label3.setFont(TitleFont);
		panelTitle.add(label3);
		JButton archeryRange = new  JButton();
		archeryRange.setBounds(30, 100, 100, 50);
		archeryRange.setText("ArcheryRange");
		frame.add(archeryRange);
		JButton Barracks= new  JButton();
		Barracks.setBounds(30, 200, 100, 50);
		Barracks.setText("Barracks");

		for (int lang=0; lang < game.getAvailableCities().size();lang++){
					if (game.getAvailableCities().get(lang).getTurnsUnderSiege()>3){
						frame.dispose();
						EighthWindow x=new EighthWindow();
					}
				}
		
		attack = new JButton("Attack");
		attack.setBounds(600,600,100,50);
		frame.add(attack);
		attack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				frame.dispose();
				if(e2.getSource()==attack){
					ChoosingTargetCity f = new ChoosingTargetCity();
			}
		}});
		
		  JButton InitiateArmy = new JButton();
		     InitiateArmy.setBounds(5,550,100,50);
		     frame.add(InitiateArmy);
		     InitiateArmy.setText("InitiateArmy");
		     InitiateArmy.addActionListener(new ActionListener()
				{  

				    public void actionPerformed(ActionEvent e2)
				    { 
				    	for(int h =0;h<game.getPlayer().getControlledCities().size();h++) {
							if(game.getPlayer().getControlledCities().get(h).getName().equals(city)) {
								q =game.getPlayer().getControlledCities().get(h);
								break;
							}}
							for(int r =0;r<q.getDefendingArmy().getUnits().size();r++) {
								
							}

							for(int m =0;m<game.getPlayer().getControlledArmies().size();m++) {
								if(x.getName()==game.getPlayer().getControlledArmies().get(m).getCurrentLocation()) {
									for (int n=0; n<game.getPlayer().getControlledArmies().get(m).getUnits().size();n++) {
											hello.append("Level: "+game.getPlayer().getControlledArmies().get(m).getUnits().get(n).getLevel()+"/n"+
											"Current soldier count: "+game.getPlayer().getControlledArmies().get(m).getUnits().get(n).getCurrentSoldierCount()+"/n"+
											"Max soldier count: "+game.getPlayer().getControlledArmies().get(m).getUnits().get(n).getMaxSoldierCount());
											
									}
								}
								
								
								
							}
						
						
						//if clicking on controlled city button-- close this window and open cityview aka 7thwindow
					}
				    });
		
		
		
		
		
		
		JButton Archer = new JButton();
		Archer.setBounds(200, 400, 100, 50);
		Archer.setText("Archer");
		
		JButton Cavalry= new JButton();
		Cavalry.setBounds(200, 500, 100, 50);
		Cavalry.setText("Cavalry");
		
		JButton Infantry = new JButton();
		Infantry.setBounds(200, 600, 100, 50);
		Infantry.setText("Infantry");
		 
	     JTextArea s = new JTextArea();
	     s.setBounds(700, 500, 300,500);
	     frame.add(s);
	     
	     JButton barracksupgrade = new JButton("Upgrade"+ "\n"+"Barracks");
			barracksupgrade.setBounds(500, 500, 200, 50);
			
			barracksupgrade.addActionListener(new ActionListener()
			{  

			    public void actionPerformed(ActionEvent e2)
			    {
			    	for(int i =0;i<x.getMilitaryBuildings().size();i++) {
			    		if(x.getMilitaryBuildings().get(i) instanceof Barracks) {
			    			frame.add(barracksupgrade);
			    			try {
			    				if(game.getPlayer().getTreasury()<x.getMilitaryBuildings().get(i).getUpgradeCost()) {
			    					JOptionPane.showMessageDialog(null, "CANT UPGRADE!!","Error",JOptionPane.ERROR_MESSAGE);
								
								}else {
									x.getMilitaryBuildings().get(i).upgrade();
									s.append(building("Barracks"));
								}
							} catch (BuildingInCoolDownException | MaxLevelException e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "CANT UPGRADE!!","Error",JOptionPane.ERROR_MESSAGE);
							}
			    		}
			    	}
			    }});
	     
	     JButton stableupgrade = new JButton("Upgrade"+ "\n"+"Stable");
			stableupgrade.setBounds(500, 400, 200, 50);
		
			stableupgrade.addActionListener(new ActionListener()
			{  

			    public void actionPerformed(ActionEvent e2)
			    {
			    	for(int i =0;i<x.getMilitaryBuildings().size();i++) {
			    		if(x.getMilitaryBuildings().get(i) instanceof Stable) {
			    			frame.add(stableupgrade);
			    			try {
			    				if(game.getPlayer().getTreasury()<x.getMilitaryBuildings().get(i).getUpgradeCost()) {
			    					JOptionPane.showMessageDialog(null, "CANT UPGRADE!!","Error",JOptionPane.ERROR_MESSAGE);
								
								}else {
									x.getMilitaryBuildings().get(i).upgrade();
									s.append(building("Stable"));
								}
							} catch (BuildingInCoolDownException | MaxLevelException e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "CANT UPGRADE!!","Error",JOptionPane.ERROR_MESSAGE);
							}
			    		}
			    	}
			    }});
	     
	     JButton archerupgrade = new JButton("Upgrade"+ "\n"+"Archery Range");
			archerupgrade.setBounds(500, 300, 200, 50);
			
			archerupgrade.addActionListener(new ActionListener()
			{  

			    public void actionPerformed(ActionEvent e2)
			    {
			    	for(int i =0;i<x.getMilitaryBuildings().size();i++) {
			    		if(x.getMilitaryBuildings().get(i) instanceof ArcheryRange) {
			    			frame.add(archerupgrade);
			    			try {
			    				if(game.getPlayer().getTreasury()<x.getMilitaryBuildings().get(i).getUpgradeCost()) {
			    					JOptionPane.showMessageDialog(null, "CANT UPGRADE!!","Error",JOptionPane.ERROR_MESSAGE);
								
								}else {
									x.getMilitaryBuildings().get(i).upgrade();
									s.append(building("ArcheryRange"));
								}
							} catch (BuildingInCoolDownException | MaxLevelException e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "CANT UPGRADE!!","Error",JOptionPane.ERROR_MESSAGE);
							}
			    		}
			    	}
			    }});
	     
	 	JButton marketupgrade = new JButton("Upgrade"+ "\n"+"Market");
		marketupgrade.setBounds(500, 200, 200, 50);
		
		
		marketupgrade.addActionListener(new ActionListener()
		{  

		    public void actionPerformed(ActionEvent e2)
		    {
		    	for(int i =0;i<x.getEconomicalBuildings().size();i++) {
		    		if(x.getEconomicalBuildings().get(i) instanceof Market) {
		    			frame.add(marketupgrade);
		    			try {
		    				if(game.getPlayer().getTreasury()<x.getEconomicalBuildings().get(i).getUpgradeCost()) {
		    					JOptionPane.showMessageDialog(null, "CANT UPGRADE!!","Error",JOptionPane.ERROR_MESSAGE);
							
							}else {
								x.getEconomicalBuildings().get(i).upgrade();
								s.append(building("Market"));
							}
						} catch (BuildingInCoolDownException | MaxLevelException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "CANT UPGRADE!!","Error",JOptionPane.ERROR_MESSAGE);
						}
		    		}
		    	}
		    }});
		   
				

		JButton farmupgrade = new JButton("Upgrade"+ "\n"+"Farm");
		farmupgrade.setBounds(500, 100, 200, 50);
		
		farmupgrade.addActionListener(new ActionListener()
		
		
{  

    public void actionPerformed(ActionEvent e2)
    {
    	for(int i =0;i<x.getEconomicalBuildings().size();i++) {
    		if(x.getEconomicalBuildings().get(i) instanceof Farm) {
    			frame.add(farmupgrade);
    			try {
    				if(game.getPlayer().getTreasury()<x.getEconomicalBuildings().get(i).getUpgradeCost()) {
    					JOptionPane.showMessageDialog(null, "You Dont HAVE Enough gold to upgrade","Error",JOptionPane.ERROR_MESSAGE);
					
					}else {
						x.getEconomicalBuildings().get(i).upgrade();
						s.append(building("Farm"));
					}
				} catch (BuildingInCoolDownException | MaxLevelException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "You Dont HAVE Enough gold to upgrade","Error",JOptionPane.ERROR_MESSAGE);
				}
    		}
    	}
    }});
   
		
		
		
		JButton endturn = new  JButton();
		endturn.setBounds(30, 500, 100, 50);
		endturn.setText("End Turn");
		frame.add(endturn);
		endturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(game.getCurrentTurnCount()<40) {
				game.endTurn();
				label4.setText(Integer.toString(game.getCurrentTurnCount()));
			}
				else {
				 JOptionPane.showConfirmDialog(null, "you have 10 turns left!!", "warning!", JOptionPane.CANCEL_OPTION);	
				}
				
			}
	
			
		});
		
		
		
		
		
		Barracks.addActionListener(new ActionListener()
	     {  
        
	         public void actionPerformed(ActionEvent e2)
	         { 
	        	 Barracks.setEnabled(false);
	        	
	        	 try {
	        		 
		        	 game.getPlayer().build("Barracks",city );
		        	frame.add(barracksupgrade);
			         	treasuryofPlayer = treasuryofPlayer - costofBarracks;
			        	String x  = Double.toString(treasuryofPlayer);
			        	label2.setText(x);
			      
			        	frame.add(Infantry);
	        			s.append(building("Barracks"));
	     			
	     			
	     		} catch (NotEnoughGoldException e3) {
	     			// TODO Auto-generated catch block
	     			JOptionPane.showMessageDialog(null, "You Dont HAVE Enough gold to build","Error",JOptionPane.ERROR_MESSAGE);
	     			
	     		}
	     	
	         }
	     });
		frame.add(Barracks);
		
		
			
		JButton Stable= new  JButton();
		Stable.setText("Stable");
		
		Stable.setBounds(30, 300, 100, 50);
		Stable.addActionListener(new ActionListener()
	     {  
        
	         public void actionPerformed(ActionEvent e5)
	         { 
	        	 Stable.setEnabled(false);
	         	
	        	
	        	 try {
	     			
	     			game.getPlayer().build("Stable",city );
	     			frame.add(stableupgrade);
	     			treasuryofPlayer = treasuryofPlayer - costofStable;
		        	String x  = Double.toString(treasuryofPlayer);
		        	label2.setText(x);
		        	frame.add(Cavalry);
		        	s.append(building("Stable"));
	     		} catch (NotEnoughGoldException e3) {
	     			// TODO Auto-generated catch block
	     			JOptionPane.showMessageDialog(null, "You Dont HAVE Enough gold to build","Error",JOptionPane.ERROR_MESSAGE);
	     			
	     		}
	     	
	         }
	     });
		frame.add(Stable);
		
        archeryRange.addActionListener(new ActionListener()
	     {  
        
	         public void actionPerformed(ActionEvent e2)
	         { 
	        	 archeryRange.setEnabled(false);
	         	
	        	 try {
	        	
	     			game.getPlayer().build("ArcheryRange",city );
	     			frame.add(archerupgrade);
	     			treasuryofPlayer = treasuryofPlayer - costofArchery;
		        	String x  = Double.toString(treasuryofPlayer);
		        	label2.setText(x);
		        	frame.add(Archer);
		        	s.append(building("ArcheryRange"));
	     		} catch (NotEnoughGoldException e3) {
	     			// TODO Auto-generated catch block
	     			JOptionPane.showMessageDialog(null, "You Dont HAVE Enough gold to build","Error",JOptionPane.ERROR_MESSAGE);
	     			
	     		}
	     	
	         }
	     });
		panelStart = new JPanel();
		panelStart.setBounds(300, 400, 200, 100);
    	panelStart.setBackground(Color.black);
	
		frame.add(panelTitle);
		frame.add(panelStart);
     	frame.setVisible(true);
     JButton finished = new JButton();
     finished.setText("Worldmap");
     frame.add(finished);
   
		
	
	
		
     finished.addActionListener( new ActionListener()
     { public void actionPerformed(ActionEvent e1) {
    	 frame.dispose();

 		SixthWindow s = new SixthWindow();
 	}
     });
     finished.setBounds(700, 200, 100, 50);
     
 	JButton Farm= new  JButton();
	Farm.setText("Farm");
	Farm.setBounds(200, 100, 100, 50);
	Farm.addActionListener( new  ActionListener()
	{
		public void actionPerformed(ActionEvent e3) {
	try {
		
		game.getPlayer().build("Farm", city);
		Farm.setEnabled(false);
		frame.add(farmupgrade);
		treasuryofPlayer = treasuryofPlayer - costoffarm;
    	String x  = Double.toString(treasuryofPlayer);
    	label2.setText(x);
    	s.append(building("Farm"));
    
	} catch (NotEnoughGoldException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "You Dont HAVE Enough gold to build","Error",JOptionPane.ERROR_MESSAGE);
			
	}
	
		}});
	frame.add(Farm);

	
	JButton Market = new  JButton();
	Market.setText("Market");
	Market.setBounds(200, 200, 100, 50);
	Market.addActionListener( new  ActionListener()
	{
		public void actionPerformed(ActionEvent e3) {
	try {
		
		game.getPlayer().build("Market", city);
		Market.setEnabled(false);
		frame.add(marketupgrade);
		treasuryofPlayer = treasuryofPlayer - costofmarket;
    	String x  = Double.toString(treasuryofPlayer);
    	label2.setText(x);
    	s.append(building("Market"));
    	
	} catch (NotEnoughGoldException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "You Dont HAVE Enough gold to build","Error",JOptionPane.ERROR_MESSAGE);
			
	}
	
		}});
	frame.add(Market);
Cavalry.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			counter3++;
			if(counter3==3)
				Cavalry.setEnabled(false);
			try {
				game.getPlayer().recruitUnit("Cavalry", city);
				for (int k=0; k<x.getDefendingArmy().getUnits().size();k++) {
					
					if (x.getDefendingArmy().getUnits().get(k) instanceof units.Archer) {
									
									hiii.append("Unit number: "+k+"/n"+"Archer"+"Level"+x.getDefendingArmy().getUnits().get(k).getLevel()+"\n"+
									"CURRENT SOldier"+x.getDefendingArmy().getUnits().get(k).getCurrentSoldierCount()+"\n"+
									"Max Soldiers"+x.getDefendingArmy().getUnits().get(k).getMaxSoldierCount()+"\n");
								}else 
									if (x.getDefendingArmy().getUnits().get(k) instanceof units.Cavalry) {
										
										hiii.append("Unit number: "+k+"/n"+"Cavalry"+"Level"+x.getDefendingArmy().getUnits().get(k).getLevel()+"\n"+
										"CURRENT SOldier"+x.getDefendingArmy().getUnits().get(k).getCurrentSoldierCount()+"\n"+
										"Max Soldiers"+x.getDefendingArmy().getUnits().get(k).getMaxSoldierCount()+"\n");
									}else {
										
										
								hiii.append("Unit number: "+k+"/n"+"Infantry"+"Level"+x.getDefendingArmy().getUnits().get(k).getLevel()+"\n"+
								"CURRENT SOldier"+x.getDefendingArmy().getUnits().get(k).getCurrentSoldierCount()+"\n"+
								"Max Soldiers"+x.getDefendingArmy().getUnits().get(k).getMaxSoldierCount()+"\n");
								
							
									}
									

					
				}
				treasuryofPlayer = treasuryofPlayer - costofcav;
		    	String x  = Double.toString(treasuryofPlayer);
		    	label2.setText(x);

			} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}}
		);




Archer.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		counter2++;
		if(counter2==3)
			Archer.setEnabled(false);
		try {
			game.getPlayer().recruitUnit("Archer", city);
			for (int k=0; k<x.getDefendingArmy().getUnits().size();k++) {
				
				if (x.getDefendingArmy().getUnits().get(k) instanceof units.Archer) {
								
								hiii.append("Unit number: "+k+"/n"+"Archer"+"Level"+x.getDefendingArmy().getUnits().get(k).getLevel()+"\n"+
								"CURRENT SOldier"+x.getDefendingArmy().getUnits().get(k).getCurrentSoldierCount()+"\n"+
								"Max Soldiers"+x.getDefendingArmy().getUnits().get(k).getMaxSoldierCount()+"\n");
							}else 
								if (x.getDefendingArmy().getUnits().get(k) instanceof units.Cavalry) {
									
									hiii.append("Unit number: "+k+"/n"+"Cavalry"+"Level"+x.getDefendingArmy().getUnits().get(k).getLevel()+"\n"+
									"CURRENT SOldier"+x.getDefendingArmy().getUnits().get(k).getCurrentSoldierCount()+"\n"+
									"Max Soldiers"+x.getDefendingArmy().getUnits().get(k).getMaxSoldierCount()+"\n");
								}else {
									
									
							hiii.append("Unit number: "+k+"/n"+"Infantry"+"Level"+x.getDefendingArmy().getUnits().get(k).getLevel()+"\n"+
							"CURRENT SOldier"+x.getDefendingArmy().getUnits().get(k).getCurrentSoldierCount()+"\n"+
							"Max Soldiers"+x.getDefendingArmy().getUnits().get(k).getMaxSoldierCount()+"\n");
							
						
								}
								

				
			}
			treasuryofPlayer = treasuryofPlayer - costofarch;
	    	String x  = Double.toString(treasuryofPlayer);
	    	label2.setText(x);
		} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}}
	);
Infantry.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		counter1++;
		if(counter1==3)
			Infantry.setEnabled(false);
		try {
			game.getPlayer().recruitUnit("Infantry", city);
			for (int k=0; k<x.getDefendingArmy().getUnits().size();k++) {
				
				if (x.getDefendingArmy().getUnits().get(k) instanceof units.Archer) {
								
								hiii.append("Unit number: "+k+"/n"+"Archer"+"Level"+x.getDefendingArmy().getUnits().get(k).getLevel()+"\n"+
								"CURRENT SOldier"+x.getDefendingArmy().getUnits().get(k).getCurrentSoldierCount()+"\n"+
								"Max Soldiers"+x.getDefendingArmy().getUnits().get(k).getMaxSoldierCount()+"\n");
							}else 
								if (x.getDefendingArmy().getUnits().get(k) instanceof units.Cavalry) {
									
									hiii.append("Unit number: "+k+"/n"+"Cavalry"+"Level"+x.getDefendingArmy().getUnits().get(k).getLevel()+"\n"+
									"CURRENT SOldier"+x.getDefendingArmy().getUnits().get(k).getCurrentSoldierCount()+"\n"+
									"Max Soldiers"+x.getDefendingArmy().getUnits().get(k).getMaxSoldierCount()+"\n");
								}else {
									
									
							hiii.append("Unit number: "+k+"/n"+"Infantry"+"Level"+x.getDefendingArmy().getUnits().get(k).getLevel()+"\n"+
							"CURRENT SOldier"+x.getDefendingArmy().getUnits().get(k).getCurrentSoldierCount()+"\n"+
							"Max Soldiers"+x.getDefendingArmy().getUnits().get(k).getMaxSoldierCount()+"\n");
							
						
								}
								

				
			}
			treasuryofPlayer = treasuryofPlayer - costofinfant;
	    	String x  = Double.toString(treasuryofPlayer);
	    	label2.setText(x);
		} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}}
	);

	 
	  	
	}


public static void main(String[] args) throws IOException {
	
new FourthWindow();


}

public String building(String f) {
	String info;
	int Level = 0;
	int upgradeCost=0;
	int recruitcost=0;
for(int z=0; z<game.getPlayer().getControlledCities().size();z++) {
	if(game.getPlayer().getControlledCities().get(z).getName().equals(ThirdWindow.getCityname())) {
		x=game.getPlayer().getControlledCities().get(z);
	}
}
for (int i=0;i<x.getEconomicalBuildings().size();i++) {
	if (x.getEconomicalBuildings().get(i) instanceof Market) {
		if(f.equals("Market")) {
		Level=x.getEconomicalBuildings().get(i).getLevel();
		upgradeCost=x.getEconomicalBuildings().get(i).getUpgradeCost();
		//new market button and add to frame
		//remove from drop down list
	}}
	else {
		if(f.equals("Farm")) {
		upgradeCost=x.getEconomicalBuildings().get(i).getUpgradeCost();
		Level=x.getEconomicalBuildings().get(i).getLevel();
	}}
	
	//add level label
	//new small upgrade button and add the cost next to it
}
for (int j=0;j<x.getMilitaryBuildings().size();j++) {
	if (x.getMilitaryBuildings().get(j) instanceof Barracks) {
		if(f.equals("Barracks")) {
		upgradeCost=x.getMilitaryBuildings().get(j).getUpgradeCost();
		Level=x.getMilitaryBuildings().get(j).getLevel();
		recruitcost = x.getMilitaryBuildings().get(j).getRecruitmentCost();
	}}
	else {
		
		if (x.getMilitaryBuildings().get(j) instanceof ArcheryRange) {	
			if(f.equals("ArcheryRange")) {
				upgradeCost=x.getMilitaryBuildings().get(j).getUpgradeCost();
				Level=x.getMilitaryBuildings().get(j).getLevel();
				recruitcost = x.getMilitaryBuildings().get(j).getRecruitmentCost();
			}
		}
		else {
			if(f.equals("Stable")) {
				upgradeCost=x.getMilitaryBuildings().get(j).getUpgradeCost();
			     Level=x.getMilitaryBuildings().get(j).getLevel();
				recruitcost = x.getMilitaryBuildings().get(j).getRecruitmentCost();
			}
		}
		
	}


	
		//------armies stationed in city stats-----
	

	frame.setVisible(false);
	frame.setVisible(true);
	frame.setVisible(false);
	frame.setVisible(true);
}
return f + ": " +" Level, "+ Level + " ,"+upgradeCost + " ,"+recruitcost+"\n";
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


}