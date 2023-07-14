package view;

import game.*;

import java.awt.*;
import javax.swing.*;

import Nodes.*;

import java.util.*;


public class Viewer extends JFrame{
    private final int W_WIDTH = 1000, W_HEIGHT = 1000;
    private final int BOARD_DIMEN = 1000;
    private final int CELL_DIMEN = 15; 
    private final int TILE_DIMEN = BOARD_DIMEN / CELL_DIMEN;

    private final Color TILE_COLOR = new Color(245, 212, 138, 100);
    private final Font MAIN_FONT = new Font(getName(), ALLBITS, 30);


    JPanel canvas; 
    TileNode n = null;

    public Viewer(){
        getContentPane().setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
        // setSize(WWIDTH, WHEIGHT);
        canvas = renderer();
        add(canvas);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //* creates renderer */
    private JPanel renderer(){
        return new JPanel(){
            @Override
            public void paint(Graphics g){
                super.paint(g);
                drawTiles(g, n, new HashSet<>());

                int tmp;
                for(int i = 0; i < CELL_DIMEN; i++){
                    tmp = TILE_DIMEN * i;
                    g.drawLine(tmp, 0, tmp, W_HEIGHT);        
                    g.drawLine(0 , tmp, W_WIDTH, tmp);
                }
                
            }
        };
    }

    public void repaint(TileNode n){
        this.n = n;
        canvas.repaint();
    }
    
    /** recusivly draws tiles from placed graph */
    public void drawTiles(Graphics g, TileNode node, Set<TileNode> visited){
        if(node == null) return;
        visited.add(node);
        drawTile(g, node);
        for(TileNode n : node){
            drawTiles(g, n, visited);
        }
    }

    /** draws tile in node object at node coords */
    public void drawTile(Graphics g, TileNode n){
        int x, y; 
        x = n.coord().x();
        y = n.coord().y();
        Tile t = n.tile();

        int rectX = TILE_DIMEN * x;
        int rectY = TILE_DIMEN * y;
        FontMetrics fontdoda = g.getFontMetrics(MAIN_FONT);
        int letterX = rectX + (TILE_DIMEN / 2) - fontdoda.charWidth(Character.toUpperCase(t.letter())/2 );
        int letterY = rectY + (TILE_DIMEN / 2) + fontdoda.getHeight()/4;

        g.setColor(TILE_COLOR);
        g.fillRect(rectX, rectY, TILE_DIMEN, TILE_DIMEN);
        g.setColor(Color.BLACK);
        g.setFont(MAIN_FONT);
        g.drawString(String.valueOf(t.letter()).toUpperCase(), letterX, letterY);
    }   
}
