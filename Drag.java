import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class MaFenetre extends JFrame {
    public MaFenetre(){
        setTitle("Essai drag souris");
        setSize(300, 200);
        panneau = new Panneau();
        getContentPane().add(panneau);
    }
    private JPanel panneau;
}

class Panneau extends JPanel implements MouseMotionListener{
    Panneau(){
        addMouseMotionListener(this);
        addMouseListener(new MouseAdapter(){
            public void mouseReleased (MouseEvent e){
                enCours = false;
                System.out.println("Release "+e.getX()+" "+e.getY());
            }
        });
        repaint();
    }
    public void MouseDragged(MouseEvent e){
        System.out.println("Drag "+e.getX()+" "+ e.getY());
        if (!enCours){
            XDeb = e.getX();
            YDeb = e.getY();
            xFin = XDeb;
            yFin = YDeb;
            enCours = true;
        }
        else{
            xFin = e.getX();
            yFin = e.getY();
        }
        repaint();
    }
    public void mouseMouved(MouseEvent e){}
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int xd, xf, yd, yf;
        xd = Math.min(XDeb, xFin);
        xf = Math.max(XDeb, xFin);
        yd = Math.min(YDeb, yFin);
        yf = Math.max(YDeb, yFin);
        g.drawRect(xd, yd, xf-xd, yf-yd);
    }
    private boolean enCours = false;
    private int XDeb, YDeb, xFin, yFin;
}
public class Drag{
    public static void main(String args[]){
        MaFenetre fen = new MaFenetre();
        fen.setVisible(true);
    }
}