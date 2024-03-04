package scenes;

import java.awt.Graphics;

public interface SceneMethods {
	public void render(Graphics g); 
	public void mouseClicked(int x, int y);
	public void mouseMoved(int x, int y);
	public void mousepressed(int x, int y);
	public void mousereleased(int x, int y);
	void mouseDragged(int x, int y);
	

}
