package main.java.Lab4Paradigmas.Vista;

import main.java.Lab4Paradigmas.Controlador.GameModeControl;
import main.java.Lab4Paradigmas.Modelo.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeModeView extends JFrame{
    private JPanel panelMain;
    private JRadioButton stackModeRadioButton;
    private JRadioButton emptyHandStackModeRadioButton;
    private JButton elegirButton;

    public ChangeModeView(DobbleGame game){
        this.setTitle("Cambiando modo de juego");
        this.setContentPane(panelMain);
        ButtonGroup group = new ButtonGroup();
        group.add(stackModeRadioButton);
        group.add(emptyHandStackModeRadioButton);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon img = new ImageIcon("src/main/java/Lab4Paradigmas/Vista/Resources/dobble.png");
        this.setIconImage(img.getImage());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        elegirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = 0;
                if (stackModeRadioButton.isSelected()){
                    opcion = 1;
                }else if (emptyHandStackModeRadioButton.isSelected()){
                    opcion = 2;
                }else
                    JOptionPane.showMessageDialog(null,"Por favor elija una opción");
                if (opcion != 0){
                    GameModeControl control = new GameModeControl();
                    control.setGameMode(game,opcion);
                    JOptionPane.showMessageDialog(null,"Modo de juego elegido con exito");
                    ChangeModeView.super.dispose();
                }
            }
        });
    }
}
