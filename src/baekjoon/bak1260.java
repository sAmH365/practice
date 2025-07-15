package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bak1260 {

  static int MAX = 1000 + 10;
  static int N, M, V;
  static ArrayList<Integer>[] graph;
  static LinkedList<Integer> q = new LinkedList<>();
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 정점 개수
    M = Integer.parseInt(st.nextToken()); // 간선 개수
    V = Integer.parseInt(st.nextToken()); // 시작 정점 번호

    visited = new boolean[MAX];
    graph = new ArrayList[MAX];
    for (int i=1;i<=N;i++) {
      graph[i] = new ArrayList<>();
    }

    int x,y;
    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());

      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      graph[x].add(y);
      graph[y].add(x);
    }

    for (int i=1; i<=N; i++) {
      Collections.sort(graph[i]);
    }

    dfs(V);
    System.out.println();

    visited = new boolean[MAX];
    bfs(V);
  }

  static void dfs(int idx) {
    visited[idx] = true;
    System.out.print(idx + " ");

    for (int i=0; i<graph[idx].size(); i++) {
      int next = graph[idx].get(i);

      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  static void bfs(int v) {
    q.offer(v);
    visited[v] = true;

    while (!q.isEmpty()) {
      Integer idx = q.poll();
      System.out.print(idx + " ");

      for (int i=0; i<graph[idx].size(); i++) {
        int next = graph[idx].get(i);
        if (!visited[next]) {
          visited[next] = true;
          q.offer(next);
        }
      }
    }
  }
}
