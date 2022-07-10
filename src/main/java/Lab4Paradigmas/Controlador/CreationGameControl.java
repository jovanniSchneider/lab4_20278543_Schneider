package main.java.Lab4Paradigmas.Controlador;

import main.java.Lab4Paradigmas.Modelo.Dobble;
import main.java.Lab4Paradigmas.Modelo.DobbleGame;

/**
 * Controlador de la creacion de juego
 */
public class CreationGameControl {
    public CreationGameControl() {}

    /**
     * Crea un cardsSet si las condiciones se cumplen
     * @param juego entidad donde se crea el cardsSet
     * @param numE numero de elementos por carta
     * @param maxC maximo de cartas deseado
     * @return true si es que el juego se pudo crear
     */
    public boolean crearJuego(DobbleGame juego, int numE,int maxC){
        if (numE <=1 || numE > 8)
            return false;
        Dobble cardsSet = new Dobble(numE,maxC);
        if (cardsSet.esCorrecto()){
            juego.setCardsSet(cardsSet);
            return true;
        }
        return false;
    }
}
