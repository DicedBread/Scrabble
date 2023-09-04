package view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel{
    private final int CELL_DIMEN = 15; 
    

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintLines(g);
    }

    private void paintLines(Graphics g){
        for(int i = 0; i <= CELL_DIMEN; i++){
            g.drawLine(cellWidth() * i, 0, cellWidth() * i , getWidth());
            g.drawLine(0, cellWidth() * i, getWidth(), cellWidth() * i);
        }
    }

    public int cellWidth(){
        return getWidth() / CELL_DIMEN;
    }
}
