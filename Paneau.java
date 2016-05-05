import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MaFenetre extends JFrame{
    public MaFenetre() {
        setTitle("Fenetre= panneau jaune");
        setSize(300, 150);
        panneau = new JPanel();
        panneau.setBackground(Color.yellow);
        getContentPane().add(panneau);
    }
    private JPanel panneau;
}

public class Paneau{
    public static void main (String args []){
        MaFenetre fen = new MaFenetre();
        fen.setVisible(true);
    }
}