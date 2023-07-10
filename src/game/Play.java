package game;
import java.util.*;

public class Play {
    
    String word;
    
    int indexOfEPoint;
    PlacedNode enterPoint;
    List<Tile> tiles;
    
    public Play(String word, int indexOfEPoint, PlacedNode enterPoint, List<Tile> tiles) {
        this.word = word;
        this.indexOfEPoint = indexOfEPoint;
        this.enterPoint = enterPoint;
        this.tiles = tiles;
    }
    
    public String word() { return word; }
    public int indexOfEPoint() { return indexOfEPoint; }
    public PlacedNode enterPoint() { return enterPoint; }
    // public List<Tile> tiles() { return tiles; }
    
}
