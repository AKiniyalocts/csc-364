/**
  author: Anthony Kiniyalocts
  class: dequeNode
  9/7/15

*/

public class dequeNode{

  protected dequeNode next;

  protected dequeNode prev;

  protected int val;

  public dequeNode(int v){
    this.val = v;
  }

  public dequeNode getNext(){
    return next;
  }

  public dequeNode getPrev(){
    return prev;
  }

  public void setNext(dequeNode n){
    this.next = n;
  }

  public void setPrev(dequeNode p){
    this.prev = p;
  }

  public int getVal(){
    return this.val;
  }

}
