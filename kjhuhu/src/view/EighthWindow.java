package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.City;
import engine.Game;
import exceptions.FriendlyFireException;
import units.Army;
import units.Unit;

//----- battle view -----

public class EighthWindow {
	JComboBox combo,combo1;
	Unit unitattacker,unitdefender;
	JFrame frame;
	JLabel label;
	ArrayList<String> attackerarray, cityarray;							
	JPanel panel;
	Army defending = ChoosingTargetCity.army;
	JTextArea ffffff,dddd;
String name =ChoosingTargetCity.cityattack;
Game game;
City city;
Army attacker;
Unit s;
	public EighthWindow() {
		
		game=FourthWindow.game;
		
			for(int h =0;h<game.getAvailableCities().size();h++) {
				if(game.getAvailableCities().get(h).getName().equals(name))
					city =game.getAvailableCities().get(h);
			}
			
			
			for(int y=0;y<game.getPlayer().getControlledArmies().size();y++) {
				if(game.getPlayer().getControlledArmies().get(y).getCurrentLocation().equals(city.getName())) {
				attacker=game.getPlayer().getControlledArmies().get(y);
				}}
		frame = new JFrame();
		frame.setSize(1600, 1200); 
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("EmpireBuilding");
		frame.setVisible(true);
		if(game.getCurrentTurnCount()>50||game.getPlayer().getControlledCities().size()==game.getAvailableCities().size()||game.getPlayer().getControlledArmies().size()==0) {
			frame.dispose();
			SeventhWindow s = new SeventhWindow();
		}
	
 //The relevant information should be displayed for each unit
		//2 for loops-- goes through all units of army-- displays level,etc.
	
	
		ffffff = new JTextArea();
		ffffff.setBounds(900, 5, 300, 500);
				for (int i=0; i<attacker.getUnits().size();i++) {
						ffffff.append("Level: "+ attacker.getUnits().get(i).getLevel()+"/n"+"Current solider count: "+
						attacker.getUnits().get(i).getCurrentSoldierCount()+ "Max soldier count: "+
						attacker.getUnits().get(i).getMaxSoldierCount()+"/n");
						
				}
			
		
	 //-----defending army of city-----
				for (int j=0; j<city.getDefendingArmy().getUnits().size();j++) {
					ffffff.append("Level: "+ city.getDefendingArmy().getUnits().get(j).getLevel()+"/n"+"Current solider count: "+
					city.getDefendingArmy().getUnits().get(j).getCurrentSoldierCount()+ "Max soldier count: "+
					city.getDefendingArmy().getUnits().get(j).getMaxSoldierCount()+"/n");
					
			}
				
				// ----- attack manual -----
				
		
		
			
			for(int j =0; j<attacker.getUnits().size(); j++) {
				
				if(attacker.getUnits().get(j) instanceof units.Archer) {
				
					String result = "Type: Archer"+ " , "+ "Level: " + attacker.getUnits().get(j).getLevel() + " , " +"CurrRec: " + attacker.getUnits().get(j).getCurrentSoldierCount();
					panel.add(new JLabel(result));
					combo.add(panel);
					  s= attacker.getUnits().get(j);
					combo.addActionListener(new ActionListener()
					{ 
					    public void actionPerformed(ActionEvent e2)
					    {unitattacker=s;
				}});
				if(attacker.getUnits().get(j) instanceof units.Cavalry) {
					 result = "Type: Cavalry"+ " , "+ "Level: " + attacker.getUnits().get(j).getLevel() + " , " +"CurrRec: " + attacker.getUnits().get(j).getCurrentSoldierCount();
					panel.add(new JLabel(result));
					combo.add(panel);
					 s =attacker.getUnits().get(j);
					combo.addActionListener(new ActionListener()
					{  

					    public void actionPerformed(ActionEvent e2)
					    {unitattacker=s;
				}});
				}
			
				}
				if(attacker.getUnits().get(j) instanceof units.Infantry) {
					 String result = "Type: Infantry"+ " , "+ "Level: " + attacker.getUnits().get(j).getLevel() + " , " +"CurrRec: " + attacker.getUnits().get(j).getCurrentSoldierCount();
					panel.add(new JLabel(result));
					combo.add(panel);
					Unit s= attacker.getUnits().get(j);
					combo.addActionListener(new ActionListener()
					{  

					    public void actionPerformed(ActionEvent e2)
					    {unitattacker=s;
				}});
				}
			
				
			
			}
			
					for(int h =0; h<city.getDefendingArmy().getUnits().size(); h++) {
						
						if(city.getDefendingArmy().getUnits().get(h) instanceof units.Archer) {
							String result = "Type: Archer" + " , " + "Level: " +city.getDefendingArmy().getUnits().get(h).getLevel() + " , " + "CurrRec: "+city.getDefendingArmy().getUnits().get(h).getCurrentSoldierCount();
							panel.add(new JLabel(result));
					combo1.add(panel);
					Unit s= city.getDefendingArmy().getUnits().get(h);
					combo1.addActionListener(new ActionListener()
					{  

					    public void actionPerformed(ActionEvent e2)
					    {unitdefender=s;
				}});
						}
						if(city.getDefendingArmy().getUnits().get(h) instanceof units.Infantry) {
							String result = "Type: Infantry" + " , " + "Level: " +city.getDefendingArmy().getUnits().get(h).getLevel() + " , " + "CurrRec: "+city.getDefendingArmy().getUnits().get(h).getCurrentSoldierCount();;
							panel.add(new JLabel(result));
					combo1.add(panel);
					Unit s=city.getDefendingArmy().getUnits().get(h);
					combo1.addActionListener(new ActionListener()
					{  

					    public void actionPerformed(ActionEvent e2)
					    {unitdefender=s;
				}});
						}
						if(city.getDefendingArmy().getUnits().get(h) instanceof units.Cavalry) {
							String result = "Type: Cavalry" + " , " + "Level: " +city.getDefendingArmy().getUnits().get(h).getLevel() + " , " + "CurrRec: "+city.getDefendingArmy().getUnits().get(h).getCurrentSoldierCount();
							panel.add(new JLabel(result));
					combo1.add(panel);
					Unit s=city.getDefendingArmy().getUnits().get(h);
					combo1.addActionListener(new ActionListener()
					{  

					    public void actionPerformed(ActionEvent e2)
					    {unitdefender=s;
				}});
						}
					}
				
					
		
			//units i picked

				
				int defendersoldierslost = unitdefender.getCurrentSoldierCount();
				try {
					unitattacker.attack(unitdefender);
				} catch (FriendlyFireException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				defendersoldierslost-=unitdefender.getCurrentSoldierCount();
				while (city.getDefendingArmy().getUnits().size() != 0 && city.getDefendingArmy().getUnits().size() != 0) {
					int turn=1;
					
					
					Unit unit1 = attacker.getUnits().get((int) (Math.random() * attacker.getUnits().size()));
					int unit1soldierslost= unit1.getCurrentSoldierCount();
					Unit unit2 = city.getDefendingArmy().getUnits().get((int) (Math.random() * city.getDefendingArmy().getUnits().size()));
					int unit2soldierslost= unit2.getCurrentSoldierCount();
					if (turn == 1) {
						try {
							unit1.attack(unit2);
						} catch (FriendlyFireException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						unit1soldierslost-=unit1.getCurrentSoldierCount();
						dddd.append("Soldiers lost: "+ unit1soldierslost);
						
					}
					else {
						try {
							unit2.attack(unit1);
						} catch (FriendlyFireException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						unit2soldierslost-=unit2.getCurrentSoldierCount();
						dddd.append("Soliders lost: "+ unit2soldierslost);
						
					}
					turn = turn == 1 ? 0 : 1;
				}
				if (city.getDefendingArmy().getUnits().size() == 0) {
					
					dddd.append("Attacker won");
					game.occupy(attacker, city.getDefendingArmy().getCurrentLocation());
					frame.dispose();
					SixthWindow s = new SixthWindow();
				}
				else {
					
				
					dddd.append("Defender won");
					//dispose window
				}
					
				//-----autoresolve-----
				
				try {
					game.autoResolve(attacker,city.getDefendingArmy());
				} catch (FriendlyFireException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (city.getDefendingArmy().getUnits().size() == 0) {
					
					
					dddd.append("Attacker won");
					
					frame.dispose();
					
					SixthWindow s = new SixthWindow();
				}
				else {
					
				
					dddd.append("Defender won");
				frame.dispose();
					
				}

//A log that describes the flow of the battle.
	// ????


		//change variables
		combo = new JComboBox(cityarray.toArray());
		combo.setBounds(300, 300, 300, 300);
		//panel.add(comboBox);
		
		combo1 = new JComboBox(attackerarray.toArray());
		combo1.setBounds(300, 300, 300, 300);
		//panel1.add(comboBox1);
	}
}
