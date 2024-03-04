package main;

public enum GameState {
PLAYING,MENU,SETTINGS, EDIT;

public static GameState gamestate = MENU;
public static void SetGameState(GameState state) {
	gamestate = state;
}
}
