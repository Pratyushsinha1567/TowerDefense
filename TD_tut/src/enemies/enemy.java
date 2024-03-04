package enemies;

import java.awt.Rectangle;
import static hlp.Constants.Direction.*;
public abstract class enemy {
    private float enemyx,enemyy;
    private Rectangle bounds;
    private int health;
    private int ID;
    private int enemyType;
    private int lastDir;
	protected int maxHealth;
    
    public enemy(float x,float y,int ID,int enemytype){
        this.enemyx =x;
        this.enemyy=y;
        this.ID=ID;
        bounds = new Rectangle((int) x, (int) y, 32, 32);
        this.enemyType= enemytype;
        lastDir = RIGHT;
    }

	private void setStartHealth() {
		health = hlp.Constants.Enemies.GetStartHealth(enemyType);
		maxHealth = health;
	}
    
    public void moveright(float speed,int till) {
		
			float i=0;
		i=i+speed ;
			this.enemyx += speed;
			
			if(i >32*till) {
				return;
			}
		
		
	}
    public void movedown(float speed,int till) {

		float i=0;
	i=i+speed ;
		
		
		this.enemyy += speed;
		if( i > 32*till) {
			return;
		}
	}
 public void moveup(float speed,int till) {
		
		

		float i=0;
			i=i+speed ;
		this.enemyy -= speed;
		if(i> 32*till) {
			return;
		}
	}//19*20
    //chang
    public void moveplane(float speedx,float speedy) {
    	this.enemyx += speedx;
    	this.enemyy += speedy;
    }
    
    
    

    protected void setstarthealth(){
    	this.health =hlp.Constants.Enemies.GetStartHealth(enemyType);
    }
    
   public float getspeed(){
    	return hlp.Constants.Enemies.GetSpeed(enemyType);
    }
    

	public float getHealthBarFloat() {
		return health / (float) maxHealth;
	}

    public float getx(){
        return enemyx;
    }
    public float gety(){
        return enemyy;
    }
    public Rectangle getbounds(){
        return bounds;
    }
    public int gethealth(){
        return health;
    }
    public int  getid(){
        return ID;
    }
    public int getenemytype() {
		return enemyType;
	}

	public int getlastdir() {
		System.out.println("lastDir" + lastDir);
		return lastDir;
	}

	public void setPos(int x, int y) {
		
		this.enemyx = x;
		this.enemyy = y;
		
		
	}

    
    }
    