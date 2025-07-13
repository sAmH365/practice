package bak11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int MAX = 1000 + 10;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int count = 0;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[MAX];
    graph = new ArrayList[MAX];
    for (int i=1; i<=N; i++) {
      graph[i] = new ArrayList<>();
    }

    int x, y;
    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());

      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      graph[x].add(y);
      graph[y].add(x);
    }

    for (int i=1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }
    }


    System.out.println(count);
  }

  static void dfs(int idx) {
    visited[idx] = true;

    for (int i=0; i<graph[idx].size(); i++) {
      int next = graph[idx].get(i);

      if (!visited[next]) {
        dfs(next);
      }
    }
  }
}
