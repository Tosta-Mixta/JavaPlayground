import javax.swing.*;
import java.util.Scanner;

class MaFenetre extends JFrame {
    // Constructeur
    public MaFenetre(){
        setTitle("Ma Fenetre cool");
        setBounds(50,100,300,150);
    }
}

public class PremFen2{
    public static void main(String args[]){
        JFrame fen = new MaFenetre();
        fen.setVisible(true);
        
        // Fin sur longeur ttire nulle
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Nouvelle largeur: ");
            int larg = reader.nextInt();
            
            System.out.println("Nouvelle hauteur: ");
            int haut = reader.nextInt();

            System.out.print("Nouveau titre : (vide pour finir) ");
            String tit = reader.nextLine();

            if (tit.length() == 0) break;
            fen.setSize(larg, haut);
            fen.setTitle(tit);
        }
    }
}

