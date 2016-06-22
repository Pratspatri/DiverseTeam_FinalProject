package ui;

import item.Armor;
import item.Item;
import item.Keys;
import item.Potions;
import item.Weapon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import lifeform.Goblin;
import lifeform.LifeForm;
import lifeform.Mummy;
import lifeform.Player;
import dungeon.Dungeon;
import dungeon.cell.state.CanWalkThroughState;
import dungeon.cell.state.DoorState;
import dungeon.cell.state.NoWalkThroughState;

public class GameDisplay extends JFrame implements MouseListener
{
	private JLabel envDisplay[][];//map
	private JLabel playerInfro[][];//playerInfor
	private JTextArea selectInfor;
	private Dungeon env;
	private Player player;
	private int inforRow;
	public GameDisplay()
	{
		super();
		env = Dungeon.getDungeonInstance();
		player =(Player)Player.getPlayerInstance();	
		this.setResizable(false);
		this.setBounds(100, 100, 1200,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0,0));
		this.add(this.getEastPanel(), BorderLayout.EAST);
		envDisplay = new JLabel[env.getNumberOfRow()][env.getNumberOfCol()];
		this.add(this.getCenterPanel(), BorderLayout.CENTER);
		inforRow = 7;
		playerInfro = new JLabel[2][inforRow];
		this.add(this.getWestPanel(), BorderLayout.WEST);
		
		this.add(this.getSouthPanel(), BorderLayout.SOUTH);
		
//		this.addWindowListener(new WindowAdapter() 
//        {
//            public void windowClosing(WindowEvent arg0) 
//            {
//                System.exit(0);
//            }
//        });
		this.setVisible(true);
		
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
				envDisplay[i][j].setHorizontalAlignment(JLabel.CENTER);
				envDisplay[i][j].setText(this.getCellText(i, j));
				envDisplay[i][j].addMouseListener(this);
				map.add(envDisplay[i][j]);
		
			}
		}
		map.setBorder(new TitledBorder(new EtchedBorder(), "Map"));

		return map;
	}
	
	public String getCellText(int row, int col)
	{
		String text = "("+row+","+col+")";
		if(env.getState(row, col) instanceof CanWalkThroughState)
		{
			text +="CW";
		}
		else if(env.getState(row, col) instanceof NoWalkThroughState)
		{
			text +="WA";
		}
		else if(env.getState(row, col) instanceof DoorState)
		{
			text +="D";
		}
		else
		{
			text +="|  ";
		}
		
		if(env.getLifeForm(row, col) instanceof Player)
		{
			text +="|P";
		}
		else if(env.getLifeForm(row, col) instanceof Goblin)
		{
			text +="|G";
		}
		else if(env.getLifeForm(row, col) instanceof Mummy)
		{
			text +="|M";
		}
		else
			text +="|  ";
		
		for(int i =0; i<2; i++)
		{
			if(env.getItem(row, col, i) instanceof Weapon)
			{
				text += "|W";
			}
			else if(env.getItem(row, col, i) instanceof Potions)
			{
				text +="|Po";
			}
			else if(env.getItem(row, col, i) instanceof Armor)
			{
				text += "|A";
			}
			else if(env.getItem(row, col, i) instanceof Keys)
			{
				text += "|K";
			}
			else
				text +="|  ";
		}
		return text;	
			
	}
	public JPanel getEastPanel()
	{
		JPanel legend = new JPanel();
		legend.setLayout(new GridLayout(18, 1));
		
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
		
		JLabel L10 = new JLabel(" WA = Wall");
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
		legend.setBorder(new TitledBorder(new EtchedBorder(), "Legend"));

		return legend;
	}
	
	public JPanel getWestPanel()
	{	
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(1, 2,1,0));
		
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(7, 1));
		left.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfro[0][0]  = new JLabel("Name: ");
		left.add(playerInfro[0][0]);
		
		
		playerInfro[0][1]  = new JLabel("Armor: ");
		playerInfro[0][1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		left.add(playerInfro[0][1]);
		
		playerInfro[0][2]  = new JLabel("Weapon: ");
		playerInfro[0][2].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		left.add(playerInfro[0][2]);
		
		playerInfro[0][3]  = new JLabel("LifePoint: ");
		playerInfro[0][3].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		left.add(playerInfro[0][3]);
		
		playerInfro[0][4]  = new JLabel("Strength: ");
		playerInfro[0][4].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		left.add(playerInfro[0][4]);
		
		playerInfro[0][5]  = new JLabel("HitPoint: ");
		playerInfro[0][5].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		left.add(playerInfro[0][5]);
		
		playerInfro[0][6]  = new JLabel("Experience: ");
		playerInfro[0][6].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		left.add(playerInfro[0][6]);
		
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(7, 1));
		right.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		for(int i =0; i<7;i++)
		{
			playerInfro[1][i] = new JLabel();
			playerInfro[1][i].setText(setPlayInfor(i));
			playerInfro[1][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			playerInfro[1][i].setHorizontalAlignment(JLabel.CENTER);
			right.add(playerInfro[1][i]);
			
		}
		
		west.add(left);
		west.add(right);
		west.setBorder(new TitledBorder(new EtchedBorder(), "Player InFormation"));

		return west;
	}
	public String setPlayInfor(int inforRow)
	{
		if(inforRow==0)
		{
			return player.getName();
		}
		else if(inforRow ==1)
		{
			return player.getWeaponDescription();
		}
		else if(inforRow ==2 )
		{
			return player.getArmorDescription();
		}
		else if(inforRow ==3)
		{
			return ""+player.getLifePoints();
		}
		else if(inforRow ==4)
		{
			return ""+player.getStrength();
		}
		else if(inforRow ==5)
		{
			return ""+player.getHitPoints();
		}
		else if(inforRow ==6)
		{
			return ""+player.getExpPoints();
		}
		else
			return "Error!";
			
	}
	
	public JPanel getSouthPanel()
	{
		JPanel south = new JPanel();
		south.setLayout(new BorderLayout(0,0));
		selectInfor = new JTextArea();
		selectInfor.setRows(3);
		selectInfor.setEditable(false);
		south.add(selectInfor,BorderLayout.CENTER);
		south.setBorder(new TitledBorder(new EtchedBorder(), "Select InFormation"));
		return south;
	}
	
	public static void main(String[] argv)
	{
		JFrame jf = new GameDisplay();
	}
	
	private String printCellInfor(int row, int col)
	{
		String text = "LifeForm--";
		if(env.getLifeForm(row, col)!=null)
		{
			LifeForm temp = env.getLifeForm(row, col);
			text += " Name:" + temp.getName()+" ";
			text += " LifePoints:"+temp.getLifePoints()+" ";
			text += " HitPoints:"+temp.getHitPoints()+" ";
			text += " Strength:"+ temp.getStrength()+" ";
			text += " AttackDistance:"+temp.getAttackDistance()+".";
		}
		else
		{
			text +="";
		}
		text+="\nItem1--";
		if(env.getItem(row, col, 0)!=null)
		{
			Item item = env.getItem(row, col, 0);
			//text +="Name:"+ item.
		}
		else
		{
			text +="";
		}
		text+="\nItem2--";
		
		return text;
	}
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		JLabel temp = (JLabel)arg0.getSource();
		String infor = temp.getText();
		int end = infor.indexOf(',');
		int row = Integer.parseInt(infor.substring(1, end));
		int end2 = infor.indexOf(')');
		int col = Integer.parseInt(infor.substring(end+1, end2));
		selectInfor.setText(this.printCellInfor(row, col));
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
