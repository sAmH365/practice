package _260317;

public class MyDoublyLinkedList {
  private Node head;
  private Node tail;
  private int size;


  public MyDoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void add(int item) {
    Node newNode = new Node(item);
    if (isEmpty()) {
      init(newNode);
      return;
    }

    tail.setNext(newNode);
    newNode.setPrev(tail);
    tail = newNode;

    size++;
  }

  public void addFirst(int item) {
    Node newNode = new Node(item);
    if (isEmpty()) {
      init(newNode);
      return;
    }

    head.setPrev(newNode);
    newNode.setNext(head);

    head = newNode;
    size++;
  }
  public void addLast(int item) {
    Node newNode = new Node(item);
    if (isEmpty()) {
      init(newNode);
      return;
    }

    tail.setNext(newNode);
    newNode.setPrev(tail);

    tail = newNode;
    size++;
  }

  public boolean remove(int target) {
    if (isEmpty()) {
      return false;
    }

    Node currentNode = head;

    // 1. head부분 삭제
    if (currentNode.getItem() == target) {
      head = head.getNext();
      if (head != null) {
        head.setPrev(null);
      } else {
        tail = null; // 리스트 전부 비었음
      }

      size--;
      return true;
    }

    // 2. 중간 부분 삭제
    while (currentNode.getNext() != null) {
      Node targetNode = currentNode.getNext();

      if (targetNode.getItem() == target) {
        currentNode.setNext(targetNode.getNext());

        if (targetNode.getNext() != null) {
          targetNode.getNext().setPrev(currentNode);
        } else {
         // 마지막일 경우
         tail = currentNode;
        }

        size--;
        return true;
      }

      currentNode = currentNode.getNext();
    }

    return false;
  }

  public boolean removeFirst(int item) {
    return false;
  }

  public boolean removeLast(int item) {
    return false;
  }

  public boolean removeByIndex(int index) {
    return false;
  }

  private void init(Node node) {
    this.head = node;
    this.tail = node;
    size++;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }
}
