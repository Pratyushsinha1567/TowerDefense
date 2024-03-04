package main;


import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInput;
import inputs.MouseInput;


@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	private Game game;
	private Dimension size;
	

	private KeyboardInput keyin;
	private MouseInput Mousein;
	
	public GameScreen(Game game) {
		this.game = game;
		SetScreenSize();
		
	}
	

	public void UInputs() {
		keyin = new KeyboardInput();
		
		Mousein = new MouseInput(game) ;
		
		addMouseListener(Mousein);
		
		addMouseMotionListener(Mousein);
		
		addKeyListener(keyin);
		
		requestFocus();
	}
	
	private void SetScreenSize() {
		this.size = new Dimension(640,640); //size of screen is set here
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		game.getrender().render(g);

	}
	
}

