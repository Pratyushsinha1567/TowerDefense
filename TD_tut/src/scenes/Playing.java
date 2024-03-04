package scenes;

import static main.GameState.MENU;
import static main.GameState.SetGameState;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import static main.GameState.*;

import hlp.LoadSave;
import hlp.lvlbld;
import main.Game;
import managers.TileManager;
import managers.TowerManager;
import managers.enemymanager;
import objects.Towers;
import objects.tile;
import userinterface.ActionBar;
//import userinterface.bottombar;
import userinterface.buttons;

public class Playing extends GameScene implements SceneMethods {

	private int[][] lvl;
	private TileManager tilemanager ;
	//private bottombar bottombar;
	private tile selectedtile;
	private TowerManager towermanager;
	private int mousex,mousey;
	private int snapx,snapy;
	
	private ActionBar actionbar;
	

	private enemymanager enemymanager;
	private Towers selectedTower;

	//buttons
	
	public TileManager gettilemanager() {
		return tilemanager;
	}
	
	public Playing(Game game) {
		super(game);
		this.lvl = lvlbld.getlvldata();
		tilemanager = new TileManager();
		//bottombar = new bottombar(1180,0,100,1024,this);
		actionbar = new ActionBar(0, 580, 640, 100, this);
		System.out.println("in playing");
		towermanager=new TowerManager(this);
		enemymanager = new enemymanager(this);
		
		
	}
	private void loaddefaultlevel() {
		this.lvl= LoadSave.GetLevelData("new"); 
		
	}

		
		
	private BufferedImage getspriteint(int id) {
		return getGame().getTileManager().getsprite(id);
	}
	
	public void setlevel(int[][] lvl) {
		this.lvl = lvl;
	}

	


	@Override
	public void render(Graphics g) {
		
		for(int y=0;y<lvl.length;y++) {
			
			for(int x =0;x<(lvl[y]).length;x++) {
				int id = lvl[y][x];
				g.drawImage(tilemanager.getsprite(id), x*32, y*32, null);
				
				
			}
			enemymanager.draw(g);
			
		}
		
		drawselectedtile(g);
		
		//bottombar.draw(g);
		towermanager.draw(g);
		actionbar.draw(g);
		drawSelectedTower(g);
		
	}
	private void drawSelectedTower(Graphics g) {
		if (selectedTower != null)
			g.drawImage(towermanager.gettowerimgs()[selectedTower.getTowertype()], mousex, mousey, null);
		
	}

	private void drawlvl(Graphics g) {
		for(int y=0;y<lvl.length;y++) {
			
			for(int x =0;x<(lvl[y]).length;x++) {
				int id = lvl[y][x];
				g.drawImage(getspriteint(id), x*32, y*32, null);
				enemymanager.draw(g);
				
				
			}
		}
		
		
		
	}

	private void drawselectedtile(Graphics g) {
		
		if(selectedtile!=null) {
			g.drawImage(selectedtile.getsprite(), snapx, snapy, 32, 32, null);
		}
		
	}

	public void setselectedtile(tile tile) {
		selectedtile =tile;
	}
	
	public void mouseClicked(int x, int y) {
		System.out.println("X" + x + "||y" +y);
		if(y> 500) {
			actionbar.mouseClicked(x, y);
			System.out.println("action bar clicked");
		}		else {
			if (selectedTower != null)
				 {
					towermanager.addTower(selectedTower, mousex, mousey);
					selectedTower = null;
				}
		}
		
	}
	
	public int gettiletype(int x, int y) {
		int id = lvl[x/32][y/32]; 
		return getGame().getTileManager().gettile(id).getTiletype();
	}


	private void changelevel(int x, int y) {
		lvl[y/32][x/32]= selectedtile.getid();
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		if(y> 500) {
			//bottombar.mouseMoved(x, y);
		}else {
			mousex = x;
			mousey = y;
			snapx= (mousex/32)*32;
			snapy= (mousey/32)*32;
			
		}
		
	}


	@Override
	public void mousepressed(int x, int y) {
		if(y>500) {
			//bottombar.mousepressed(x, y);
		}
		
	}

	@Override
	public void mousereleased(int x, int y) {
		resetbuttons();
		
	}
	private void resetbuttons() {
		
		
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	public void update()
	{
		enemymanager.update();
	}
		
public TowerManager gettowermanager(){
	return towermanager;
	
}
{
	
}

public void setSelectedTower(Towers selectedTower) {
	this.selectedTower = selectedTower;
}
		

}
