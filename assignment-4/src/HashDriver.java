import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Class: HashDriver
 *
 * Takes two txt files and compares the words inside them.
 *
 * Like words are printed to out.txt in the project directory.
 */
public class HashDriver {

    public static void main(String[] args){

        System.out.println("Enter the path to your first file:");

        Scanner sc = new Scanner(System.in);
        String file1 = sc.next();

        BufferedReader br = null;

        BufferedWriter writer = null;


        //init hash table
        HashTable hashTable = new HashTable(143);

        // lists of common words
        List<String> common = new ArrayList<>();
        // list of unique words
        List<String> unique = new ArrayList<>();

        try {

            String line;

            br = new BufferedReader(new FileReader(file1));


            while ((line = br.readLine()) != null) {
              line = line.trim().toLowerCase();

              String[] words = removePunc(line); // remove the punctuation from the line

              for(int i = 0; i < words.length; i++){

                if(words[i] != null && words[i].length() > 3){
                    hashTable.insert(words[i]);

                    // only add if unique list doesnt have it already
                    if(!unique.contains(words[i])) {
                        unique.add(words[i]);
                    }
                }

              }

            }

            System.out.println("Enter the path to your second file:");

            String file2 = sc.next();

            br = new BufferedReader(new FileReader(file2));

            while ((line = br.readLine()) != null) {
              line = line.trim().toLowerCase();

              String[] words = removePunc(line);

              for(int i = 0; i < words.length; i++){

                if(words[i] != null && words[i].length() > 3){

                    hashTable.insert(words[i]);


                    if (hashTable.lookup(words[i]) >= 0) {
                        common.add(words[i]);
                        hashTable.markNowEmpty(hashTable.lookup(words[i]));
                    }
                }

              }

            }

            writer = new BufferedWriter(new FileWriter("out.txt", true));

            // sort the common words alphabetically
            Collections.sort(common);

            // write them to out.txt
            for(String word: common){
                writer.write(word + "\n");
            }


        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if(writer != null)
                    writer.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }


    }

    // remove puncuation from line
    public static String[] removePunc(String line){
        return line.replaceAll("[^a-zA-Z ]", "").split("\\s+");
    }

}
