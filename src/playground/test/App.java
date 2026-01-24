package playground.test;

import java.util.*;

public class App {

  public static void main(String[] args) {

    int[] numbers = {2,1,3,4,1};

      // 서로 다른 두개 뽑아서 더하기
      // 이중 for -> 최대 10000
      // 정렬 -> 일반적으로 NlogN

      int[] answer = new int[1000];

      for (int i = 0; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length - 1; j++) {
          answer[numbers[i] + numbers[j]] = numbers[i] + numbers[j];
        }
      }
      System.out.println(answer);
  }



}
