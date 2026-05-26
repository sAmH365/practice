package _260526;

public class Main {

  public static void main(String[] args) {
    MyHashMap<String, Integer> map = new MyHashMap<>(10);

    map.put("apple", 5);
    map.put("banana", 3);
    map.put("abc", 4);

    System.out.println(map.get("apple"));
    System.out.println(map.get("banana"));
    System.out.println(map.get("abc"));

    map.remove("banana");

    System.out.println(map.get("banana"));

    map.put("bbbb", 30);

    System.out.println(map.getSize());
  }

}
