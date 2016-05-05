import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenBoutonsDyn extends JFrame(){
    public FenBoutonsDyn(){
        setTitle("Boutons Dynamiques");
        setSize(500, 150);
        Container contenu = getContentPane();
        contenu.setLayout(new FlowLayout());
        
        crBouton = new JButton("CREATION BOUTON");
        contenu.add(crBouton);
        EcouteCr ecouteCr = new EcoutCr (contenu);
        crBouton.addActionListener(ecoutCr);
    }
    private JButton crButton;
}


