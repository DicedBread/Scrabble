package view;

import javax.swing.JFrame;

import game.*;

import java.awt.*;
import javax.swing.*;
import java.util.*;


public class Viewer extends JFrame{
    private final int W_WIDTH = 1000, W_HEIGHT = 1000;
    private final int BOARD_DIMEN = 1000;
    private final int CELL_DIMEN = 15; 
    private final int TILE_DIMEN = BOARD_DIMEN / CELL_DIMEN;

    Canvas canvas; 

    public Viewer(){
        getContentPane().setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
        pack();
        // setSize(WWIDTH, WHEIGHT);
        canvas = renderer();
        add(canvas);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private Canvas renderer(){
        return new Canvas(){
            @Override
            public void paint(Graphics g){
                super.paint(g);

                int tmp;
                for(int i = 0; i < CELL_DIMEN; i++){
                    tmp = TILE_DIMEN * i;
                    g.drawLine(tmp, 0, tmp, W_HEIGHT);        
                    g.drawLine(0 , tmp, W_WIDTH, tmp);
                }
            }
        };
    }


    /** recusivly draws tiles from placed graph */
    public void drawTile(Graphics g, Node node, Set<Node> visited){
        visited.add(node);
        drawTile(g, node);
        for(Node n : node){
            if(n == null) continue;
            drawTile(g, n, visited);
        }
    }

    /** draws tile in node object at node coords */
    public void drawTile(Graphics g, Node n){
        int x, y; 
        x = n.coord().x();
        y = n.coord().y();
        Tile t = n.tile();
        
        


    }

    
}
