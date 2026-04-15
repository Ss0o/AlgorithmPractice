package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    1 -> [2, 3, 4]
    2 -> [1, 4]
    3 -> [1, 4]
    4 -> [1, 2, 3]
    v = 1
    dfs : 1 2 4 3
    bfs : 1 2 3 4
 */
public class DFSandBFS {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void dfs(int now) {
        visited[now] = true;
        System.out.print(now + " ");

        for(int next : graph[now]) {
            if(!visited[next])
                dfs(next);
        }
    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int n = queue.poll();
            System.out.print(n + " ");
            for(int next : graph[n]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);



    }
}
