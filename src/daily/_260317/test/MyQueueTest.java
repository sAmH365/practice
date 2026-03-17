package daily._260317.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import daily._260317.MyQueue;
import org.junit.jupiter.api.Test;

class MyQueueTest {

  @Test
  void test1() {
    MyQueue q = new MyQueue(5);

    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.enqueue(40);
    q.enqueue(50);

    assertThrows(IllegalArgumentException.class, () -> {
      q.enqueue(50);
    });

    assertEquals(10, q.peek());
    assertEquals(10, q.dequeue());
    assertEquals(4, q.getSize());

    while (!q.isEmpty()) {
      q.dequeue();
    }

    assertThrows(IllegalArgumentException.class, () -> {
      q.dequeue();
    });
  }

}
