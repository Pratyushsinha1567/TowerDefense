package userinterface;


import static main.GameState.MENU;
import static main.GameState.SetGameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import hlp.Constants.Tower;
import objects.Towers;
import scenes.Playing;

public class ActionBar extends Bar {

	private Playing playing;
	private buttons bMenu;
	private buttons[] towerbuttons;
	private Towers selectedTower;
	private Towers displayedTower;

	public ActionBar(int x, int y, int width, int height, Playing playing) {
		super(x, y, width, height);
		this.playing = playing;

		initButtons();
	}

	private void initButtons() {

		bMenu = new buttons("Menu", 2, 600, 100, 30);
		towerbuttons= new buttons[3];
		int w=50;
		int h=50;
		int xStart=110;
		int yStart=590;
		int xOffset=(int)(w*1.1f);
		for(int i=0;i<3;i++)
		{
			towerbuttons[i]=new buttons("", xStart+ xOffset*i, yStart,w, h,i);
		}
		

	}

	private void drawButtons(Graphics g) {
		bMenu.draw(g);
		for (buttons b : towerbuttons) {
			g.setColor(Color.gray);
			g.fillRect(b.x, b.y, b.width, b.height);
			g.drawImage(playing.gettowermanager().gettowerimgs()[b.getid()], b.x, b.y, b.width, b.height, null);
			
		}
	}

	public void draw(Graphics g) {

		// Background
		g.setColor(new Color(220, 123, 15));
		g.fillRect(x, y, width, height);

		// Buttons
		drawButtons(g);
	}
	private void drawDisplayedTower(Graphics g) {
		if (displayedTower != null) {
			g.setColor(Color.gray);
			g.fillRect(410, 645, 220, 85);
			g.setColor(Color.black);
			g.drawRect(410, 645, 220, 85);
			g.drawRect(420, 650, 50, 50);
			g.drawImage(playing.gettowermanager().gettowerimgs()[displayedTower.getTowertype()], 420, 650, 50, 50, null);
			g.setFont(new Font("LucidaSans", Font.BOLD, 15));
			g.drawString("" + Tower.GetName(displayedTower.getTowertype()), 490, 660);
			g.drawString("ID: " + displayedTower.getId(), 490, 675);
			drawDisplayedTowerBorder(g);
			drawDisplayedTowerRange(g);
		}

	}
	private void drawDisplayedTowerRange(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(displayedTower.getX() / 2, displayedTower.getY() ,100,100);

	}
	private void drawDisplayedTowerBorder(Graphics g) {

		g.setColor(Color.CYAN);
		g.drawRect(displayedTower.getX(), displayedTower.getY(), 32, 32);

	}

	public void displayTower(Towers t) {
		displayedTower = t;
	}


	public void mouseClicked(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			SetGameState(MENU);
		else {
			for(buttons b : towerbuttons) {
				if(b.getBounds().contains(x, y)) {
					selectedTower = new Towers(0,0,-1,b.getid());
					playing.setSelectedTower(selectedTower);
					return;
				}
			}
		}

	}

	public void mouseMoved(int x, int y) {
		bMenu.setmouseover(false);
		for(buttons b:towerbuttons)
		{
			b.setmouseover(false);
		}
		
		if (bMenu.getBounds().contains(x, y))
			bMenu.setmouseover(true);
		else {
			for(buttons b:towerbuttons)
			{
				b.setmouseover(true);
				return;
			}
		}
	}

	public void mousePressed(int x, int y) {
		
		if (bMenu.getBounds().contains(x, y))
			bMenu.setmousepressed(true);
		else {
			for(buttons b:towerbuttons)
			{
				b.setmousepressed(true);
				return;
			}
		}

	}

	public void mouseReleased(int x, int y) {
		bMenu.resetbools();
		for(buttons b:towerbuttons)
		{
			b.resetbools();
		}

	}

}
