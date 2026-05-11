package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ConnectedComponent {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void dfs(int now) {
        visited[now] = true;

        for(int next : graph[now]) {
            if(!visited[next])
                dfs(next);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(!visited[i])
            {
                count++;
                dfs(i);
            }
        }
        System.out.print(count);
    }
}
