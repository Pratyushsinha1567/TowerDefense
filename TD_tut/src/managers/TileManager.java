package managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import hlp.LoadSave;
import objects.tile;


public class TileManager {
	public tile ROAD,SAND,GRASS,MUD,MUDGRASS,MUDGRASS2,TOWERLOC;
	public BufferedImage atlas;
	public ArrayList<tile> tiles = new ArrayList<>();
	public TileManager() {
		loadatlas();
		createtiles();
		
	}
	private void loadatlas() {
		atlas = LoadSave.getSpriteAtlas();
		
	}
	private void createtiles() {
		int id=0;
		tiles.add(GRASS= new tile(getsprite(38,13),id++,"grass"));//id 0
		tiles.add(ROAD = new tile(getsprite(42,13),id++,"road"));//id 1
		tiles.add(SAND = new tile(getsprite(44,13),id++,"sand"));//id 2
	    tiles.add(MUD = new tile(getsprite(40,13),id++,"sand"));//id 3
		tiles.add(MUDGRASS = new tile(getsprite(1,5),id++,"sand"));//id 4
		tiles.add(MUDGRASS2 = new tile(getsprite(1,3),id++,"sand"));//id 5
		tiles.add(TOWERLOC = new tile(getsprite(22,0),id++,"sand"));//id 6
	}
	public BufferedImage getsprite(int id) {
		return tiles.get(id).getsprite();
	}
	
	private BufferedImage getsprite(int x,int y) {
		return atlas.getSubimage(x*32, y*32, 32, 32);
	}
	public tile gettile(int id) {
		return tiles.get(id);
	}

}
