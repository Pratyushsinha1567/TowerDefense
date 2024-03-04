package main;

import java.awt.Graphics;

public class Render {
	private Game game;
	public Render(Game game) {
		 this.game = game;
	}
	
	public void render(Graphics g) {
		switch(GameState.gamestate) {
		
		case MENU:
			game.getmenu().render(g); System.out.println("render menu");	

			break;
		case PLAYING:
			
			game.getplaying().render(g); System.out.println("render play");

			break;
		case SETTINGS:
			
			game.getsettings().render(g); System.out.println("render sett");

			break;

		default:
			break;

		}
		}
	

}
