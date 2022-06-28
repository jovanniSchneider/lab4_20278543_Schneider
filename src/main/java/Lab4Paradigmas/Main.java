package main.java.Lab4Paradigmas;
import main.java.Lab4Paradigmas.Vista.*;
import main.java.Lab4Paradigmas.Modelo.*;

public class Main {
    public static void main(String[] args) {
        MainGUI frame = new MainGUI();
        DobbleGame juego = new DobbleGame();
        frame.setJuego(juego);
        frame.setVisible(true);
    }
}
