import java.util.Queue;

public class BST{

  private BSTNode root;

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
    Queue<BSTNode> queue = new Queue<BSTNode>();
    queue.add(root);

      while(!queue.isEmpty()){

        BSTNode tempNode = queue.poll();

        System.out.printf("%d ",tempNode.getVal() + "");

        if(tempNode.getLeft()!=null)
          queue.add(tempNode.getLeft());

        if(tempNode.getRight()!=null)
          queue.add(tempNode.getRight());

      }

  }

  public void inOrder(){

  }

  public boolean isEmpty(){
    return this.root == null;
  }
}
