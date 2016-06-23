package ui;

import item.Armor;
import item.FactoryArmor;
import item.FactoryWeapon;
import item.Item;
import item.KeyFactory;
import item.Keys;
import item.PotionFactory;
import item.Potions;
import item.Weapon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
import Command.Invoker;
import Command.InvokerBuilder;
import dungeon.Dungeon;
import dungeon.cell.state.CanWalkThroughState;
import dungeon.cell.state.DoorState;
import dungeon.cell.state.NoWalkThroughState;
import dungeon.cell.state.StateFactory;

public class GameDisplay extends JFrame implements MouseListener, KeyListener
{
	private JLabel envDisplay[][];//map
	private JLabel playerInfro[][];//playerInfor
	private JTextArea selectInfor,selectInventory;
	private JFrame inventoryFrame;
	private ArrayList<JLabel> inventoryLabel;
	private Invoker invoker;
	private Dungeon env;
	private Player player;
	private int inforRow;
	private boolean whichFrame;
	public GameDisplay()
	{
		super();
		SimpleSetForDungeon();
		env = Dungeon.getDungeonInstance();
		player =(Player)Player.getPlayerInstance();
		this.whichFrame = true;
		InvokerBuilder invokerFactory = new InvokerBuilder();
		invoker = invokerFactory.getInvoker(player);
		inventoryFrame = new JFrame("Inventory");
		inventoryFrame.setLayout(new BorderLayout(0,0));
		inventoryLabel =  new ArrayList<JLabel>();
		inventoryFrame.add(GetsInventory(),BorderLayout.CENTER);
		
		
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
		setFocusable(true);
		addKeyListener(this);
		
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
		LifeForm temp = env.getLifeForm(row, col);
		if(env.getLifeForm(row, col) instanceof Player)
		{
			text +="|P"+exchangDirection(temp.getDirection());
		}
		else if(env.getLifeForm(row, col) instanceof Goblin)
		{
			text +="|G"+exchangDirection(temp.getDirection());
		}
		else if(env.getLifeForm(row, col) instanceof Mummy)
		{
			text +="|M"+exchangDirection(temp.getDirection());
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
		
		JLabel L12 = new JLabel(" n = face north");
		legend.add(L12);
		
		JLabel L13 = new JLabel(" s = face south");
		legend.add(L13);		
		JLabel L14 = new JLabel(" e = face east");
		legend.add(L14);
		
		JLabel L15 = new JLabel(" w = face west");
		legend.add(L15);
		
		JLabel L16 = new JLabel(" 0 = face error");
		legend.add(L16);
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
	
	public void update()
	{
		for(int i =0;i<env.getNumberOfRow();i++)
		{
			for(int j =0;j<env.getNumberOfCol();j++)
			{
				envDisplay[i][j].setText(this.getCellText(i, j));
			}
		}
		for(int i =0;i<this.inforRow;i++)
		{
			playerInfro[1][i].setText(this.setPlayInfor(i));
		}
		for(int i =0;i<this.inventoryLabel.size();i++)
		{
			
		}
	}
	
	
	private String printCellInfor(int row, int col)
	{
		String text = "LifeForm--";
		if(env.getLifeForm(row, col)!=null)
		{
			LifeForm temp = env.getLifeForm(row, col);
			text += " Name: " + temp.getName()+" ";
			text += " LifePoints: "+temp.getLifePoints()+" ";
			text += " HitPoints: "+temp.getHitPoints()+" ";
			text += " Strength: "+ temp.getStrength()+" ";
			text += " AttackDistance: "+temp.getAttackDistance()+".";
		}
		else
		{
			text +="";
		}
		text+="\nItem1--";
		if(env.getItem(row, col, 0)!=null)
		{
			Item item = env.getItem(row, col, 0);
			if(item instanceof Weapon)
			{
				Weapon it = (Weapon)item;
				text +=" Weapon: "+it.getDescribtion();
				text +=" BaseDamage: "+it.getBaseDamge();
				text +=" Max Range: "+it.getMaxrRange();
			}
			else if(item instanceof Armor)
			{
				Armor am = (Armor)item;
				text +=" Armor: "+ am.getDescription();
				text +=" ArmorPoint: "+am.getArmorPoints();
			}
			else if(item instanceof Potions)
			{
				Potions po = (Potions)item;
				text += " Potion: ";
				text += " Amount: "+ po.getAmount();
			}
			else if(item instanceof Keys)
			{
				Keys key = (Keys) item;
				text += " Key: ";
				text += "Keyid: "+key.getKey();
			}
			else
			{
				text += " Unknow Item ";
			}
			
		}
		else
		{
			text +="";
		}
		text+="\nItem2--";
		if(env.getItem(row, col, 1)!=null)
		{
			Item item = env.getItem(row, col, 1);
			if(item instanceof Weapon)
			{
				Weapon it = (Weapon)item;
				text +=" Weapon: "+it.getDescribtion();
				text +=" BaseDamage: "+it.getBaseDamge();
				text +=" Max Range: "+it.getMaxrRange();
			}
			else if(item instanceof Armor)
			{
				Armor am = (Armor)item;
				text +=" Armor: "+ am.getDescription();
				text +=" ArmorPoint: "+am.getArmorPoints();
			}
			else if(item instanceof Potions)
			{
				Potions po = (Potions)item;
				text += " Potion: ";
				text += " Amount: "+ po.getAmount();
			}
			else if(item instanceof Keys)
			{
				Keys key = (Keys) item;
				text += " Key: ";
				text += "Keyid: "+key.getKey();
			}
			else
			{
				text += " Unknow Item ";
			}
			
		}
		else
		{
			text +="";
		}
		
		return text;
	}
	private String exchangDirection(String direction)
	{
		if(direction==null)
		{
			return "0";
		}
		else if(direction.compareToIgnoreCase("north")==0)
		{
			return "n";
		}
		else if(direction.compareToIgnoreCase("south")==0)
		{
			return "s";
		}
		else if(direction.compareToIgnoreCase("east")==0)
		{
			return "e";
		}
		else if(direction.compareToIgnoreCase("west")==0)
		{
			return "w";
		}
		else
			return "0";
	}
	
	private JPanel GetsInventory()
	{
		JPanel inventory = new JPanel();
		inventory.setLayout(new BorderLayout(0,0));
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(player.getInventorySize()/5, 5, 0, 0));
		center.setBorder(new TitledBorder(new EtchedBorder(), "Inventory"));
		for(int i =0;i < player.getInventorySize();i++)
		{
			JLabel a = new JLabel();
			a.setHorizontalAlignment(JLabel.CENTER);
			a.setText(inventoryInFor(i));
			a.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			a.addMouseListener(this);
			inventoryLabel.add(a);
			center.add(inventoryLabel.get(i));
			
		}
		
		selectInventory = new JTextArea();
		selectInventory.setRows(3);
		selectInventory.setEditable(false);
		selectInventory.setBorder(new TitledBorder(new EtchedBorder(), "Detial"));
		
		inventory.add(center, BorderLayout.CENTER);
		inventory.add(selectInventory, BorderLayout.SOUTH);
		return inventory;
	}
	
	private String inventoryInFor(int index)
	{
		if(player.getItemFromInventory(index) instanceof Weapon)
		{
			return index+". Weapon";
		}
		else if(player.getItemFromInventory(index) instanceof Armor)
		{
			return index+". Armor";
		}
		else if(player.getItemFromInventory(index) instanceof Potions)
		{
			return index+". Potions";
		}
		else if(player.getItemFromInventory(index) instanceof Keys)
		{
			return index+". Key";
		}
		else
			return "";
	}
	private String printItemDetailInInventory(int index)
	{
		Item temp = player.getItemFromInventory(index);
		if(temp instanceof Weapon)
		{
			Weapon wp = (Weapon)temp;
			return "Weapon: "+wp.getDescribtion()+", BaseDamage: "+wp.getBaseDamge()+", MaxRange: "+wp.getMaxrRange()
					+ ".";
		}
		else if(temp instanceof Armor)
		{
			Armor am = (Armor)temp;
			return "Armor: "+am.getDescription()+", ArmorPoints:"+am.getArmorPoints()+".";
		}
		else if(temp instanceof Potions)
		{
			Potions po = (Potions)temp;
			 po.taken(player.getStrength());
			return "Potions: After drink strenght will be:"+ po.getAmount();
		}
		else if(temp instanceof Keys)
		{
			Keys key = (Keys)temp;
			return  "Key: "+ key.idKey;
		}
		else
			return "Nothing";
	}
	private void SimpleSetForDungeon()
	{
		Dungeon dun = Dungeon.getDungeonInstance();
		Player player = (Player)Player.getPlayerInstance();
		StateFactory factory = new StateFactory();
		dun.setState(0, 0,factory.getState(StateFactory.WALL) );
		dun.setState(0, 1,factory.getState(StateFactory.WALL) );
		dun.setState(0, 2,factory.getState(StateFactory.WALL) );
		dun.setState(0, 3,factory.getState(StateFactory.WALL) );
		dun.setState(0, 4,factory.getState(StateFactory.WALL) );
		dun.setState(0, 5,factory.getState(StateFactory.WALL) );
		dun.setState(0, 6,factory.getState(StateFactory.WALL) );
		dun.setState(0, 7,factory.getState(StateFactory.WALL) );
		dun.setState(1, 7,factory.getState(StateFactory.WALL) );
		dun.setState(2, 7,factory.getState(StateFactory.WALL) );
		dun.setState(3, 7,factory.getState(StateFactory.WALL) );
		dun.setState(4, 7,factory.getState(StateFactory.WALL) );
		dun.setState(5, 7,factory.getState(StateFactory.WALL) );
		dun.setState(6, 7,factory.getState(StateFactory.WALL) );
		dun.setState(1, 0,factory.getState(StateFactory.WALL) );
		dun.setState(2, 0,factory.getState(StateFactory.WALL) );
		dun.setState(3, 0,factory.getState(StateFactory.WALL) );
		dun.setState(4, 0,factory.getState(StateFactory.WALL) );
		dun.setState(5, 0,factory.getState(StateFactory.WALL) );
		dun.setState(6, 0,factory.getState(StateFactory.WALL) );
		dun.setState(7, 0,factory.getState(StateFactory.WALL) );
		dun.setState(7, 1,factory.getState(StateFactory.WALL) );
		dun.setState(7, 2,factory.getState(StateFactory.WALL) );
		dun.setState(7, 3,factory.getState(StateFactory.WALL) );
		dun.setState(7, 4,factory.getState(StateFactory.WALL) );
		dun.setState(7, 6,factory.getState(StateFactory.WALL) );
		dun.setState(7, 7,factory.getState(StateFactory.WALL) );
		dun.setState(7, 5,factory.getState(StateFactory.KEY) );
		FactoryWeapon wf = new FactoryWeapon();
		FactoryArmor af = new FactoryArmor();
		PotionFactory pf = new PotionFactory();
		KeyFactory kf =  new KeyFactory();
		Weapon holdwp = wf.buildWeapon("gun");
		Armor holdam = af.buildArmor("normalarmor");
		Item potion = pf.PotionFactory("AntiPoison");
		Item key = kf.KeysFactory(1);
		LifeForm gublin = new Goblin("Goblin",30,10);
		LifeForm mummy = new Mummy("Mummy",50,40);
		player.pickUpWeapon(holdwp);
		player.setArmor(holdam);	
		player.SetDirection("North");
		dun.addLifeForm(4, 4, player);
		dun.addItem(4, 5, potion, 0);
		dun.addLifeForm(3, 6, gublin);
		dun.addLifeForm(6, 6, mummy);
		dun.addItem(6, 6, key, 0);
		dun.addItem(4, 4,wf.buildWeapon("gun"), 0);
		dun.addItem(4, 4, af.buildArmor("normalarmor"), 1);
		
		//add something to inventory.
		Weapon inwp =  wf.buildWeapon("sword");
		Armor inam = af.buildArmor("sharparmor");
		Item inpotion = pf.PotionFactory("AlihotsyDraught");
		Item inkey = kf.KeysFactory(2);
		player.addToInventory(inwp);
		player.addToInventory(inam);
		player.addToInventory(inpotion);
		player.addToInventory(inkey);
	}
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		JLabel temp = (JLabel)arg0.getSource();
		if(inventoryLabel.contains(temp))
		{
			if(temp.getText()!="")
			{
				String infor = temp.getText();
				int end = infor.indexOf('.');
				int index = Integer.parseInt(infor.substring(0, end));
				player.useItem(index);
				update();
			}
		}
		else
		{
			String infor = temp.getText();
			int end = infor.indexOf(',');
			int row = Integer.parseInt(infor.substring(1, end));
			int end2 = infor.indexOf(')');
			int col = Integer.parseInt(infor.substring(end+1, end2));
			selectInfor.setText(this.printCellInfor(row, col));
			
		}
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		JLabel temp = (JLabel)arg0.getSource();
		if(inventoryLabel.contains(temp))
		{
			if(temp.getText()!="")
			{
				String infor = temp.getText();
				int end = infor.indexOf('.');
				int index = Integer.parseInt(infor.substring(0, end));
				selectInventory.setText(this.printItemDetailInInventory(index));
			}
		}
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
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		int k = arg0.getKeyCode();
		
		if(k == KeyEvent.VK_UP)
		{
			if(player.getDirection().compareToIgnoreCase("North")==0)
			{
				invoker.move();
			}
			else
			{
				invoker.TurnNorth();
			}
			this.update();
			
		}
		else if(k == KeyEvent.VK_DOWN)
		{
			if(player.getDirection().compareToIgnoreCase("South")==0)
			{
				invoker.move();
			}
			else
			{
				invoker.TurnSouth();
			}
			this.update();
		}
		else if(k == KeyEvent.VK_RIGHT)
		{
			if(player.getDirection().compareToIgnoreCase("East")==0)
			{
				invoker.move();
			}
			else
			{
				invoker.TurnEast();
			}
			this.update();
		}
		else if(k == KeyEvent.VK_LEFT)
		{
			if(player.getDirection().compareToIgnoreCase("West")==0)
			{
				invoker.move();
			}
			else
			{
				invoker.TurnWest();
			}
			this.update();
		}
		else if(k == KeyEvent.VK_A)
		{
			invoker.attackCm();
		}
		else if(k == KeyEvent.VK_D)
		{
			//invoker;
		}
		else if(k == KeyEvent.VK_1)
		{
			inventoryFrame.setVisible(true);
			inventoryFrame.setBounds(500, 500, 600,400);
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
		
	}
	
	public static void main(String[] argv)
	{
		JFrame jf = new GameDisplay();
		
	}
}
