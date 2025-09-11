import java.util.ArrayList;
import java.util.Stack;

public class Dfs {
    //9개로 지정함
    int N = 9;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited = new boolean[N]; //노드 방문시 true

    //dfs생성 arrayList로
    public Dfs() {
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
    }

    //그래프에 추가
    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    /**
     * DFS 재귀 구현 (Recursive DFS)
     *
     * 장점:
     * - 코드가 직관적이고 구현이 쉬움
     * - 메모리 관리를 시스템이 자동으로 처리함
     * - DFS의 본질적 동작을 잘 표현
     * 
     * 단점:
     * - 깊은 재귀 시 스택 오버플로우 위험이 존재함
     * - 시스템 호출시 오버헤드가 존재함
     * - 메모리 사용량을 직접 제어하기 어려움
     * 
     * 실행 흐름 (노드 0에서 시작):
     * 1. dfsRecursive(0) 호출 → 0 방문 처리 → 0 출력
     * 2. 0의 인접 노드 1 발견 → dfsRecursive(1) 호출
     * 3. 1 방문 처리 → 1 출력 → 1의 인접 노드 3 발견
     * 4. dfsRecursive(3) 호출 → 3 방문 처리 → 3 출력
     * 5. 3의 인접 노드 7 발견 → dfsRecursive(7) 호출
     * 6. 7 방문 처리 → 7 출력 → 7의 인접 노드 없음 → 함수 종료
     * 7. 3으로 돌아가서 다른 인접 노드 확인 → 없음 → 함수 종료
     * 8. 1으로 돌아가서 다른 인접 노드 4 발견 → dfsRecursive(4) 호출
     * ... (이런 식으로 백트래킹하며 모든 노드 탐색)
     */
    public void dfsRecursive(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor);
            }
        }
    }

    /**
     * DFS 반복문 구현 (Iterative DFS)
     *
     * 장점:
     * - 스택 오버플로우 위험이 적음 (힙 메모리 사용)
     * - 재귀 호출 오버헤드가 없음
     * 
     * 단점:
     * - 코드가 상대적으로 복잡함
     * - 명시적인 스택 관리가 필요함
     * - 메모리를 수동으로 관리해야 함
     * 
     * 실행 흐름 (노드 0에서 시작):
     * 1. 스택에 0 추가 → stack: [0]
     * 2. 0을 pop → 0 방문 처리 → 0 출력
     * 3. 0의 인접 노드들을 역순으로 스택에 추가 → stack: [1, 2]
     * 4. 2를 pop → 2 방문 처리 → 2 출력
     * 5. 2의 인접 노드들을 역순으로 추가 → stack: [1, 5, 6]
     * 6. 6을 pop → 6 방문 처리 → 6 출력
     * 7. 6의 인접 노드 없음 → 계속 진행
     * 8. 5를 pop → 5 방문 처리 → 5 출력
     * ... (스택이 빌 때까지 반복)
     * 
     * 주의사항:
     * - 역순으로 스택에 추가하는 이유: 재귀 버전과 같은 순서로 출력하기 위함
     * - 스택의 LIFO 특성 때문에 마지막에 추가된 것부터 처리됨
     */
    public void dfsIterative(int start) {
        boolean[] iterativeVisited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(start);
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            if (!iterativeVisited[node]) {
                iterativeVisited[node] = true;
                System.out.print(node + " ");
                
                for (int i = graph.get(node).size() - 1; i >= 0; i--) {
                    int neighbor = graph.get(node).get(i);
                    if (!iterativeVisited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public void resetVisited() {
        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Dfs dfs = new Dfs();
        
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 3);
        dfs.addEdge(1, 4);
        dfs.addEdge(2, 5);
        dfs.addEdge(2, 6);
        dfs.addEdge(3, 7);
        dfs.addEdge(4, 8);

        System.out.println("DFS (Recursive) starting from node 0:");
        dfs.dfsRecursive(0);
        
        System.out.println("\n\nDFS (Iterative) starting from node 0:");
        dfs.dfsIterative(0);
    }


}
