package main;

import javax.swing.JFrame;
import inputs.KeyboardInput;
import inputs.MouseInput;
import managers.TileManager;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;


@SuppressWarnings("serial")
public class Game extends JFrame implements Runnable {
	private GameScreen gamescreen;
	private Thread gm_thread ;
	private final int fps = 12;//set fps
	private final int ups = 60;
	
	private Render render;
	private Menu menu;
	private Playing playing;
	private Settings settings;

	private TileManager tileManager;

	public Game(){
		initialise_classes();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		
		
		//setResizable(false);
		
		add(gamescreen);
		
		pack();
		
		setVisible(true);
		
	}
	
	
	private void initialise_classes(){
	    gamescreen = new GameScreen(this);
		render = new Render(this);
		menu = new Menu(this);
		playing = new Playing(this);
		settings = new Settings(this);
	}
	private void start() {
		gm_thread = new Thread(this) {};//creates new thread_1
		                                //class implements runnable so no need to give new Runnable 
			gm_thread.start();
		}
	
	private void updategm() {
		playing.update();
	}
		
	@Override
	public void run() {
		//all the code to be implemented in thread
		double timebFrames = 1000000000.0/fps;
		double timebUpdates = 1000000000.0/ups;
		
		long  LastfTimeF= System.nanoTime();
		long  LastfTimeU= System.nanoTime();
		long  Last_check= System.currentTimeMillis();
		long  Stime_nano;
		
		int frameRate=0 ;
		int UpdateRate =0;
		 
		while(true) {
			Stime_nano = System.nanoTime();
			if(Stime_nano - LastfTimeF >=timebFrames) {
				
				LastfTimeF = Stime_nano;
				frameRate++;
				repaint();
				
				}
			if(Stime_nano - LastfTimeU >=timebUpdates) {
					updategm();
					UpdateRate++;
					LastfTimeU = Stime_nano;
				}
			if(System.currentTimeMillis() - Last_check >= 1000) {
					System.out.println("FPS :" + frameRate+" || "+"UPS :"+UpdateRate);
					Last_check= System.currentTimeMillis();
					frameRate = 0;
					UpdateRate = 0;
				}
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.gamescreen.UInputs();
		game.start();
	}
	
	
	//getters
	public Render getrender() {
		return render;
	}
	public Menu getmenu() {
		return menu;
	}
	public Playing getplaying() {
		return playing;
	}
	public Settings getsettings() {
		return settings;
	}

	public TileManager getTileManager() {
		return tileManager;
	}

}