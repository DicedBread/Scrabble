package Nodes;

import game.*;
import java.util.*;

public class Node<T> implements Iterable<Node<T>> {
    
    T obj;
    Coordinate coord; 

    private Map<Dir, Node<T>> neighbors = new HashMap<>();
    
    public Node(T obj, Coordinate c) {
        this.obj = obj;
        this.coord = c;
    } 

    enum Dir{
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    public Node<T> getNeighbor(Dir d){
        return neighbors.get(d);
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new Iterator<Node<T>>() {
            int c = 0;
            Dir[] d = Dir.values();

            @Override
            public boolean hasNext() {
                return c < 4;
            }

            @Override
            public Node<T> next() {
                return neighbors.get(d[c++]);
            }
        };
    }

    @Override
    public String toString() {
        return "Node [obj=" + obj + ", coord=" + coord + "]";
    }
}
