package _260317;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyDoublyLinkedListTest {

  @Test
  void test1() {
    MyDoublyLinkedList dl = new MyDoublyLinkedList();

    dl.add(10);
    dl.add(20);
    dl.add(30);
    dl.add(40);

    dl.addFirst(3);
    dl.addLast(50);

    assertThat(dl.getSize()).isEqualTo(6);
  }

}
