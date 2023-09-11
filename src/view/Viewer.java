package view;

import game.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.border.Border;

import java.util.*;


public class Viewer extends JFrame{
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int W_WIDTH = ((int) screenSize.getWidth())/3, 
                      W_HEIGHT = (int) (screenSize.getHeight() / 8 ) * 7;
    private final int BOARD_DIMEN = 800;
    private final int CELL_DIMEN = 15; 
    private final int TILE_DIMEN = BOARD_DIMEN / CELL_DIMEN;

    private final Color TILE_COLOR = new Color(245, 212, 138, 100);
    private final Font MAIN_FONT = new Font(getName(), ALLBITS, 30);


    Board board; 
    Game game;
    JPanel dialogue;  
    JLabel info;

    public Viewer(){
        getContentPane().setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
        // setSize(WWIDTH, WHEIGHT);
        setLayout(new BorderLayout());
        board = new Board();
        info = new JLabel("dude");
        setUpBoardMouse();
        setUpDialogueArea();
        board.setPreferredSize(new Dimension(BOARD_DIMEN, BOARD_DIMEN));
        add(board, BorderLayout.PAGE_START);
        board.setBackground(Color.red);
        add(dialogue, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setUpDialogueArea(){
        dialogue = new JPanel();
        dialogue.setPreferredSize(new Dimension(WIDTH, W_HEIGHT - W_WIDTH));
        dialogue.add(info);
        info.setBackground(Color.blue);
    }

    public void setUpBoardMouse(){
        board.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
            }

            public void mouseReleased(MouseEvent e){
            }
        });

        board.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e){
                
            }
        });
    }



    // public void make


    // public void repaint(TileNode n){
    //     this.n = n;
    //     canvas.repaint();
    // }
    


}
