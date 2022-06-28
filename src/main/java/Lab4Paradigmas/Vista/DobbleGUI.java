package main.java.Lab4Paradigmas.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DobbleGUI extends JFrame{
    private JPanel panelMain;
    private JButton jugarButton;
    private JLabel bienvenidoADobbleLabel;
    private JButton verModosDeJuegoButton;
    private JButton cambiarModoDeJuegoButton;
    private JButton registrarUnJugadorButton;
    private JButton crearJuegoButton;
    private JButton salirButton;
    private JLabel Logo;

    public DobbleGUI(){
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Jugando");
            }
        });
        verModosDeJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"EmptyHandsStack: Cada jugador parte con un número igual de cartas en su poder  y debe\n" +
                        "                 quedar una pila de cartas al centro. Las cartas asignadas al jugador y las del stack deben estar\n" +
                        "                 volteadas sin revelar su contenido. A continuación, se voltea una carta desde la pila y todos los\n" +
                        "                 jugadores voltean una de las que tienen en su poder. El primero que identifique coincidencias entre \n" +
                        "                 su carta y la de la pila, puede descartar su carta junto a la que se volteó desde la pila. La carta\n" +
                        "                 descartada y la de la pila se reubican en la base de ésta. Por otro lado, el resto de los jugadores\n" +
                        "                 vuelve a recoger su propia carta. El juego continúa hasta que uno de los jugadores quede sin cartas\n" +
                        "                 en su poder, quién será el ganador.\n");
            }
        });
        crearJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Creando el juego");
            }
        });
        registrarUnJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Registrando jugador");
            }
        });
        cambiarModoDeJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Cambiando modo de juego");
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Dobble");
        frame.setContentPane(new DobbleGUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
