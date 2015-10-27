/**
 *  class: HashTable
 *
 *  Static sized hash table. Allow for insert, lookup, hashing.
 *
 */
public class HashTable{

    private int tableSize;

    private String [] table;

    public HashTable(int size){
        tableSize = size;
        table = new String [size];
    }

    // hash an item based on (A + ( i * i) ) % 143
    public int hashFunc(String w){
        int address = -1;
        for(char c : w.toCharArray()){
            address= (address + (int)c) % tableSize;
        }
        return address;
    }

    // find hash address for the word
    public int lookup(String w){
        int address = hashFunc(w);
        int count = 0;
        while (!table[address].equals(w)) {
            count++;

            address = ((address + (count * count)) % tableSize);

            if(table[address] == null){
                return -1;
            }
        }
        return address;
    }

    // empty out hash with ####
    public void markNowEmpty(int pos){
        table[pos] = "####";
    }

    // insert the hash
    public void insert(String w) {
        int address = hashFunc(w);
        int count = 0;
        while (table[address] != null) {
            count++;
            address = ((address + (count * count)) % tableSize);
        }
        table[address] = w;
    }
}