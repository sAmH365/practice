package _260317;

public class MyStack {
  int[] stack;
  int top;

  public MyStack(int size) {
    stack = new int[size];
    top = -1;
  }

  public void push(int item) {
    if (isFull()) {
      throw new IllegalArgumentException("stack is full");
    }

    stack[++top] = item;
  }

  public int pop() {
    if (isEmpty()) {
      throw new IllegalArgumentException("stack is empty");
    }

    return stack[top--];
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalArgumentException("stack is empty");
    }
    return stack[top];
  }

  public int size() {
    return top + 1;
  }

  public boolean isEmpty() {
    return top <= -1;
  }

  private boolean isFull() {
    return top == stack.length - 1;
  }
}
