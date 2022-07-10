package main.java.Lab4Paradigmas.Controlador;

import main.java.Lab4Paradigmas.Modelo.DobbleGame;

/**
 * Controlador del cambio de modo
 */
public class GameModeControl {

    public GameModeControl() {}

    /**
     * Selecciona el modo de juego
     * @param juego juego al que se le cambia el modo
     * @param gameMode entero que representa el modo de juego
     */
    public void setGameMode(DobbleGame juego, int gameMode){
        juego.setGameMode(gameMode);
    }
}
