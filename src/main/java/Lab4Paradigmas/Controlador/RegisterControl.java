package main.java.Lab4Paradigmas.Controlador;

import main.java.Lab4Paradigmas.Modelo.Dobble;
import main.java.Lab4Paradigmas.Modelo.DobbleGame;
import main.java.Lab4Paradigmas.Modelo.Player;
import java.util.List;
import java.util.Objects;

public class RegisterControl {
    public RegisterControl(){}
    public boolean registrarJugador(DobbleGame juego, String playerName){
        List<Player> jugadores= juego.getJugadores();
        if (buscarJugador(playerName,jugadores)){
            return false;
        }
        juego.registrarJugador(playerName);
        return true;
    }
    public boolean buscarJugador(String playerName, List<Player> jugadores){
        for (Player jugador: jugadores) {
            if (Objects.equals(jugador.getNombre(), playerName)){
                return true;
            }
        }
        return false;
    }
}
