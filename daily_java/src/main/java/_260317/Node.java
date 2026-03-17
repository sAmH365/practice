package _260317;

public class Node {
  private int item;
  private Node next;
  private Node prev;

  public Node(int item) {
    this.item = item;
    this.next = null;
    this.prev = null;
  }

  public int getItem() {
    return this.item;
  }

  public Node getNext() {
    return this.next;
  }

  public Node getPrev() {return this.prev;}

  public void setNext(Node node) {
    this.next = node;
  }

  public void setPrev(Node node) {this.prev = prev; }
}
