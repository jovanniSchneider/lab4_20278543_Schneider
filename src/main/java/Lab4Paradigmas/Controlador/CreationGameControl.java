package main.java.Lab4Paradigmas.Controlador;

import main.java.Lab4Paradigmas.Modelo.Dobble;
import main.java.Lab4Paradigmas.Modelo.DobbleGame;

public class CreationGameControl {
    public CreationGameControl() {}
    public boolean crearJuego(DobbleGame juego, int numE,int maxC){
        if (numE <=1 || numE > 8)
            return false;
        Dobble cardsSet = new Dobble(numE,maxC);
        juego.setCardsSet(cardsSet);
        return true;
    }
}
