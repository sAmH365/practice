package baekjoon;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    int origin = input;
    int count = 0;

    do {
      int left = input / 10;      // 10의 자리
      int right = input % 10;     // 1의 자리
      int sum = left + right;
      input = (right * 10) + (sum % 10);
      count++;
    } while (input != origin);

    System.out.println(count);
  }
}

