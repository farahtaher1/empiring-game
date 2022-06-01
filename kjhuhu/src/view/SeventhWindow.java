package view;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import engine.Game;

public class SeventhWindow{
JFrame frame;
JLabel label;
Game game =FourthWindow.game;
SeventhWindow() {
	frame = new JFrame();
        frame.setSize(1600, 1200); 
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("EmpireBuilding");
        frame.setVisible(true);
		if (game.getPlayer().getControlledCities().size()==game.getAvailableCities().size())
			label= new JLabel("Player won");
		if (game.getPlayer().getControlledArmies().size()==0)
			label = new JLabel("Player lost");
		frame.add(label);
	}
	public static void main(String[] args){
		new SeventhWindow();
	}
	}