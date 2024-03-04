package scenes;

import static main.GameState.MENU;
import static main.GameState.SetGameState;
import inputs.KeyboardInput;
import inputs.MouseInput;
import java.awt.Graphics;
import static main.GameState.*;

import hlp.LoadSave;
import hlp.lvlbld;
import main.Game;
import managers.TileManager;
//import manager.TowerManager;
import objects.tile;
import userinterface.toolbar;
import userinterface.buttons;

public class editing extends GameScene implements SceneMethods {

	private int[][] lvl;
	private TileManager tilemanager ;
	private toolbar toolbar;
	private tile selectedtile;
	//private TowerManager towermanager;
	private int mousex,mousey;
	private int snapx,snapy;
	private boolean drawselect;
	//buttons
	
	
	
	public editing(Game game) {
		super(game);
		this.lvl = lvlbld.getlvldata();
		tilemanager = new TileManager();
		toolbar = new toolbar(325,0,100,640,this);
		System.out.println("in playing");
		createdefaultlevel() ;
	//towermanager=new TowerManager(this);
		
		System.out.println("in edit");
	}
	
	public TileManager gettilemanager() {
			return tilemanager;
		}
	private void createdefaultlevel() {
		int[] arr = new int[100];
		for(int i=0;i<100;i++) {
			arr[i] = 0;
		}
		LoadSave.CreateLevel("new", arr);
	}

	@Override
	public void render(Graphics g) {
		
		for(int y=0;y<lvl.length;y++) {
			
			for(int x =0;x<(lvl[y]).length;x++) {
				int id = lvl[y][x];
				g.drawImage(tilemanager.getsprite(id), x*32, y*32, null);
				
				
			}
		}
		
		drawselectedtile(g);
		
		toolbar.draw(g);
	}
	

	private void drawselectedtile(Graphics g) {
		
		if(selectedtile!=null) {
			g.drawImage(selectedtile.getsprite(), 650, 550, 32, 32, null);
		}
		
	}

	public void setselectedtile(tile tile) {
		selectedtile =tile;
	}
	public void mouseClicked(int x, int y) {
		if(x> 640) {
			toolbar.mouseClicked(x, y);
		}else {
			System.out.println(x+"in change coor "+y);
			changelevel(snapx,snapy);
		}
		
	}

	private void changelevel(int x, int y) {
		if (selectedtile != null) {

			int tileX = x /32;
			int tileY = y /32;
			System.out.println(tileX +"in change "+tileY);
			lvl[tileY][tileX] = selectedtile.getid();
		}
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		if(x> 640) {
			toolbar.mouseMoved(x, y);
		}else {
			mousex = x;
			mousey = y;
			snapx= (mousex/32)*32;
			snapy= (mousey/32)*32;
			
		}
		
	}

	@Override
	public void mousepressed(int x, int y) {
		if(x> 640) {
			toolbar.mousepressed(x, y);
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
		//updatetick();
		//towermanager.update();
	}

	public void savelevel() {
		LoadSave.SaveLevel("new",lvl);
		getGame().getplaying().setlevel(lvl);
		
		
	}
		

}
