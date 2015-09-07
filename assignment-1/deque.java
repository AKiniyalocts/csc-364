/**
  author: Anthony Kiniyalocts
  class: deque
  9/7/15

*/

public class deque{

  // Member variables for front and rear nodes of deque
  // Made these for convience instead of calling getPrev() or getNext()

  private dequeNode front;
  private dequeNode rear;

  // initialize to null
  public deque(){
    front = null;
    rear = null;
  }

  public void insertFront(int item){
    dequeNode tmpNode = new dequeNode(item);// temp node for new item

    // empty deque, set front and rear = temp
    if(this.isEmpty()){
      front = tmpNode;
      rear = tmpNode;
    }

    else {
      front.setPrev(tmpNode);
      tmpNode.setNext(front);
      front = front.getPrev();
    }
  }

  public void insertRear(int item){
    dequeNode tmpNode = new dequeNode(item);

    if(this.isEmpty()){
      front = tmpNode;
      rear = tmpNode;
    }
    else {
        rear.setNext(tmpNode);
        tmpNode.setPrev(rear);
        rear = rear.getNext();
    }
  }

  public int deleteFront(){
    if (!this.isEmpty()) {

			if (front == rear) {
				int temp = front.getVal();
				front = rear;
        rear = null;
				return temp;

			}

      else {

				int temp = front.getVal();
				front = front.getNext();
				front.setPrev(null);

			}
		}
    else {
      //empty deque return -1
			return -1;
		}
    //empty deque return -1
		return -1;
  }

  public int deleteRear(){
    if (!this.isEmpty()) {

			if (front == rear) {

				int temp = front.getVal();
				front = rear;
        rear = null;
				return temp;

			}
      else {

				int temp = rear.getVal();
				rear = rear.getPrev();
				rear.setNext(null);

			}
		}
     else {
      //empty deque return -1
			return -1;
		}
    //empty deque return -1
		return -1;
  }

  public void printDeque(){
    if (!this.isEmpty()) {

			dequeNode temp = front;
      System.out.println("-----Front----");

			while (temp != null) {
				System.out.print(temp.getVal() + "\n");
				temp = temp.getNext();

			}
			System.out.println("-----Rear-----");

		} else
			System.out.println("EMPTY DEQUE");
  }

  public boolean isEmpty(){
    return (front == null) && (rear == null);
  }


}
