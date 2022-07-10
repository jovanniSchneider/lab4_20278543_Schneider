package main.java.Lab4Paradigmas.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un jugador
 */
public class Player implements Jugador {
    String nombre;
    List<Card> mano;
    int puntaje;
    int ID;

    /**
     * Constructor del jugador
     * @param nombre del jugador
     */
    public Player(String nombre){
        this.nombre = nombre;
        this.puntaje = 0;
        this.mano = new ArrayList<>();
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public void recogerCarta(Card carta) {
        this.mano.add(carta);
    }

    /**
     * Representa la clase en un string entendible para un usuario
     * @return la representacion de la clase
     */
    @Override
    public String toString() {
        return nombre;
    }

    /**
     *---------Getters and Setters---------
     */
    public List<Card> getMano() {
        return mano;
    }
    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}

