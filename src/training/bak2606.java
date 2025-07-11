package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bak2606 {

  static int MAX = 100 + 10;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int count = 0;
  static int N, M;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine()); // 노드 수
    M = Integer.parseInt(br.readLine()); // 간선 수

    visited = new boolean[MAX];
    graph = new ArrayList[MAX];
    for (int i=1;i<=N;i++) {
      graph[i] = new ArrayList<>();
    }

    int x,y;
    for (int i=0; i<M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      graph[x].add(y);
      graph[y].add(x);
    }

    dfs(1);

    System.out.println(count - 1);
  }

  static void dfs(int idx) {
    visited[idx] = true;
    count++;

    for (int i=0; i<graph[idx].size(); i++) {
      int next = graph[idx].get(i);

      if (!visited[next]) {
        dfs(next);
      }
    }
  }
}
