package main.java.Lab4Paradigmas.Controlador;

import main.java.Lab4Paradigmas.Modelo.Card;
import main.java.Lab4Paradigmas.Modelo.DobbleGame;
import main.java.Lab4Paradigmas.Modelo.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Controlador de jugar
 */
public class PlayControl {
    public PlayControl() {}

    /**
     * Toma las 2 primeras cartas del juego y las coloca en el area de juego
     * @param game Juego con el que se juega
     * @return true si es que se pudo completar el volteamiento
     */
    public boolean stack(DobbleGame game){
        if (game.getJugadores().size() <=1){
            return false;
        }
        List<Card> mazo = game.getMazo();
        if (mazo.size()>=2) {
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
        return false;
    }
    public void llenarCarta(List<JLabel> labels, Card carta){
        for (int simbolo : carta.getElementos()){
            for (int i = 0; i < labels.size(); i++){
                labels.get(i).setText("");
            }
        }
        for (int simbolo : carta.getElementos()) {
            for (int i = 0; i < labels.size(); i++){
                if(Objects.equals(labels.get(i).getText(), "")){
                    labels.get(i).setText(String.valueOf(simbolo));
                    break;
                }
            }
        }
    }

    public boolean verificarRespuesta(Card carta1, Card carta2, String choice){
        if (choice.equals("")){
            return false;
        }else if(carta1.whichCoincide(carta2) == Integer.parseInt(choice))
            return true;
        return false;
    }

    public void changeTurn(DobbleGame juego){
        if (juego.getTurno() == juego.getCantidadJugadores())
            juego.setTurno(1);
        else
            juego.setTurno(juego.getTurno()+1);
    }

    private Player getPlayerByTurn(DobbleGame game){
        for (Player player: game.getJugadores()) {
            if (game.getTurno() == player.getID())
                return player;
        }
        return null;
    }

    public String whoseTurnIsIt(DobbleGame game){
        return getPlayerByTurn(game).getNombre();
    }

    public int darPunto(DobbleGame game){
        Player player = getPlayerByTurn(game);
        player.setPuntaje(player.getPuntaje()+1);
        return player.getPuntaje();
    }
    public void repartirCartas(DobbleGame game){
        game.generarMazo(0);
        for (Player player:game.getJugadores()){
            player.setPuntaje(0);
        }
    }

    public String getWinner(DobbleGame game){
        Player winner = game.getJugadores().get(0);
        for (Player player:game.getJugadores()){
            if (player.getPuntaje() > winner.getPuntaje())
                winner = player;
        }
        return winner.getNombre();
    }
}
