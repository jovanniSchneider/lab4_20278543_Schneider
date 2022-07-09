package main.java.Lab4Paradigmas.Vista;

import main.java.Lab4Paradigmas.Modelo.Card;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardView extends JFrame{
    private JPanel panelMain;
    private JLabel symbol1;
    private JLabel symbol2;
    private JLabel symbol3;
    private JLabel symbol4;
    private JLabel symbol5;
    private JLabel symbol6;
    private JLabel symbol7;
    private JLabel symbol8;
    private List <JLabel> labels;

    public CardView(Card carta){
        labels = new ArrayList<>();
        labels.add(symbol1);
        labels.add(symbol2);
        labels.add(symbol3);
        labels.add(symbol4);
        labels.add(symbol5);
        labels.add(symbol6);
        labels.add(symbol7);
        labels.add(symbol8);
        this.setContentPane(panelMain);
        this.setTitle("Carta");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon img = new ImageIcon("src/main/java/Lab4Paradigmas/Vista/Resources/dobble.png");
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        for (int simbolo : carta.getElementos()) {
            for (int i = 0; i < labels.size(); i++){
                if(Objects.equals(labels.get(i).getText(), "")){
                    labels.get(i).setText(String.valueOf(simbolo));
                    break;
                }
            }
        }
        this.pack();
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
