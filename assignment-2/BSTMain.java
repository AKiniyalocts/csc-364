import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by AKiniyalocts on 9/22/15.
 *
 * Class: Driver class for BST
 */
public class BSTMain {

     public static void main(String[] args){

         System.out.println("Enter the path to your file:");

         Scanner sc = new Scanner(System.in);
         String input = sc.next();// get input from the user for the test file

         BufferedReader br = null;

         BST bst = new BST();


         try {

             String line;

             br = new BufferedReader(new FileReader(input));


             while ((line = br.readLine()) != null) {

                 line = line.trim();

                 bst.insert(getIntFromString(line));


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

        System.out.println("LEVEL ORDER TRAVERSAL\n");
        bst.levelOrder();


        System.out.println("\nIN ORDER TRAVERSAL\n");
        bst.inOrder();

        System.out.println("\nREVERSE ORDER TRAVERSAL\n");
        bst.reverseOrder();
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
