package resources;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class WindowFrame extends javax.swing.JFrame {
    
    //VARIAVEIS PARA ARRASTAR JANELA VISUAL
    private int pX,pY;
    
    private javax.swing.JLabel labelBackground;

    public void setLabelBackground(JLabel labelBackground) {
        this.labelBackground = labelBackground;
    }
    
    public void setBackgroundMovable(){
    labelBackground.addMouseListener(new MouseAdapter(){
    @Override
    public void mousePressed(MouseEvent me)
        {
        // Get x,y and store them
        pX=me.getX();
        pY=me.getY();
        }
    });

    // Add MouseMotionListener for detecting drag
    labelBackground.addMouseMotionListener(new MouseAdapter(){
        @Override
        public void mouseDragged(MouseEvent me)
        {
            // Set the location
            // get the current location x-co-ordinate and then get
            // the current drag x co-ordinate, add them and subtract most recent
            // mouse pressed x co-ordinate
            // do same for y co-ordinate
            setLocation(getLocation().x+me.getX()-pX,getLocation().y+me.getY()-pY);
        }
    });
    }
}
