package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dungeon.Dungeon;
import dungeon.cell.state.CanWalkThroughState;

public class GameDisplay extends JFrame
{
	private JLabel envDisplay[][];
	private Dungeon env;
	public GameDisplay()
	{
		super();
		env = Dungeon.getDungeonInstance();
		setVisible(true);
		this.setResizable(false);
		this.setBounds(100, 100, 821, 473);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0,0));
		this.add(this.getEastPanel(), BorderLayout.EAST);
		envDisplay = new JLabel[env.getNumberOfRow()][env.getNumberOfCol()];
		this.add(this.getCenterPanel(), BorderLayout.CENTER);
		
	}
	public JPanel getCenterPanel()
	{
		JPanel map = new JPanel();
		map.setLayout(new GridLayout(env.getNumberOfRow(), env.getNumberOfCol(), 0, 0));
		for(int i = 0; i<env.getNumberOfRow();i++)
		{
			for(int j = 0; j<env.getNumberOfCol();j++)
			{				
				envDisplay[i][j] = new JLabel();
				envDisplay[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				envDisplay[i][j].setText("cw\n"+"P\n"+"n\n"+"W|K");
				map.add(envDisplay[i][j]);
		
			}
		}
		return map;
	}
	
	public void setCellText(int row, int col)
	{
		String text = "";
		if(env.getState(row, col) instanceof CanWalkThroughState)
		{
			
		}
		
	}
	public JPanel getEastPanel()
	{
		JPanel legend = new JPanel();
		legend.setLayout(new GridLayout(18, 1));
		JLabel L1 = new JLabel(" Legend");
		legend.add(L1);
		
		JLabel L2 = new JLabel(" P = Player");
		legend.add(L2);
		
		JLabel L3 = new JLabel(" M = Mummy");
		legend.add(L3);
		
		JLabel L4 = new JLabel(" G = Goblin");
		legend.add(L4);
		
		JLabel L5 = new JLabel(" W = Weapon");
		legend.add(L5);
		
		JLabel L6 = new JLabel(" K = Key");
		legend.add(L6);
		
		JLabel L7 = new JLabel(" Po = Potions");
		legend.add(L7);
		
		JLabel L8 = new JLabel(" A = Armor");
		legend.add(L8);
		
		JLabel L9 = new JLabel(" CW = Can Walk");
		legend.add(L9);
		
		JLabel L10 = new JLabel(" Wa = Wall");
		legend.add(L10);
		
		JLabel L11 = new JLabel(" D = Door");
		legend.add(L11);
		
//		JLabel L12 = new JLabel(" A|PC = Alien with PlasmaCannon");
//		legend.add(L12);
//		
//		JLabel L13 = new JLabel(" A|CG = Alien with ChainGun");
//		legend.add(L13);
//		
//		JLabel L14 = new JLabel(" H|P = Human with Pistol");
//		legend.add(L14);
//		
//		JLabel L15 = new JLabel(" H|PC = Human with PlasmaCannon");
//		legend.add(L15);
//		
//		JLabel L16 = new JLabel(" H|CG = Human with ChainGun");
//		legend.add(L16);
		return legend;
	}
	
	public static void main(String[] argv)
	{
		JFrame jf = new GameDisplay();
	}
}
