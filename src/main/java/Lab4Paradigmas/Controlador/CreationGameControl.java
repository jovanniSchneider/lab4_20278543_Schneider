package main.java.Lab4Paradigmas.Controlador;

import main.java.Lab4Paradigmas.Modelo.DobbleGame;

public class CreationGameControl {
    public CreationGameControl() {}
    public boolean crearJuego(DobbleGame juego, int numE,int maxC){
        if (numE <=2)
            return false;
        juego.crearCardsSet(numE,maxC);
        return true;
    }
}
