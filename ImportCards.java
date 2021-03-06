<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;




public class ImportCards {

    public static void main(String[] args) throws IOException, InterruptedException {
        String line = null;
        String cardName = null;
        String path;
        int fileIndex = 0;
        int running = 0;
        running = FileChooser.main(args);
        //waits for FileChooser to finish
        while (running == 0) {
           Thread.sleep(1000);
        }
        String myDirectory = FileChooser.getPath();
        File dir = new File(myDirectory);
        int numFiles = dir.listFiles().length;
        File[] directoryListing = dir.listFiles();
        PrintWriter writer = new PrintWriter(new BufferedWriter (new FileWriter("cardDB.txt")));

            // Get card ID number
        while (true) {
            try {
                if (directoryListing != null) {
                    for (; fileIndex < numFiles; fileIndex ++) {
                        cardName = directoryListing[fileIndex].getName();
                        cardName = cardName.substring(0, cardName.length() - 4);
                        // uses dbz.space to access card information
                        URL url = new URL("https://dbz.space/cards/" + cardName);

                        URLConnection con = url.openConnection();
                        InputStream is = con.getInputStream();

                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        // read each line
                        while ((line = br.readLine()) != null) {
                            if (line.contains("<h2>")) {
                                line = line.trim();
                                line = line.substring(3, line.length() - 5);
                                writer.println(line);
                            }
                            if (line.contains("link_item")) {
                                String[] parts = line.split(">");
                                int linkCount = parts.length / 4;
                                for (int i = 0; i < linkCount; i++) {
                                   writer.println(parts[i*4+3].substring(0, parts[i*4+3].length() - 3));
                                }
                            }
                        }
                    }
                }
                break;
            }
            //if card not found change card id by one to check for differences
            //between database and website
            catch (FileNotFoundException e) {
                try {
                    System.out.println(cardName + " not found");
                    cardName = cardName.substring(0, cardName.length() - 1) + "1";

                    URL url = new URL("https://dbz.space/cards/" + cardName);
                    URLConnection con = url.openConnection();
                    InputStream is = con.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    while ((line = br.readLine()) != null) {
                        if (line.contains("<h2>")) {
                            line = line.trim();
                            line = line.substring(3, line.length() - 5);
                            writer.println(line);
                        }
                        if (line.contains("link_item")) {
                            String[] parts = line.split(">");
                            int linkCount = parts.length / 4;
                            for (int i = 0; i < linkCount; i++) {
                               writer.println(parts[i*4+3].substring(0, parts[i*4+3].length() - 3));
                            }
                        }
                    }
                    fileIndex++;
                }

                catch (FileNotFoundException ex) {
                    fileIndex++;
                }
            }

        }
        writer.close();
    }
}
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;




public class ImportCards {

    public static void main(String[] args) throws IOException, InterruptedException {
        String line = null;
        String cardName = null;
        String path;
        int fileIndex = 0;
        int running = 0;
        running = FileChooser.main(args);
        //waits for FileChooser to finish
        while (running == 0) {
           Thread.sleep(1000);
        }
        String myDirectory = FileChooser.getPath();
        File dir = new File(myDirectory);
        int numFiles = dir.listFiles().length;
        File[] directoryListing = dir.listFiles();
        PrintWriter writer = new PrintWriter(new BufferedWriter (new FileWriter("cardDB.txt")));

            // Get card ID number
        while (true) {
            try {
                if (directoryListing != null) {
                    for (; fileIndex < numFiles; fileIndex ++) {
                        cardName = directoryListing[fileIndex].getName();
                        cardName = cardName.substring(0, cardName.length() - 4);
                        // uses dbz.space to access card information
                        URL url = new URL("https://dbz.space/cards/" + cardName);

                        URLConnection con = url.openConnection();
                        InputStream is = con.getInputStream();

                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        // read each line
                        while ((line = br.readLine()) != null) {
                            if (line.contains("<h2>")) {
                                line = line.trim();
                                line = line.substring(3, line.length() - 5);
                                writer.println(line);
                            }
                            if (line.contains("link_item")) {
                                String[] parts = line.split(">");
                                int linkCount = parts.length / 4;
                                for (int i = 0; i < linkCount; i++) {
                                   writer.println(parts[i*4+3].substring(0, parts[i*4+3].length() - 3));
                                }
                            }
                        }
                    }
                }
                break;
            }
            //if card not found change card id by one to check for differences
            //between database and website
            catch (FileNotFoundException e) {
                try {
                    System.out.println(cardName + " not found");
                    cardName = cardName.substring(0, cardName.length() - 1) + "1";

                    URL url = new URL("https://dbz.space/cards/" + cardName);
                    URLConnection con = url.openConnection();
                    InputStream is = con.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    while ((line = br.readLine()) != null) {
                        if (line.contains("<h2>")) {
                            line = line.trim();
                            line = line.substring(3, line.length() - 5);
                            writer.println(line);
                        }
                        if (line.contains("link_item")) {
                            String[] parts = line.split(">");
                            int linkCount = parts.length / 4;
                            for (int i = 0; i < linkCount; i++) {
                               writer.println(parts[i*4+3].substring(0, parts[i*4+3].length() - 3));
                            }
                        }
                    }
                    fileIndex++;
                }

                catch (FileNotFoundException ex) {
                    fileIndex++;
                }
            }

        }
        writer.close();
    }
}
>>>>>>> 45fcb527b0f7e96d27d397569eaa05d4ff47fa3a
