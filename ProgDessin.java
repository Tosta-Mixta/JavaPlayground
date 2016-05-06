import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class FenMenu extends JFrame implements ActionListener{
    static public final String[] nomCouleurs = {"rouge", "vert", "jaune", "bleu"};
    static public final Color[] couleurs = {Color.red, Color.green, Color.yellow, Color.blue};
    static public final String[] nomIcones = {"rouge.gif", "green.gif", "yellow.gif", "blue.gif"};

    public FenMenu (){
        setTitle("Figures avec Menus et barre d'outils");
        setSize(450, 200);
        Container contenu = getContentPane();

        /* Creation panneau pour les dessins */
        pan = new Paneau();
        contenu.add(pan);
        pan.setBackground(Color.cyan);
        int nbCouleurs = nomCouleurs.length;

        /* Création des actions */
        actions = new ActionCouleur[nbCouleurs];
        for (int i=0; i<nbCouleurs; i++){
            actions[i] = new ActionCouleur(nomCouleurs[i], couleurs[i], nomIcones[i], pan);
        }

        /* Creation de la barre de menu */
        barreMenus = new JMenuBar();
        setJMenuBar(barreMenus);

        /* Creation des menu Couleur et des options */
        couleur = new JMenu("Couleur");
        couleur.setMnemonic('C');
        barreMenus.add(couleur);
        for (int i=0; i<nomCouleurs.length; i++)
            couleur.add(actions[i]);

        /* Creation du menu Couleur et de ses options */
        couleurSurb = new JPopupMenu();
        for (int i=0; i<nomCouleurs.length;i++)
            couleurSurb.add(actions[i]);

        /* Création du menu formes et ses otpions (ovale et rectangle) */
        formes = new JMenu("Formes");
        formes.setMnemonic('F');
        barreMenus.add(formes);

        /** Ajout de la forme rectangle **/
        rectangle = new JCheckBoxMenuItem("Rectangle");
        formes.add(rectangle);
        rectangle.addActionListener(this);

        /** Ajout de la forme ovale **/
        ovale = new JCheckBoxMenuItem("Ovale");
        formes.add(ovale);
        ovale.addActionListener(this);

        /* Affichage menu popup lors d'un clic dans la fenetre */
        /* Dans une fonction annonymes */
        addMouseListener (new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                if (e.isPopupTrigger())
                    couleurSurb.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        /* Création menu Dimensions et ses options Hauteur et Largeur */
        dimensions = new JMenu("Dimensions");
        dimensions.setMnemonic('D');
        barreMenus.add(dimensions);

        /** Ajout de largeur **/
        largeur = new JMenuItem("Largeur");
        dimensions.add(largeur);
        largeur.addActionListener(this);

        /** Ajout de hauteur **/
        hauteur = new JMenuItem("Hauteur");
        dimensions.add(hauteur);
        hauteur.addActionListener(this);

        /* Creation de la barre d'outils (avec suppression textes associes et ajout de bulles d'aide */
        barreCouleurs = new JToolBar();
        for (int i=0;i<nomCouleurs.length;i++){
            JButton boutonCourant = barreCouleurs.add(actions[i]);
            boutonCourant.setText(null);
            boutonCourant.setToolTipText((String)actions[i].getValue(Action.SHORT_DESCRIPTION));
        }
        contenu.add(barreCouleurs, "North");
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source == largeur){
            String ch = JOptionPane.showInputDialog(this, "Largeur");
            pan.setLargeur(Integer.parseInt(ch));
        }

        if (source == hauteur){
            String ch = JOptionPane.showInputDialog(this, "Hauteur");
            pan.setHauteur(Integer.parseInt(ch));
        }
        if (source == ovale) pan.setOvale(ovale.isSelected());
        if (source == rectangle) pan.setRectangle(rectangle.isSelected());
        pan.repaint();
    }
    private JMenuBar barreMenus;
    private JMenu couleur, dimensions, formes;
    private JMenuItem [] itemCouleurs;
    private JMenuItem largeur, hauteur;
    private JCheckBoxMenuItem rectangle, ovale;
    private JPopupMenu couleurSurb;
    private ActionCouleur [] actions;
    private JToolBar barreCouleurs;
    private Paneau pan;
}

class Paneau extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (ovale) g.drawOval (10,10,10+largeur, 10+hauteur);
        if (rectangle) g.drawRect (10,10,10+largeur, 10+hauteur);
    }
    public void setRectangle(boolean trace){
        rectangle = trace;
    }
    public void setOvale(boolean trace){
        ovale = trace;
    }
    public void setLargeur(int l){
        largeur = l;
    }
    public void setHauteur(int h){
        hauteur = h;
    }
    public void setCouleur(Color c){
        setBackground(c);
    }
    private boolean rectangle = false, ovale = false;
    private int largeur=50, hauteur=50;
}

class ActionCouleur extends AbstractAction{
    public ActionCouleur(String nom, Color couleur, String nomIcone, Paneau pan){
        putValue(Action.NAME, nom);
        putValue(Action.SMALL_ICON, new ImageIcon(nomIcone));
        putValue(Action.SHORT_DESCRIPTION, "Fond "+nom);
        this.couleur = couleur;
        this.pan = pan;
    }
    public void ActionPerformed(ActionEvent e){
        pan.setCouleur(couleur);
        pan.repaint();
        setEnabled(false);
        if (actionInactive != null) actionInactive.setEnabled(true);
        actionInactive = this;
    }
    private Color couleur;
    private Paneau pan;
    static ActionCouleur actionInactive; // ne pas oublier "static"
}
public class ProgDessin{
    public static void main (String args[]){
        FenMenu fen = new FenMenu();
        fen.setVisible(true);
    }
}