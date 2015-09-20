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

  }

  public void inOrder(){

  }
  
  public boolean isEmpty(){
    return this.root == null;
  }
}
