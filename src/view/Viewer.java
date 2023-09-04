package view;

import game.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


import java.util.*;


public class Viewer extends JFrame{
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int W_WIDTH = ((int) screenSize.getWidth())/3, W_HEIGHT = (int) screenSize.getHeight();
    private final int BOARD_DIMEN = 800;
    private final int CELL_DIMEN = 15; 
    private final int TILE_DIMEN = BOARD_DIMEN / CELL_DIMEN;

    private final Color TILE_COLOR = new Color(245, 212, 138, 100);
    private final Font MAIN_FONT = new Font(getName(), ALLBITS, 30);


    JPanel board; 
    Game game;

    public Viewer(){
        getContentPane().setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
        // setSize(WWIDTH, WHEIGHT);
        board = new Board();
        add(board);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setUpBoardMouse(){
        board.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                System.out.println("ije");
            }

            public void mouseReleased(MouseEvent e){

            }
        });
    }
    // public void repaint(TileNode n){
    //     this.n = n;
    //     canvas.repaint();
    // }
    


}
