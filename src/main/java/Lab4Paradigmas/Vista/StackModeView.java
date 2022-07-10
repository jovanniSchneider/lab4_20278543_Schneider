package main.java.Lab4Paradigmas.Vista;

import main.java.Lab4Paradigmas.Controlador.PlayControl;
import main.java.Lab4Paradigmas.Modelo.DobbleGame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class StackModeView extends JFrame{
    private JPanel panelMain;
    private JTextField choice;
    private JButton jugarButton;
    private JProgressBar timeBar;
    private JPanel carta1;
    private JPanel carta2;
    private JPanel area;
    private JLabel c1Symbol1;
    private JLabel c1Symbol2;
    private JLabel c1Symbol3;
    private JLabel c1Symbol4;
    private JLabel c1Symbol5;
    private JLabel c1Symbol6;
    private JLabel c1Symbol7;
    private JLabel c1Symbol8;
    private JLabel c2Symbol1;
    private JLabel c2Symbol2;
    private JLabel c2Symbol3;
    private JLabel c2Symbol4;
    private JLabel c2Symbol5;
    private JLabel c2Symbol6;
    private JLabel c2Symbol7;
    private JLabel c2Symbol8;
    private JLabel turno;
    private java.util.List<JLabel> labelsc1 = new ArrayList<>();
    private java.util.List<JLabel> labelsc2 = new ArrayList<>();
    int tiempo = 7;

    public StackModeView(DobbleGame juego) {
        labelsc1.add(c1Symbol1);
        labelsc1.add(c1Symbol2);
        labelsc1.add(c1Symbol3);
        labelsc1.add(c1Symbol4);
        labelsc1.add(c1Symbol5);
        labelsc1.add(c1Symbol6);
        labelsc1.add(c1Symbol7);
        labelsc1.add(c1Symbol8);
        labelsc2.add(c2Symbol1);
        labelsc2.add(c2Symbol2);
        labelsc2.add(c2Symbol3);
        labelsc2.add(c2Symbol4);
        labelsc2.add(c2Symbol5);
        labelsc2.add(c2Symbol6);
        labelsc2.add(c2Symbol7);
        labelsc2.add(c2Symbol8);
        PlayControl ctrl = new PlayControl();
        ctrl.repartirCartas(juego);
        ctrl.stack(juego);
        ctrl.llenarCarta(labelsc1,juego.getArea().get(0));
        ctrl.llenarCarta(labelsc2,juego.getArea().get(1));
        turno.setText(ctrl.whoseTurnIsIt(juego));
        this.setContentPane(panelMain);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon img = new ImageIcon("src/main/java/Lab4Paradigmas/Vista/Resources/dobble.png");
        this.setIconImage(img.getImage());
        this.pack();
        this.setLocationRelativeTo(null);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempo-=1;
                timeBar.setValue(tiempo);
                if (tiempo>=0)
                    timeBar.setString(String.valueOf(tiempo));
            }
        };
        Timer timer = new Timer(1000,actionListener);
        timer.start();
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                tiempo = 8;
                if(ctrl.verificarRespuesta(juego.getArea().get(0),juego.getArea().get(1),choice.getText())){
                    int puntaje = ctrl.darPunto(juego);
                    JOptionPane.showMessageDialog(null,"Correcto!!!\n+1 punto\nTotal de "+ctrl.whoseTurnIsIt(juego)+"\n"+puntaje+" puntos");
                    if(!ctrl.stack(juego)){
                        JOptionPane.showMessageDialog(null,"No quedan cartas en el set\nGanador\n"+ctrl.getWinner(juego));
                    }
                    ctrl.llenarCarta(labelsc1,juego.getArea().get(0));
                    ctrl.llenarCarta(labelsc2,juego.getArea().get(1));
                    ctrl.changeTurn(juego);
                    turno.setText(ctrl.whoseTurnIsIt(juego));
                    StackModeView.this.revalidate();
                    StackModeView.this.repaint();
                    StackModeView.this.pack();
                }else
                    JOptionPane.showMessageDialog(null,"Incorrecto!!!");
                timer.start();
                choice.setText("");
                choice.requestFocus();
            }
        });
        timeBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(timeBar.getValue()==0){
                    timer.stop();
                    if (StackModeView.this.isActive()){
                        JOptionPane.showMessageDialog(null,"TIEMPO AGOTADO");
                        timer.start();
                        tiempo = 7;
                        ctrl.changeTurn(juego);
                        turno.setText(ctrl.whoseTurnIsIt(juego));
                    }
                }
            }
        });
    }
}
