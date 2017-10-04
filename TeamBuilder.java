<<<<<<< HEAD
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeSet;

public class TeamBuilder {

    public static void main(String[] args) {
        HashMap<String, String> charCards = new HashMap<String, String>();
        TreeSet<String> sortedLinks = new TreeSet<String>();
        Scanner input;
        try {
            File f = new File("cardDb.txt");
            input = new Scanner(f);
            String savedCard = null;
            while(input.hasNextLine()) {
                String s = input.nextLine();
                if (s.startsWith(">")) {
                    savedCard = s.substring(1);
                }
                else {
                    charCards.put(savedCard, s);
                    sortedLinks.add(s);
                }
            }
            ListDemo.createAndShowGUI(sortedLinks);
        }

        catch (FileNotFoundException e) {

        }
    }

}
=======
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeSet;

public class TeamBuilder {

    public static void main(String[] args) {
        HashMap<String, String> charCards = new HashMap<String, String>();
        TreeSet<String> sortedLinks = new TreeSet<String>();
        Scanner input;
        try {
            File f = new File("cardDb.txt");
            input = new Scanner(f);
            String savedCard = null;
            while(input.hasNextLine()) {
                String s = input.nextLine();
                if (s.startsWith(">")) {
                    savedCard = s.substring(1);
                }
                else {
                    charCards.put(savedCard, s);
                    sortedLinks.add(s);
                }
            }
            ListDemo.createAndShowGUI(sortedLinks);
        }

        catch (FileNotFoundException e) {

        }
    }

}
>>>>>>> 45fcb527b0f7e96d27d397569eaa05d4ff47fa3a
