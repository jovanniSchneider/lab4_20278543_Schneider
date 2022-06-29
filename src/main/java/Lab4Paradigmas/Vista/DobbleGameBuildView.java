package main.java.Lab4Paradigmas.Vista;

import main.java.Lab4Paradigmas.Controlador.CreationGameControl;
import main.java.Lab4Paradigmas.Modelo.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DobbleGameBuildView extends JFrame {
    private DobbleGame juego;
    private JPanel panelMain;
    private JButton crearJuegoButton;
    private JButton verReglasButton;
    private JLabel creandoNuevoJuegoLabel;
    private JLabel Logo;
    private JLabel label1;
    private JTextField cantSimbolos;
    private JTextField maxCards;
    private JLabel label2;

    public DobbleGameBuildView() {
        this.setContentPane(panelMain);
        this.setTitle("Creacion de juego");
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon img = new ImageIcon("src/main/java/Lab4Paradigmas/Vista/Resources/dobble.png");
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        crearJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreationGameControl control = new CreationGameControl();
                boolean creado = control.crearJuego(juego,Integer.parseInt(cantSimbolos.getText()),Integer.parseInt(maxCards.getText()));
                if (creado)
                    JOptionPane.showMessageDialog(null,"Juego creado con exito");
                else
                    JOptionPane.showMessageDialog(null,"La cantidad de simbolos por carta debe ser " +
                            "> 2\nJuego no creado");
                DobbleGameBuildView.super.dispose();
            }
        });
        verReglasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"La creacion de cartas sigue las siguientes reglas" +
                        "\n- La mayor cantidad de simbolos por cartas es igual a las del juego real: 8" +
                        "\n- La mayor cantidad de cartas que se puede tener es 57, correspondientes a 8 simbolos cada una" +
                        "\n- Si se ingresa una cantidad menor a 0 o mayor a lo posible crear con esa cantidad de simbolos" +
                        "\n se crearán la mayor cantidad posible de cartas" +
                        "\n- La cantidad de simbolos - 1 debe ser potencia de un numero primo");
            }
        });
        this.pack();
    }

    public void setJuego(DobbleGame juego) {
        this.juego = juego;
    }
}
