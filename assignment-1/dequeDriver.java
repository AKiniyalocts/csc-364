import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
  author: Anthony Kiniyalocts
  class: dequeDriver
  9/7/15

*/

public class dequeDriver{

  public static void main(String[] args){

    System.out.println("Enter the path to your file:");

    Scanner sc = new Scanner(System.in);
    String input = sc.next();// get input from the user for the test file

    BufferedReader br = null;

		try {

			String line;

			br = new BufferedReader(new FileReader(input));

      deque mDeque = new deque();

			while ((line = br.readLine()) != null) {

        // insertFront
        if(line.contains("IF")){
          mDeque.insertFront(getIntFromString(line));
        }

        // insertRear
        else if(line.contains("IR")){
          mDeque.insertRear(getIntFromString(line));
        }

        // deleteFront
        else if(line.contains("DF")){
          mDeque.deleteFront();
        }

        // deleteRear
        else if(line.contains("DR")){
          mDeque.deleteRear();
        }

        // printDeque
        else{
          mDeque.printDeque();
        }
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

	}

  /**
  * get the number for insert/removal from the file as an int
  */
  public static int getIntFromString(String input){
    try{
      return Integer.parseInt(input.substring(input.length() - 1));
    }
    catch(Exception ex){
      return -1;
    }
  }


}
