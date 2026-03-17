package _260317;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {

  @Test
  void add() {
    MyLinkedList ll = new MyLinkedList();

    ll.add(3);
    ll.add(1);
    ll.add(6);
    ll.add(2);
    ll.add(8);

    assertThat(ll.getSize()).isEqualTo(5);

    assertThat(ll.remove(1)).isTrue();
    assertThat(ll.remove(100)).isFalse();
    assertThat(ll.remove(8)).isTrue();
    assertThat(ll.getSize()).isEqualTo(3);

    ll.addFirst(10);
    ll.addLast(7);

    System.out.println(ll.display());
    System.out.println(ll.getSize());
  }

  @Test
  void isEmpty() {
  }
}
