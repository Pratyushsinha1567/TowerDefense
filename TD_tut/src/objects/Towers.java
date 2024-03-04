package objects;

public class Towers {
    private int x,y,id,towertype;
	private float dmg, range, cooldown;
    
	public Towers(int x,int y,int id,int towertype)
	{
		this.x=x;
		this.y=y;
		this.id=id;
		this.towertype=towertype;
		setDefaultDmg();
		setDefaultRange();
		setDefaultCooldown();
		
		
	}

	private void setDefaultCooldown() {
		cooldown = hlp.Constants.Tower.GetDefaultCooldown(towertype);

	}

	private void setDefaultRange() {
		range = hlp.Constants.Tower.GetDefaultRange(towertype);

	}

	private void setDefaultDmg() {
		dmg = hlp.Constants.Tower.GetStartDmg(towertype);

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTowertype() {
		return towertype;
	}

	public void setTowertype(int towertype) {
		this.towertype = towertype;
	}

	public float getDmg() {
		return dmg;
	}

	public float getRange() {
		return range;
	}

	public float getCooldown() {
		return cooldown;
	}

	
}
