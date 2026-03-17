package _260317;

public class Node {
  private int item;
  private Node next;

  public Node(int item) {
    this.item = item;
    next = null;
  }

  public int getItem() {
    return this.item;
  }

  public Node getNext() {
    return this.next;
  }

  public void setNext(Node node) {
    this.next = node;
  }
}
