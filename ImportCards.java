import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;


public class ImportCards {

    public static void main(String[] args) throws IOException {

        // Make a URL to the web page
        String myDirectory = "F:\\Users\\B-trey\\Desktop\\shared folder droid\\assets\\assets\\character\\card\\card";
        File dir = new File(myDirectory);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child: directoryListing) {
                String cardName = child.getName();
                cardName = cardName.substring(0, cardName.length() - 4);
                URL url = new URL("https://dbz.space/cards/" + cardName);
                URLConnection con = url.openConnection();
                InputStream is =con.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String line = null;

                // read each line and write to System.out
                while ((line = br.readLine()) != null) {
                    if (line.contains("<h2>")) {
                        line = line.trim();
                        line = line.substring(4, line.length() - 5);
                        System.out.println(line);
                    }
                    if (line.contains("link_item")) {

                    }
                }
            }
        }


        // Get the input stream through URL Connection

    }

}
