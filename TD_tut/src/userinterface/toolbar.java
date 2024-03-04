package userinterface;



import static main.GameState.MENU;
import static main.GameState.SetGameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.tile;
import scenes.editing;

public class toolbar {
	
	private int x,y,width,hieght;
	private buttons bmenu,bsave;
	private editing editing;
	private ArrayList<buttons> tilebuttons = new ArrayList<>();
	private tile selectedtile;
	public toolbar(int x,int y,int w,int h,editing editing) {
		
		this.x =x;
		this.y =y;
		this.width = w;
		this.hieght = h;
		this.editing = editing;
		initsButtons();
		
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(0,100,100));
		g.fillRect(x, y, width, hieght);
		drawbutton(g);
	}


	private void initsButtons() {
		
		bmenu = new buttons("menu", 645, 100, 95, 30);
		bsave = new buttons("SAVE", 645, 40, 95, 30);
		int yoff= 0;
		int i =0;
		for(tile tiles : editing.gettilemanager().tiles) {
			tilebuttons.add(new buttons(tiles.getname(),645,150+yoff,64,64,i));
			yoff= yoff+66;
			i++;
		}
		
	}
	

	private void drawbutton(Graphics g) {
		bmenu.draw(g);
		bsave.draw(g);
		
		for(buttons b :tilebuttons) {
			g.drawImage(getbimg(b.getid()), b.x, b.y, b.width,b.height, null);
		if(b.ismouseover())	{
			g.setColor(Color.WHITE);
		}else{
			g.setColor(Color.BLACK);
			}
		
		
		g.drawRect(b.x, b.y, b.width, b.height);
		if(b.ismousepressed()) {
			g.drawRect(b.x+1, b.y+1, b.width-2, b.height-2);
			g.drawRect(b.x+2, b.y+2, b.width-4, b.height-4);
		}
		}
		
		drawselectedtile(g);
		}

		
		
	

	private void drawselectedtile(Graphics g) {
		if(selectedtile !=null) {
			g.drawImage(selectedtile.getsprite(),645,550,64,64, null);
		}
		
	}

	private BufferedImage getbimg(int id) {
		
		return editing.gettilemanager().getsprite(id);
	}

	

	public void mouseClicked(int x, int y) {
		if(bmenu.getBounds().contains(x,y)) {
			SetGameState(MENU);	
			}else {
				for(buttons b : tilebuttons) {
					if(b.getBounds().contains(x,y)) {
						this.selectedtile =editing.gettilemanager().gettile(b.getid());
						
						editing.setselectedtile(selectedtile);
						return;
					}
				}
			}
		if(bsave.getBounds().contains(x,y)) {
		savelevel();
			}
		
	}

	private void savelevel() {
		editing.savelevel();
		
	}

	public void mouseMoved(int x, int y) {
		bmenu.setmouseover(false);
		bsave.setmouseover(false);
		for(buttons b : tilebuttons) {
			b.setmouseover(false);
		}
		if(bmenu.getBounds().contains(x,y)) {
			bmenu.setmouseover(true);
		}else {
			for(buttons b : tilebuttons) {
				if(b.getBounds().contains(x,y)) {
					b.setmouseover(true);
					return;
					}
			
				}
		
			}
		if(bsave.getBounds().contains(x,y)) {
			bsave.setmouseover(true);
		}

	}
	public void mousepressed(int x, int y) {

		if(bmenu.getBounds().contains(x,y)) {
			bmenu.setmousepressed(true);
		}else {
			for(buttons b : tilebuttons) {
				if(b.getBounds().contains(x,y)) {
					b.setmousepressed(true);
					return;
					}
			
				}
		
			}
		if(bsave.getBounds().contains(x,y)) {
			bsave.setmousepressed(true);
		}
		
		
	}


	public void mousereleased(int x, int y) {
		resetbuttons();
		
	}
	private void resetbuttons() {
		bmenu.resetbools();
		bsave.resetbools();
		for(buttons b : tilebuttons) {
			b.resetbools();
		}
		
	}
		

	
	
}


