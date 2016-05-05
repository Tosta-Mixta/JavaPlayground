import javax.swing.*;

class MaFenetre extends JFrame{
    // Constructeur
    public MaFenetre(){
        setTitle ("Ma Super Application");
        setBounds (50,100,300,150);
    }    
}


public class PremFen1{
    public static void main (String args[]){
        JFrame fen = new MaFenetre();
        fen.setVisible(true);
    }
}

