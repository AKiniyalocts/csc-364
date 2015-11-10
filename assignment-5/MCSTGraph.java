import java.util.HashSet;
import java.util.Set;

/**
 * Created by anthonykiniyalocts on 11/9/15.
 */
public class MCSTGraph {

    private EdgeNode[] edgeList;

    private int numVerticies;

    public MCSTGraph(int n){
        numVerticies = n;
        edgeList = new EdgeNode[n];

        for(int i = 0; i < n; i++){
            edgeList[i] = EdgeNode.emptyEdge();
        }

    }

    public int primsAlg(){

        int totalCost = 0;

        Set<Integer> unvisited = new HashSet<>(numVerticies);

        for(int x = 1; x < numVerticies; x++){
            unvisited.add(x);
        }

        Set<Integer> visited = new HashSet<>(numVerticies);
        visited.add(0);

        Set<EdgeNode> currentEdges = new HashSet<>(numVerticies * numVerticies);

        while(!unvisited.isEmpty()){

            for(int i: visited){
                EdgeNode edge = edgeList[i];

                while(edge != null){
                    if(unvisited.contains(edge.getAdjacentVertex())){
                        currentEdges.add(edge);
                    }

                    //increment edge
                    edge = edge.getNext();
                }
            }

            int lowestEdgeCost = Integer.MAX_VALUE;
            EdgeNode lowestEdge = null;

            for (EdgeNode e : currentEdges) {
                if (e.getWeight() < lowestEdgeCost) {
                    lowestEdge = e;
                    lowestEdgeCost = e.getWeight();
                }
            }

                System.out.println(lowestEdge.getStartVertex() + " --- " + lowestEdge.getAdjacentVertex() + " == " + lowestEdge.getWeight());


                totalCost = totalCost + lowestEdge.getWeight();

                currentEdges.clear();

                visited.add(lowestEdge.getAdjacentVertex());

                unvisited.remove(lowestEdge.getAdjacentVertex());



        }

        return totalCost;

    }

    public void insert(int x, int y, int w){

        EdgeNode e1 = new EdgeNode(x, y, w);
        EdgeNode e2 = new EdgeNode(y, x, w);

        e1.setNext(edgeList[x].getNext());
        edgeList[x].setNext(e1);

        e2.setNext(edgeList[y].getNext());
        edgeList[y].setNext(e2);

    }

    public int getNumVerticies(){
        return numVerticies;
    }
}
