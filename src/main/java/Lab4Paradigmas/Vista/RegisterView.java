package main.java.Lab4Paradigmas.Vista;

import main.java.Lab4Paradigmas.Controlador.RegisterControl;
import main.java.Lab4Paradigmas.Modelo.Dobble;
import main.java.Lab4Paradigmas.Modelo.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame{
    private JPanel mainPanel;
    private JTextField textCamp;
    private JLabel label1;
    private JButton registrarButton;

    public RegisterView(DobbleGame juego) {
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon img = new ImageIcon("src/main/java/Lab4Paradigmas/Vista/Resources/dobble.png");
        this.setIconImage(img.getImage());
        this.pack();
        this.setLocationRelativeTo(null);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterControl control = new RegisterControl();
                String newPlayer = textCamp.getText();
                boolean registrado = control.registrarJugador(juego,newPlayer);
                if (registrado){
                    JOptionPane.showMessageDialog(null,"Jugador "+newPlayer+" registrado con exito");
                }else{
                    JOptionPane.showMessageDialog(null,"Ya existe un jugador registrado con ese nombre" +
                            "\nNo se ha registrado al jugador");
                }
                RegisterView.super.dispose();
            }
        });
    }
}
