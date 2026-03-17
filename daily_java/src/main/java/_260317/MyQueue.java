package _260317;

public class MyQueue {
  private int[] queue;
  private int size;
  private int capacity;
  private int front; // 값을 꺼내올 인덱스
  private int rear; // 값이 들어갈 인덱스


  public MyQueue(int size) {
    this.queue = new int[size];
    this.front = 0;
    this.rear = 0;
    this.size = 0;
    this.capacity = size;
  }


  public void enqueue(int item) {
    if (isFull()) {
      throw new IllegalArgumentException("queue is full");
    }

    queue[rear] = item;
    rear = moveIdx(rear);
    size++;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }

    int item = queue[front];
    front = moveIdx(front);
    size--;

    return item;
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }

    return queue[front];
  }

  public int getSize() {
    return size;
  }


  private int moveIdx(int index) {
    return (index + 1) % capacity;
  }

  private boolean isFull() {
    return this.capacity == size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }
}
