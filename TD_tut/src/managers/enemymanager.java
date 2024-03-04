package managers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import static hlp.Constants.Direction.*;
import enemies.enemy;
import hlp.LoadSave;
import scenes.Playing;
import static hlp.Constants.Tiles.*;
import static hlp.Constants.Enemies.*;
import enemies.soldier;
import enemies.enemy;
import enemies.tank;
import enemies.plane;

public class enemymanager {
	
    private Playing playing;
    private BufferedImage[] enemyimages;
	private int HPbarWidth = 20;
   
    private ArrayList<enemy> enemies = new ArrayList<>();
    
    public enemymanager(Playing playing ){
        
        this.playing = playing;
        enemyimages = new BufferedImage[3];
        addenemy(SOLDIER);
        addenemy(TANK);
        addenemy(PLANE);
        loadenemy();
        
    }

    private void loadenemy(){
        BufferedImage atlas = LoadSave.getSpriteAtlas();
        enemyimages[0]= atlas.getSubimage(64*15,64*10,64,64);
        enemyimages[1]= atlas.getSubimage(64*16,64*11,64,64);
        enemyimages[2]= atlas.getSubimage(64*18,64*11,64,64);
    }
    public void addenemy(int enemytype) {

		switch (enemytype) {
		case SOLDIER:
			enemies.add(new soldier(0, 6*32 -15, 0));
			break;
		case TANK:
			enemies.add(new tank(0, 14*31 -5, 0));
			break;
		case PLANE:
			enemies.add(new plane(0, 10*30, 0));
			break;
		
		}
    	
    }
    public void update(){//chang
    //	motionsol();
   	//motiontank();
    	//motionplane();
    }
    private void motionplane() {
		enemy plane = enemies.get(2);
		plane.moveplane(plane.getspeed(),(float)(0.95)*plane.getspeed());
		
	}

	private void motiontank() {
		enemy e = enemies.get(1);
		 float s;
		 s = e.getspeed();
		   int k=0;
		 switch(k) {
		 	 case 0:
		 	 	e.moveright(s,5);
		 
		
		 	 case 1:
		 	 	e.moveup(s,2);
		
		 	 case 2:
		 		 e.moveright(s, 2);
		 		 
		 	 case 3:
		 		 e.moveup(s, 5);
		 	 case 4:
		 		 e.moveright(s,3);
		 	
		 		 
		 	
		 	 case 10:
		 		 e.movedown(s, 1);
		 	case 11:
		 		 e.moveright(s, 2);
		 	 case 12:
		 		 e.moveup(s, 3);
		 		 
		 	case 13:
		 		 e.moveright(s, 4); 
		 	 case 14:
		 		 e.moveup(s, 3);
		 		 break;
		 }
		
	}

	private void motionsol() {
		enemy e = enemies.get(0);
		float s;
		 s = e.getspeed();
		   int k=1;
		 switch(k) {
		 	 case 1:
		 	 	e.moveright(s,4);
		 
		
		 	 case 2:
		 	 	e.moveup(s,2);
		
		 	 case 3:
		 		 e.moveright(s, 2);
		 		 
		 	 case 4:
		 		 e.moveup(s, 2);
		 	 case 5:
		 		 e.moveright(s, 2);
		 		 
		 	 case 6:
		 		 e.movedown(s, 1);
		 	 case 7:
		 		 e.moveright(s,1 );
		 	 case 8:
		 		 e.movedown(s, 4);
		 	case 9:
		 		 e.moveright(s, 2);
		 	 case 10:
		 		 e.movedown(s, 1);
		 	case 11:
		 		 e.moveright(s, 2);
		 	 case 12:
		 		 e.moveup(s, 3);
		 		 
		 	case 13:
		 		 e.moveright(s, 4); 
		 	 case 14:
		 		 e.moveup(s, 3);
		 		 break;
		 }
		e.moveright((float)12.4, 65);
	}

 
    public void draw(Graphics g){
    	for(enemy enemy : enemies) {
        drawenemy(enemy,g);
        drawHealthBar(enemy, g);
    	}
    }

	private void drawHealthBar(enemy e, Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) e.getx()+16 , (int) e.gety()+5 , 32, 3);

	}

	private int getNewBarWidth(enemy e) {
		return (int) (HPbarWidth * e.getHealthBarFloat());
	}


    private void  drawenemy(enemy e,Graphics g){
        g.drawImage(enemyimages[e.getenemytype()],(int)e.getx(),(int)e.gety(),null);
    }
    

}
