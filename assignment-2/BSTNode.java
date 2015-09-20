public class BSTNode{

  protected int val;

  BSTNode left;

  BSTNode right;

  int level;

  public BSTNode(int v, int lev){
    val = v;
    level = lev;

    left = null;
    right = null;
  }


  public void add(int val, int lev){
    if(this.getVal() > val){

      if(this.getLeft() == null){

        this.setLeft(new BSTNode(val, lev));

      }
      else {
        this.getLeft().add(val, lev + 1);
      }

    }

    else {
      if(this.getRight() == null){

        this.setRight(new BSTNode(val, lev));

      }
      else {

        this.getRight().add(val, lev + 1);

      }

    }

  }


  public void setVal(int val){
    this.val = val;
  }

  public int getVal(){
    return this.val;
  }

  public void setLeft(BSTNode left){
    this.left = left;
  }

  public BSTNode getLeft(){
    return this.left;
  }

  public void setRight(BSTNode right){
    this.right = right;
  }

  public BSTNode getRight(){
    return this.right;
  }


}
