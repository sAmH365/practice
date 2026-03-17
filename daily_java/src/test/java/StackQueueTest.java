
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import _260317.MyQueue;
import _260317.MyStack;
import org.junit.jupiter.api.Test;

class StackQueueTest {

  @Test
  void queue_test() {
    MyQueue q = new MyQueue(5);

    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.enqueue(40);
    q.enqueue(50);


    assertThrows(IllegalArgumentException.class, () -> {
      q.enqueue(10);
    });

    assertThat(q.dequeue()).isEqualTo(10);

    while (!q.isEmpty()) {
      q.dequeue();
    }

    assertThrows(IllegalArgumentException.class, () -> {
      q.dequeue();
    });
  }

  @Test
  void stack_test() {
    MyStack stack = new MyStack(5);

    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);

    assertThrows(IllegalArgumentException.class, () -> {
      stack.push(1);
    });

    assertThat(stack.pop()).isEqualTo(50);
    assertThat(stack.peek()).isEqualTo(40);
    assertThat(stack.pop()).isEqualTo(40);
    assertThat(stack.peek()).isEqualTo(30);

    while(!stack.isEmpty()) {
      stack.pop();
    }

    assertThrows(IllegalArgumentException.class, () -> {
      stack.pop();
    });
  }
}
