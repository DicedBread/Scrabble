package game;

import java.util.*;

public class PlacedNode implements Iterable<PlacedNode> {

    private Tile tile;
    private Coordinate coord;

    private Map<Dir, PlacedNode> neighbors = new HashMap<>(); 
    
    enum Dir{
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }
    
    public PlacedNode(Tile t, Coordinate c){
        tile = t;
        coord = c;
    }
    
    public Tile tile() { return tile; }
    public Coordinate coord() { return coord; }
        
    public PlacedNode getNeighbor(Dir d){
        return neighbors.get(d);
    }
    
    @Override
    public Iterator<PlacedNode> iterator() {
        return new Iterator<PlacedNode>() {
            int c = 0;
            Dir[] d = Dir.values();

            @Override
            public boolean hasNext() {
                return c < 4;
            }

            @Override
            public PlacedNode next() {
                return neighbors.get(d[c++]);
            }
        };
    }

    @Override
    public String toString() {
        return tile.toString() + " " + coord.toString();
    }
}
