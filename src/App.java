import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import view.Viewer;
import game.*;

public class App{

    public static void main(String[] args) {
        Game g = new Game(new Viewer());
    }

}
