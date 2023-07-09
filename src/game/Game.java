
package game;

import java.util.*;

import view.Viewer;

import java.io.*;

public class Game {
    
    List<Tile> tiles;
    List<Tile> players;
    Viewer viewer;

    Node placed = null;

    public Game(Viewer v){
        this.viewer = v;
        tiles = loadTile(new File("/src/data/letters.csv"));
        
    }


    public Node testGraph(){
        return new Node(new Tile('e', 7), new Coordinate(7, 7));
        
    }



    /** loads letters to list of playable tiles
     *  csv format letter, points, count 
     */
    private List<Tile> loadTile(File f){
        List<Tile> out = new ArrayList<>();
        try{
            Scanner s = new Scanner(f);
            String line;
            String[] data;
            char c;
            int points, count; 
            while(s.hasNextLine()){
                line = s.nextLine();
                data = line.split(",");
                if(data[0].equals("?")) continue; // TODO omiting blanks atm
                
                c = data[0].charAt(0);
                points = Integer.valueOf(data[1]);
                count = Integer.valueOf(data[2]);

                for(int i = 0; i < count; i++){
                    out.add(new Tile(c, points));
                }
            }
        }catch(Exception e) { System.out.println(e); }
        return out;
    }




}
