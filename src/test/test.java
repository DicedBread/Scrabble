package test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import game.*;

public class test {
    @Test
    public void test1(){
        assert(true);
    }

    @Test
    public void checkValidPlay(){
        Game g = new Game();
        
        assert(g.playIsValid(new Play("dude", 0, null, null)))
    }

    @Test
    public void checkInvalidPlay(){

    }
}
