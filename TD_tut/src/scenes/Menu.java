package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import static main.GameState.*;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;
import userinterface.buttons;

public class Menu extends GameScene implements SceneMethods{
	//private Graphics g;
	
	private buttons bPlaying, bSetting, bQuit;
	private BufferedImage img;
	private Random random;
	ArrayList<BufferedImage> sprite = new ArrayList<>();
	public Menu(Game game) {
		super(game);
		imprtimg();
		loadsprites();
		System.out.println("in menu");
		random = new Random();
		
		initsButtons();
		
	}
	

	private void initsButtons() {
		
		bPlaying = new buttons("Play", 100, 100, 100, 30);
		bSetting = new buttons("Settings", 250, 100, 100, 30);
		
	}


	private void loadsprites() {
		for (int y = 0;y<10;y++) {
			for(int x =0;x<10;x++) {
				sprite.add(img.getSubimage(x*64, y*64, 64, 64));
			}
		}
		
	}

	private void imprtimg() {
		InputStream is = getClass().getResourceAsStream("/towerDefense_tilesheet.png");
		try {
			this.img = ImageIO.read(is);
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	

	@Override
	public void render(Graphics g) {
		/*
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				g.drawImage(sprite.get(random.nextInt(100)), 64*x, 64*y, null);
			}
		}*/
		
		drawbutton(g);
		
	}


	private void drawbutton(Graphics g) {
		
		bPlaying.draw(g);
		bSetting.draw(g);
		
	}


	public void mouseClicked(int x, int y) {
		if(bPlaying.getBounds().contains(x,y)) {
			SetGameState(PLAYING);	
			}
		if(bSetting.getBounds().contains(x,y)) {
			SetGameState(SETTINGS);	
			}
		
	}


	@Override
	public void mouseMoved(int x, int y) {
		bPlaying.setmouseover(false);
		bSetting.setmouseover(false);
		if(bPlaying.getBounds().contains(x,y)) {
			bPlaying.setmouseover(true);
		}
		if(bSetting.getBounds().contains(x,y)) {
			bSetting.setmouseover(true);
		}
	
		
	}


	@Override
	public void mousepressed(int x, int y) {
		
		
		if(bPlaying.getBounds().contains(x,y)) {
			bPlaying.setmousepressed(true);
		}
		if(bSetting.getBounds().contains(x,y)) {
			bSetting.setmousepressed(true);
		}	
	
		
	}


	@Override
	public void mousereleased(int x, int y) {
		resetbuttons();
		
	}


	private void resetbuttons() {
		bPlaying.resetbools();
		bSetting.resetbools();
	}


	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}
		
		
	

	
}
