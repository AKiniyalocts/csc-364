import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by anthonykiniyalocts on 11/9/15.
 */
public class MCSTDriver {

    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));

            int numVerticies = Integer.parseInt(reader.readLine()); //read the verticies
            int numEdges = Integer.parseInt((reader.readLine())); // read edges

            String line;

            MCSTGraph myGraph = new MCSTGraph(numVerticies);

            while ((line = reader.readLine())  != null) {

                String[] values = line.split(" ");
                myGraph.insert(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
            }

            System.out.println("Total cost: " + myGraph.primsAlg());

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
