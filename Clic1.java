import javax.swing.*; // Pour JFrame
import java.awt.event.*; // Pour mouseEvent et MouseListener


class MaFenetre extends JFrame implements MouseListener{
    // Constructeur
    public MaFenetre(){
        setTitle("Gestion des clics");
        setBounds(10,20,300,200);
        addMouseListener(this); // La fenetre sera son propre écouteur d'evenements de souris
    }
    
    // Methode gerant un clic souris
    public void mouseClicked(MouseEvent ev){
        int x = ev.getX();
        int y = ev.getY();

        System.out.println("clic dans la fenetre à la position X="+x+" et Y="+y);
    }

    public void mousePressed (MouseEvent ev) {
        System.out.println("Le bouton est pressé");
    }

    public void mouseReleased(MouseEvent ev) {
        System.out.println("Le bouton est relaché");
    }

    public void mouseEntered (MouseEvent ev) {
        System.out.println("Le bouton est entrée");
    }

    public void mouseExited (MouseEvent ev) {
        System.out.println("Le bouton est sorti");
    }
}

public class Clic1{
    public static void main (String args[]){
        MaFenetre fen = new MaFenetre();
        fen.setVisible(true);
    }
}


