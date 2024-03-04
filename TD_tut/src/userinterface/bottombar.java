/*package userinterface;

import static main.GameState.MENU;
import static main.GameState.SetGameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.tile;
import scenes.Playing;

public class ActionBar {
	
	private int x,y,width,hieght;
	private buttons bmenu;
	private Playing playing;
	private ArrayList<buttons> tilebuttons = new ArrayList<>();
	private tile selectedtile;
	public ActionBar(int x,int y,int w,int h,Playing playing) {
		
		this.x =x;
		this.y =y;
		this.width = w;
		this.hieght = h;
		this.playing = playing;
		initsButtons();
		
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(0,100,100));
		g.fillRect(x, y, width, hieght);
		drawbutton(g);
	}


	private void initsButtons() {
		
		bmenu = new buttons("menu", 1185, 100, 95, 30);
		int yoff= 0;
		int i =0;
		for(tile tiles : playing.gettilemanager().tiles) {
			tilebuttons.add(new buttons(tiles.getname(),1200,150+yoff,64,64,i));
			yoff= yoff+66;
			i++;
		}
		
	}
	

	private void drawbutton(Graphics g) {
		bmenu.draw(g);
		
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
			g.drawImage(selectedtile.getsprite(),1185,550,64,64, null);
		}
		
	}

	private Image getbimg(int id) {
		
		return playing.gettilemanager().getsprite(id);
	}

	

	public void mouseClicked(int x, int y) {
		if(bmenu.getBounds().contains(x,y)) {
			SetGameState(MENU);	
			}else {
				for(buttons b : tilebuttons) {
					if(b.getBounds().contains(x,y)) {
						this.selectedtile =playing.gettilemanager().gettile(b.getid());
						playing.setselectedtile(selectedtile);
						return;
					}
				}
			}
		
	}

	public void mouseMoved(int x, int y) {
		bmenu.setmouseover(false);
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
		
		
	}


	public void mousereleased(int x, int y) {
		resetbuttons();
		
	}
	private void resetbuttons() {
		bmenu.resetbools();
		for(buttons b : tilebuttons) {
			b.resetbools();
		}
		
	}
		

	
	
}

*/
