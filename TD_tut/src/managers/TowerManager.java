package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import hlp.LoadSave;
import objects.Towers;
import scenes.Playing;
import static hlp.Constants.Tower.*;

public class TowerManager {
    private Playing playing;
    private BufferedImage[] towerimages;

	private ArrayList<Towers> towers = new ArrayList<>();
	private int towerAmount = 0;
    public TowerManager(Playing playing)
    {
    	this.playing=playing;
    	loadtowerimages();
    	
    }



	private void loadtowerimages() {
		// TODO Auto-generated method stub
		BufferedImage atlas=LoadSave.getSpriteAtlas();
		towerimages= new BufferedImage[3];
		towerimages[0]=atlas.getSubimage(20*64,10*64 ,64, 64);
		towerimages[1]=atlas.getSubimage(19*64,10*64 ,64, 64);
		towerimages[2]=atlas.getSubimage(21*64,8*64 ,64, 64);
	}
	public void addTower(Towers selectedTower, int xPos, int yPos) {
		towers.add(new Towers(xPos, yPos, towerAmount++, selectedTower.getTowertype()));
	}

	public void update() {
	}

	public void draw(Graphics g) {
		for (Towers t : towers)
			g.drawImage(towerimages[t.getTowertype()], t.getX(), t.getY(), null);
	}
    public BufferedImage[] gettowerimgs()
    {
    	return towerimages;
    }
}
