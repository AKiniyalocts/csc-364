import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DagDriver{

public static void main(String[] args) {

    try{
  		BufferedReader reader = new BufferedReader(new FileReader("DAG.txt"));

  		int verticies = Integer.parseInt(reader.readLine());
  		int edges = Integer.parseInt(reader.readLine());
  		String line = "";

  		Dag dag = new Dag(verticies);

  		while ((line = reader.readLine()) != null) {
  			String[] data = line.split(" ");
  			dag.setXY(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
  		}

  		dag.setInDegree();
  		dag.topologicalSort();

  		reader.close();
    }catch(IOException io){
      io.printStackTrace();
    }
	}
}
