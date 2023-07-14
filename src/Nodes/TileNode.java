package Nodes;

import game.Coordinate;
import game.Tile;

public class TileNode extends Node<Tile>{
        
    public TileNode(Tile t, Coordinate c){
        super(t, c);
    }
    
    public Tile tile() { return super.obj; }
    public Coordinate coord() { return super.coord; }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
