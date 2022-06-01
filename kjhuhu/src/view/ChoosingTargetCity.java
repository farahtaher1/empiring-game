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
import units.Army;

public class ChoosingTargetCity {
	private JPanel panelTitle,panelStart;
	private JFrame frame;

	private JButton startButton;
	private JLabel label;
	private int idlearmy;
JComboBox choosearmy;
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
	static String cityattack;
	ArrayList<Army>ControlArmies;
	static Army army;
	int Level1,MaxSold1,CurrentSold1,Level2,MaxSold2,CurrentSold2,Level3,MaxSold3,CurrentSold3;
	public ChoosingTargetCity() {

		frame = new JFrame();
		frame.setSize(1500,1000); // changed size of screen
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("EmpireBuilding");
		frame.setVisible(true);
		
		
	    Cairo = new JButton("Cairo ");
	     Cairo.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent e2)
	         { cityattack = "Cairo";
	         for(int j =0;j<x.getAvailableCities().size();j++) {
	        	 if(x.getAvailableCities().get(j).equals("Cairo")) {
	        		 army = x.getAvailableCities().get(j).getDefendingArmy();
	        	 }
	         }
	         }});
	     Cairo.setFont(TitleFont);
	     Cairo.setBounds(500, 500, 200, 50);
	     frame.add(Cairo);
	     Sparta = new JButton("Sparta ");
	     Sparta.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent e2)
	         { cityattack = "Sparta";
	         for(int j =0;j<x.getAvailableCities().size();j++) {
	        	 if(x.getAvailableCities().get(j).equals("Sparta")) {
	        		 army = x.getAvailableCities().get(j).getDefendingArmy();
	        	 }
	         }
	        
	         }});
	     Sparta.setFont(TitleFont);
	     Sparta.setBounds(200, 500, 200, 50);
	     frame.add(Sparta);
	     Rome = new JButton("Rome ");
	     Rome.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent e2)
	         { cityattack="Rome";
	         for(int j =0;j<x.getAvailableCities().size();j++) {
	        	 if(x.getAvailableCities().get(j).equals("Rome")) {
	        		 army = x.getAvailableCities().get(j).getDefendingArmy();
	        	 }
	         }
	         }});
	     
	     
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
		    	 
		     }}
	     public static void main(String[]args) {
	    	 new ChoosingTargetCity();
	     }
}