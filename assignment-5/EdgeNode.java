/**
 * Created by anthonykiniyalocts on 11/9/15.
 */
public class EdgeNode {

    public static EdgeNode emptyEdge(){
        return new EdgeNode(-1, -1, 0);
    }

    private int startVertex;

    private int adjacentVertex;

    private int weight;

    private EdgeNode next;

    public EdgeNode(int x, int y, int w){
        this.startVertex = x;
        this.adjacentVertex = y;
        this.weight = w;
        this.next = null;
    }

    public int getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(int startVertex) {
        this.startVertex = startVertex;
    }

    public int getAdjacentVertex() {
        return adjacentVertex;
    }

    public void setAdjacentVertex(int adjacentVertex) {
        this.adjacentVertex = adjacentVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }
}
