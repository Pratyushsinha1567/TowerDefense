package inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GameState;

import static main.GameState.*;;

public class KeyboardInput implements KeyListener {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_A)
			GameState.gamestate = MENU;

		else if (e.getKeyCode() == KeyEvent.VK_S)
			GameState.gamestate = PLAYING;

		else if (e.getKeyCode() == KeyEvent.VK_D)
			GameState.gamestate = SETTINGS;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
