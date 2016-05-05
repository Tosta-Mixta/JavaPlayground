import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Fen1Button extends JFrame {
    public Fen1Bouton (){
        setTitle("Premier bouton");
        setSize(300,200);
        
        monBouton = new JButton("Essai");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(monBouton);
    }
    private JButton monBouton;
}
public class Bouton1{ 
    public static void main (String args[]){
        Fen1Bouton fen = new Fen1Bouton();
        fen.setVisible(true);
    }
}

