import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Class: BST
 * Binary source tree
 */

public class BST{

  private BSTNode root;

  private int level;


  public BST(){
    this.root = null;
  }

  public void insert(int val){
    if(this.isEmpty()){
      root = new BSTNode(val, 1);
    }

    else {

      root.add(val, 1);

    }
  }

  public void levelOrder(){
    Queue<BSTNode> queue = new ConcurrentLinkedQueue<>();

    queue.add(root);

      while(!queue.isEmpty()){

        BSTNode tempNode = queue.poll();

        level = tempNode.level;


        if(tempNode.getLeft()!= null) {
          tempNode.level = root.level + 1;

          queue.add(tempNode.getLeft());
        }

        if(tempNode.getRight()!= null) {
          tempNode.level = root.level + 1;

          queue.add(tempNode.getRight());
        }



        if(level == tempNode.level) {
          System.out.print(tempNode.getVal() + "  ");
        }
        else {
          System.out.print(tempNode.getVal() + "  ");
          System.out.println();

        }


      }

  }

  public void inOrder(){
    if (root == null ){
      System.out.println("Empty BST");
    }

    root.inOrder();
  }

  public void reverseOrder(){
    if(root == null){
      System.out.println("Empty BST");
    }

    root.reverseOrder();
  }

  public boolean isEmpty(){
    return this.root == null;
  }
}
