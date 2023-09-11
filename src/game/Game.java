
package game;

import java.util.*;

// import Nodes.*;
import view.Viewer;

import java.io.*;

public class Game {

    private final int PLAYER_COUNT = 4;
    
    // private final Set<String> 

    private List<Tile> tiles;
    private List<Player> players; 
    private Viewer viewer;

    // private Map<Coordinate, PlacedNode> usedLoc = new HashMap<>(); 

    // PlacedNode placed = null; 
  
    public Game(Viewer v){
        this.viewer = v;
        this.players = List.of(new Player(), new Player(), new Player(), new Player());
        tiles = loadTiles(new File("src/data/letters.csv"));
        Collections.shuffle(tiles);

            
        distributeTiles(players);



        // placed = testGraph();
        // v.repaint(placed);
    }

    public Play createPlay(){
        return null;
    }   
    
    public void distributeTiles(List<Player> p){
        for(Player player : p){
            while(!player.hasMaxTiles()){
                player.addTile(tiles.get(tiles.size() - 1));
                tiles.remove(tiles.size() - 1);
            }
        }
    }

    /** loads letters to list of playable tiles
     *  csv format letter, points, count 
     */
    private List<Tile> loadTiles(File f){
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
            s.close();
        }catch(Exception e) { System.out.println(e); }
        return out;
    }
}
