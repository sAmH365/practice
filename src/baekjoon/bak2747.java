package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bak2747 {

  static int[] memo;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    memo = new int[n + 1];
    memo[1] = 1;

    System.out.println(fibo(n));
  }

  static int fibo(int n) {
    if (n == 0 || n == 1) return memo[n];

    if (memo[n] != 0) return memo[n];

    memo[n] = fibo(n-1) + fibo(n-2);

    return memo[n];
  }
}
