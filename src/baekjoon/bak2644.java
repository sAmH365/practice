package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bak2644 {

  static int MAX = 100 + 10;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int n, m, a, b;
  static int answer = -1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(br.readLine());

    visited = new boolean[MAX];
    graph = new ArrayList[MAX];
    for (int i=1; i<=n; i++) {
      graph[i] = new ArrayList<>();
    }

    int x, y;
    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());

      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      graph[x].add(y);
      graph[y].add(x);
    }

    dfs(a, 0); // a부터 시작해서 b까지의 거리 찾기

    System.out.println(answer);
  }

  static void dfs(int idx, int depth) {
    visited[idx] = true;

    if (idx == b) {
      answer = depth;
      return;
    }

    for (int next : graph[idx]) {
      if (!visited[next]) {
        dfs(next, depth + 1);
      }
    }
  }
}
