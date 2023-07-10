package data;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import view.Viewer;

public class DataMoment{

    // public static void main(String[] args) {
    //     Viewer v = new Viewer();
    //     v.setDefaultCloseOperation(v.EXIT_ON_CLOSE);
    //     v.setVisible(true);
    // }

    public static void main(String[] args) {

        try {
            File f = new File("src/data/OPTED-Dictionary.csv");
            FileWriter o = new FileWriter("src/data/words.csv");   
            Set<String> bruh = new HashSet<>();


            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                String line = s.nextLine();
                String e = line.split(",")[0];
                
                if(e.matches(".*[^a-zA-Z]+.*")){
                    System.out.println("bruh");
                    System.out.println(e);
                    continue;
                }

                if(!bruh.contains(e)){
                    o.write(e + "\n");
                    bruh.add(e);
                }
            }
            s.close();
            o.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
