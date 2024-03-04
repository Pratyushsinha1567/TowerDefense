package userinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class buttons {
	public int x,y,width,height;
	private String text;
	
	private Rectangle Bounds;
	private boolean mouseover,mouseclicked;
	private boolean mousepressed;
	private int id;
	public buttons(String text,int x, int y, int width, int height) {
		this.text=text;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.id =-9999;
		initsBounds();
}
	public buttons(String text,int x, int y, int width, int height,int id) {
		this.text=text;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.id =id;
		initsBounds();
		
}
	public boolean ismouseover() {
		
		return mouseover;
		
	}
	
	public boolean ismousepressed() {
		
		return mousepressed;
		}
	
	public int getid() {
		return id;
		
	}
	
	private void initsBounds() {
		this.Bounds = new Rectangle(x,y,width,height);
	}
	
	public void draw(Graphics g) {
		
		drawbuttbody(g);
		
		drawbuttboder(g);
		
		drawtext(g);
	}
	private void drawbuttboder(Graphics g) {
		if(mousepressed) {
			
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
			g.drawRect(x+1, y+1, width-2, height-2);
			g.drawRect(x+2,2+ y, width-4, height-4);
			
			
		}else {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
		}
		
		
		
	}

	private void drawbuttbody(Graphics g) {
		
		if(mouseover) {
			
			g.setColor(Color.gray);
			g.fillRect(x, y, width, height);
			
		}else {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		}
		
		
	}
	
	public void resetbools() {
		this.mouseover = false;
		this.mouseclicked = false;
	}
	
	
	private void drawtext(Graphics g) {
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();
		g.drawString(text, x-w/2+width/2, y+h/2+height/2);
	}

	public Rectangle getBounds() {
		return Bounds;
	}
	
	public void setmouseover(boolean mouseover) {
		this.mouseover = mouseover;
		
		
	}
	public void setmousepressed(boolean mousepressed) {
		this.mousepressed = mousepressed;
	}
		
}

	
	

