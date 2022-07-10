package main.java.Lab4Paradigmas.Vista;

import main.java.Lab4Paradigmas.Modelo.DobbleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
    protected DobbleGame juego;
    private int gameMode;
    private JPanel panelMain;
    private JButton jugarButton;
    private JLabel bienvenidoADobbleLabel;
    private JButton verModosDeJuegoButton;
    private JButton cambiarModoDeJuegoButton;
    private JButton registrarUnJugadorButton;
    private JButton crearJuegoButton;
    private JButton salirButton;
    private JLabel Logo;
    private JButton verJugadoresRegistradosButton;

    public MainGUI(){
        this.setContentPane(panelMain);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("src/main/java/Lab4Paradigmas/Vista/Resources/dobble.png");
        this.setIconImage(img.getImage());
        this.pack();
        this.setLocationRelativeTo(null);
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego.getCardsSet() != null) {
                    if (juego.getJugadores().size() <= 1){
                        JOptionPane.showMessageDialog(null,"No hay suficientes jugadores registrados");
                    }else{
                        StackModeView view = new StackModeView(juego);
                        view.setVisible(true);
                    }
                }else
                    JOptionPane.showMessageDialog(null,"Primero debe crear un juego");
            }
        });
        verModosDeJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"" +
                        "EmptyHandsStack: Cada jugador parte con un número igual de cartas en su poder  y debe\n" +
                        "                 quedar una pila de cartas al centro. Las cartas asignadas al jugador y las del stack deben estar\n" +
                        "                 volteadas sin revelar su contenido. A continuación, se voltea una carta desde la pila y todos los\n" +
                        "                 jugadores voltean una de las que tienen en su poder. El primero que identifique coincidencias entre \n" +
                        "                 su carta y la de la pila, puede descartar su carta junto a la que se volteó desde la pila. La carta\n" +
                        "                 descartada y la de la pila se reubican en la base de ésta. Por otro lado, el resto de los jugadores\n" +
                        "                 vuelve a recoger su propia carta. El juego continúa hasta que uno de los jugadores quede sin cartas\n" +
                        "                 en su poder, quién será el ganador.\n" +
                        "\n\nStack:       Se disponen el conjunto de cartas apiladas por el reverso en el tablero. Luego se retiran las dos primeras cartas de\n" +
                        "                 la pila y se voltean para revelar su contenido sobre la mesa. A continuación, el primer jugador que identifique el \n" +
                        "                 elemento común entre estas dos cartas, se queda con las cartas. El juego termina cuando no quedan más cartas por voltear\n" +
                        "                 y gana aquel jugador que tiene más cartas.");
            }
        });
        crearJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DobbleGameBuildView gameBuilder = new DobbleGameBuildView();
                gameBuilder.setJuego(juego);
                gameBuilder.setVisible(true);
            }
        });
        registrarUnJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterView vista = new RegisterView(juego);
                vista.setVisible(true);
            }
        });
        cambiarModoDeJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeModeView vista = new ChangeModeView(juego);
                vista.setVisible(true);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        verJugadoresRegistradosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego.getJugadores().size() == 0)
                    JOptionPane.showMessageDialog(null,"No hay jugadores registrados");
                else
                    JOptionPane.showMessageDialog(null,"Jugadores registrados\n"+juego.getJugadores().toString());
            }
        });
    }

    public void setJuego(DobbleGame juego) {
        this.juego = juego;
    }
}
