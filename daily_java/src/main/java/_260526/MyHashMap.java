package _260526;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap <T, V> {
  private static class Entry <T, V> {
    private T key;
    private V value;

    private Entry (T key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private List<Entry>[] bucket;
  private int size;
  private int elementCount;

  public MyHashMap (int size) {
    this.size = size;
    this.bucket = new LinkedList[size];
    for (int i = 0 ; i < size; i++) {
      bucket[i] = new LinkedList<>();
    }
    this.elementCount = 0;
  }

  public V get(T key) {
    int index = hash(key);

    for (Entry<T, V> e : bucket[index]) {
      if (e.key.equals(key)) {
        return e.value;
      }
    }

    return null;
  }

  public void put(T key, V value) {
    int index = hash(key);

    for (Entry e : bucket[index]) {
      if(e.key.equals(key)) {
        e.value = value;
        return;
      }
    }

    bucket[index].add(new Entry(key, value));
    elementCount++;
  }

  public void remove(T key) {
    int index = hash(key);

    bucket[index].removeIf(entry -> entry.key.equals(key));
    elementCount--;
  }

  public int getSize() {
    return elementCount;
  }

  private int hash(T key) {
    return Math.abs(key.hashCode()) % size;
  }
}
