import java.util.*;

public class Mainnn {

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static boolean isValid(int x, int y, int n, char[][] g) {
        return x >= 0 && x < n && y >= 0 && y < n && g[x][y] != 'M';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        char[][] g = new char[n][n];
        int[] start = new int[2]; 
        int[] end = new int[2]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.next().charAt(0);
                if (g[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if (g[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int[][] cost = new int[n][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        cost[start[0]][start[1]] = 0;  
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int x = c[0];
            int y = c[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if (isValid(nx, ny, n, g)) {
                   
                    int moveCost = (g[x][y] == 'T' && g[nx][ny] == 'T') ? 0 : 1;

                    if (cost[x][y] + moveCost < cost[nx][ny]) {
                        cost[nx][ny] = cost[x][y] + moveCost;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if (cost[end[0]][end[1]] == Integer.MAX_VALUE) {
            System.out.print("-1");
        } else {
            System.out.print(cost[end[0]][end[1]]);
        }
    }
}


