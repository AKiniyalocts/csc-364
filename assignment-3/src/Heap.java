K/**
 * Created by anthony on 10/5/15.
 */
public class Heap {
    public int[] elts;

    private int count;


    public Heap(){
        elts = new int[100];
        count = 0;

    }

    public void insert(int val){
        int currentPos;
        /**
         * Empty heap, insert at zero
         */
        if(this.isEmpty()){
            elts[0] = val;
            count++;
        }

        /**
         * Not empty, find next spot, then propigate up
         */
        else{
            elts[count] = val;
            currentPos = count;

            while( val< elts[getParentPos(currentPos)] && currentPos != 0){

                elts[currentPos] = elts[getParentPos(currentPos)];

                currentPos = getParentPos(currentPos);

                elts[currentPos] = val;
            }

            count++;
        }
    }

    public int deleteMin() {
        int temp = elts[0];

        elts[0] = elts[count - 1];

        count--;

        if (!this.isEmpty()) {
            this.propigateDown(0);
        }
        return temp;
    }

    /**
     * Recursively propogate down through the tree starting at index 0
     * @param pos
     */
    private void propigateDown(int pos){
        int left = getLeftChild(pos);

        int right = getRightChild(pos);

        int smallest, temp;

        if(right >= count){

            if(left >= count) {
                return;
            }
            else {
                smallest = left;
            }

        }
        else{

            if(elts[left] <= elts[right]){
                smallest = left;
            }
            else{
                smallest = right;
            }
        }

        if(elts[pos] > elts[smallest]){

            temp = elts[smallest];

            elts[smallest] = elts[pos];

            elts[pos] = temp;

            propigateDown(smallest);
        }
    }


    private int getLeftChild(int pos){
        return (2 * pos) + 1;
    }

    private int getRightChild(int pos){
        return (2 * pos) + 2;
    }

    private int getParentPos(int val){
        return (val - 1) /2;
    }

    public boolean isEmpty(){
        if(count == 0)
            return true;

        return false;
    }

    public boolean isFull(){
        if(count == 100)
            return true;

        return false;
    }

    public void printHeap(){
        if(!this.isEmpty()){
            for(int i = 0; i <= this.elts.length - 1; i++){
                System.out.println(elts[i]);
            }
        }
    }

}
