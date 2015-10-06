import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HeapDriver {

    public static void main(String[] args){

        System.out.println("Enter the path to your file:");

        Scanner sc = new Scanner(System.in);
        String input = sc.next();// get input from the user for the test file

        BufferedReader br = null;


        Heap heap = new Heap();



        try {

            String line;

            br = new BufferedReader(new FileReader(input));


            while ((line = br.readLine()) != null) {

                line = line.trim();

                heap.insert(getIntFromString(line));


            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)br.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }


        heap.printHeap();

        int min = heap.deleteMin();
        System.out.println("Min: " + min);
        heap.printHeap();
    }


    /**
     * get the number for insert/removal from the file as an int
     */
    public static int getIntFromString(String input){
        try{
            return Integer.parseInt(input);
        }
        catch(Exception ex){
            return -1;
        }
    }
}
