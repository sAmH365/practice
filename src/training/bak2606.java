package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bak2606 {
  static boolean[][] graph;
  static boolean [] visited;
  static int N, M;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(bf.readLine());
    M = Integer.parseInt(bf.readLine());

    graph = new boolean[N + 1][N + 1];
    visited = new boolean[N + 1];

    int x,y;
    for (int i=0; i<M; i++) {
      StringTokenizer st = new StringTokenizer(bf.readLine());

      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      graph[x][y] = true;
      graph[y][x] = true;
    }

    dfs(1);

    System.out.println(count - 1);
  }

  static void dfs(int idx) {
    visited[idx] = true;
    count++;

    for (int i=1; i <= N; i++) {
      if (!visited[i] && graph[idx][i]) {
        dfs(i);
      }
    }
  }
}
