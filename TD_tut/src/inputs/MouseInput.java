package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GameState;

public class MouseInput implements MouseListener, MouseMotionListener{


	private Game game;

	public MouseInput(Game game) {
		this.game = game;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
			switch(GameState.gamestate){
			case MENU:
				game.getmenu().mouseMoved(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getplaying().mouseMoved(e.getX(), e.getY());
				break;
			case SETTINGS:
				game.getsettings().mouseMoved(e.getX(), e.getY());
				break;
			default:
				break;
				
			
		
			}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent. BUTTON1) {
			switch(GameState.gamestate){
			case MENU:
				game.getmenu().mouseClicked(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getplaying().mouseClicked(e.getX(), e.getY());
				break;
			case SETTINGS:
				game.getsettings().mouseClicked(e.getX(), e.getY());
				break;
			default:
				break;
				
			
		
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		

		switch(GameState.gamestate){
		case MENU:
			game.getmenu().mousepressed(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getplaying().mousepressed(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getsettings().mousepressed(e.getX(), e.getY());
			break;
		default:
			break;
			
		
	
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		switch(GameState.gamestate){
		case MENU:
			game.getmenu().mousereleased(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getplaying().mousereleased(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getsettings().mousereleased(e.getX(), e.getY());
			break;
		default:
			break;
			
		
	
		}
		
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

