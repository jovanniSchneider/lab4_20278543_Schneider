package main.java.Lab4Paradigmas.Modelo;

public interface Juego {
    /**
     * Permite registrar un jugador en el juego
     * @param nombre del jugador a registrar
     */
    void registrarJugador(String nombre);

    /**
     * Permite cambiar el turno correspondiente del juego
     */
    void cambiarTurno();

    /**
     * Entrega como String a quien le corresponde el turno
     * @return el nombre de quien tiene el turno
     */
    String verTurno();


    /**
     * Entrega cierta cantidad de cartas a cada jugador
     * @param cantidad de cartas a repartir
     */
    void repartirCartas(int cantidad);
}
