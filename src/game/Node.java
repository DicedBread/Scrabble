package game;

import java.util.*;



public class Node implements Iterable<Node> {

    private Tile tile;
    
    private Coordinate coord;

    private Map<Dir, Node> neighbors; 
    
    enum Dir{
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }
    
    public Node(Tile t, Coordinate c){
        tile = t;
        coord = c;
    }
    
    public Tile tile() { return tile; }
    public Coordinate coord() { return coord; }
        
    public Node getNeighbor(Dir d){
        return neighbors.get(d);
    }
    
    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            int c = 0;
            Dir[] d = Dir.values();

            @Override
            public boolean hasNext() {
                return c < 4;
            }

            @Override
            public Node next() {
                return neighbors.get(d[c++]);
            }
        };
    }
}
