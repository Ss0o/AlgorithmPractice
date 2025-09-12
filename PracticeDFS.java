public class PracticeDFS {
    /*
        섬의 개수 구하기
     */
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0,0,-1,1};

    // dx[0] dy[0] -> 위로 이동 (-1,0)
    // dx[1] dy[1] -> 아래로 이동 (1,0)
    // dx[2] dy[2] -> 좌로 이동 (0,-1)
    // dx[3] dy[3] -> 우로 이동 (0,1)

    /*
     * 사고과정
     * 서로연결되어 있는 섬을 하나로 판별하고 독립된 섬이 총 몇개 인지 구해야 함
     * 섬의 개수를 구해야 하니 섬 개수를 구하는 메서드와 count 지역변수를 선언할 필요
     * 섬을 표현한 이차원 배열 grid에서 완전 탐색을 실행
     * 이 때 섬인 좌표(grid[i][j] == '1')마다 dfs 실행 (why? -> 섬인 좌표를 기준으로 상하좌우를 확인하며 재귀를 이용하면(dfs) '1'로
     *                                                     연결된 독립적인 섬을 찾을 수 있음)
     * 주의1) 확인된 '1'인 곳을 '0'으로 바꾸며 다시 체크하지 않도록 설정
     * 주의2) 예외처리 하기 (함수 인자)
     */
    public int numIslands(char[][] grid) {
        if( grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0 ;j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsIsland(grid,i,j,rows,cols);
                }
            }
        }

        return count;
    }

    private void dfsIsland(char[][] grid, int x, int y, int rows, int cols) {
        if (x < 0 || x>= rows || y <0 || y >= cols || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfsIsland(grid, nx, ny, rows, cols);
        }
    }

    public static void main(String[] args) {
        PracticeDFS practiceDFS = new PracticeDFS();

        //문제1: 섬의 개수
        System.out.println("1. 독립적인 섬의 개수 구하기");

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','0','0','0','1'},
                {'1','0','0','1','0'},
                {'1','0','0','0','1'},
                {'1','1','0','1','0'}
        };
        System.out.println("섬의 개수는 총 " + practiceDFS.numIslands(grid) + "개 입니다.");

    }
}
