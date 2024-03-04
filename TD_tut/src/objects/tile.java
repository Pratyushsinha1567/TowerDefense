package objects;

import java.awt.image.BufferedImage;

public class tile {
	private String name;
	private int id;
	private int tiletype;
	private BufferedImage sprite;
	public tile(BufferedImage sprite,int id,String name) {
		this.sprite = sprite;
		this.id =id;
		this.name = name;
	}


	public BufferedImage getsprite() {
		return sprite;
	}
	public int getid() {
		return id;
	}
	public String getname() {
		return name;
	}


	public int getTiletype() {
		return tiletype;
	}

}
