package game;

import java.util.*;

public class Player {

    private static final int MAX_TILES = 7;

    List<Tile> tiles;

    public Player(){
        tiles = new ArrayList<Tile>();
    }

    public boolean addTile(Tile t){
        if(tiles.size() >= MAX_TILES) return false;
        tiles.add(t);
        return true;
    }

    public boolean hasMaxTiles(){
        if(tiles.size() >= 7) return true;
        return false;
    }
    
    public int tileCount(){
        return tiles.size();
    }


}
