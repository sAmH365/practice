package _260317;

public class MyLinkedList {
  private Node tail;
  private Node head;
  private int size;

  public MyLinkedList() {
    tail = null;
    head = null;
    size = 0;
  }

  public void add(int item) {
    Node newNode = new Node(item);

    if (isEmpty()) {
      init(newNode);
      return;
    }

    // 마지막 노드 찾기
    Node currentNode = this.head;
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
    }

    // 새로운 값 연결
    currentNode.setNext(newNode);
    size++;
    tail = newNode;
  }

  public void addFirst(int item) {
    Node newNode = new Node(item);

    if (isEmpty()) {
      init(newNode);
      return;
    }

    Node currentNode = this.head;
    newNode.setNext(currentNode);
    this.head = newNode;
    size++;
  }

  public void addLast(int item) {
    Node newNode = new Node(item);

    if (isEmpty()) {
      init(newNode);
      return;
    }

    Node lastNode = this.tail;
    lastNode.setNext(newNode);
    this.tail = newNode;
    size++;
  }

  public boolean remove(int target) {
    Node currentNode = this.head;

    if (!isEmpty() && currentNode.getItem() == target) {
      // 첫 번째 아이템 제거
      this.head = currentNode.getNext();
      size--;
    }

    while (currentNode != null) {
      Node targetNode = currentNode.getNext();
      if (targetNode == null) {
        // 마지막인 경우
       return false;
      }

      if (targetNode.getItem() == target) {

        currentNode.setNext(targetNode.getNext());

        if (targetNode.getNext() == null) {
          // 타겟이 tail일 때
          this.tail = currentNode;
        }

        size--;
        return true;
      } else {
        currentNode = currentNode.getNext();
      }
    }

    return false;
  }

  public String display() {
    Node currentNode = this.head;
    StringBuilder sb = new StringBuilder();

    while (currentNode != null) {
      sb.append(currentNode.getItem()).append(" ");
      currentNode = currentNode.getNext();
    }

    return sb.toString();
  }

  public boolean isEmpty() {
    return size <= 0;
  }

  public int getSize() {
    return size;
  }

  private void init(Node newNode) {
      this.tail = newNode;
      this.head = newNode;
      size++;
  }
}
