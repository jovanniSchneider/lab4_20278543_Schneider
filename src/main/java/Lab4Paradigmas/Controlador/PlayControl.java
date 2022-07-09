package main.java.Lab4Paradigmas.Controlador;

import main.java.Lab4Paradigmas.Modelo.Card;
import main.java.Lab4Paradigmas.Modelo.DobbleGame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayControl {
    public PlayControl() {}

    public boolean stack(DobbleGame game){
        if (game.getJugadores().size() <=1){
            return false;
        }
        game.repartirCartas(0);
        List<Card> mazo = game.getMazo();
        List<Card> area = new ArrayList<Card>();
        Card carta1 = mazo.get(0);
        Card carta2 = mazo.get(1);
        mazo.remove(0);
        mazo.remove(0);
        game.setMazo(mazo);
        area.add(carta1);
        area.add(carta2);
        game.setArea(area);
        return true;
    }
    public void llenarCarta(List<JLabel> labels, Card carta){
        for (int simbolo : carta.getElementos()) {
            for (int i = 0; i < labels.size(); i++){
                if(Objects.equals(labels.get(i).getText(), "")){
                    labels.get(i).setText(String.valueOf(simbolo));
                    break;
                }
            }
        }
    }
}
