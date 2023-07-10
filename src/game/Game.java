
package game;

import java.util.*;

import javax.script.ScriptEngine;

import view.Viewer;

import java.io.*;

public class Game {

    private final int PLAYER_COUNT = 4;
    
    
    private final Set<String> words = loadWords("/src/data/words.csv");

    private List<Tile> tiles;
    private List<Player> players;
    private Viewer viewer;

    private Map<Coordinate, PlacedNode> usedLoc = new HashMap<>(); 

    PlacedNode placed = null;

    public Game(Viewer v){
        
        this.viewer = v;
        this.players = List.of(new Player(), new Player(), new Player(), new Player());
        tiles = loadTiles(new File("/src/data/letters.csv"));

        // placed = 
        v.repaint(placed);
    }

    public void placePlay(Play p){
        
    }   
    
    public boolean playIsValid(Play p){
        // any other tile in path of play 
    }

    // public PlacedNode testGraph(){
    //     return new PlacedNode(new Tile('x', 7), new Coordinate(7, 7));
    // }
    
    /** loads all valid words from file */
    public Set<String> loadWords(String fN){
        try{
            File f = new File(fN);
            Set<String> out = new HashSet<>();
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                out.add(s.nextLine());
            }
            s.close();
            return Collections.unmodifiableSet(out);
        }catch(Exception e) {System.out.println(e);}
        return null;
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
        }catch(Exception e) { System.out.println(e); }
        return out;
    }
}
