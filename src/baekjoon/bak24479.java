package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bak24479 {

  static int MAX = 100000 + 10;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int[] answer;
  static int order = 1;
  static int N, M, R;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 정점개수
    M = Integer.parseInt(st.nextToken()); // 간선개수
    R = Integer.parseInt(st.nextToken()); // 시작 정점

    visited = new boolean[MAX];
    answer = new int[MAX];
    graph = new ArrayList[MAX];

    for(int i=1; i<=N; i++){
      graph[i] = new ArrayList<>();
    }

    int x,y;
    for (int i=0; i<M;i++) {
      st = new StringTokenizer(br.readLine());

      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      graph[x].add(y);
      graph[y].add(x);
    }

    // 오름차순 정렬
    for (int i=1; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    // 재귀함수 호출
    dfs(R);

    // 출력
    for (int i=1; i<=N; i++) {
      System.out.println(answer[i]);
    }
  }

  static void dfs(int idx) {
    visited[idx] = true;
    answer[idx] = order;
    order++;

    for (int i = 0; i < graph[idx].size(); i++) {
      int next = graph[idx].get(i);
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

}
