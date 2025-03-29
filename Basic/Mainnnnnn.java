import java.util.*;

public class Mainnnnnn {
    public static int count(int[][] arr, int row, int col) {
        int size = arr.length;
        int a = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int nRow = row + dx, nCol = col + dy;
                if (nRow >= 0 && nRow < size && nCol >= 0 && nCol < size && arr[nRow][nCol] == 1) {
                    a++;
                }
            }
        }
        return a;
    }

    public static int[][] plague(int[][] arr) {
        int size = arr.length;
        int[][] c = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int a = count(arr, i, j);
                
                if (arr[i][j] == 0 && a == 3) {
                    c[i][j] = 1;
                } else if (arr[i][j] == 1) {
                    if (a < 2 || a > 3) {
                        c[i][j] = 0;
                    } else {
                        c[i][j] = 1;
                    }
                }
            }
        }
        
        return c;
    }

    public static int minDays(int gridSize, char[][] initialBoard) {
        int[][] arr = new int[gridSize][gridSize];
        int startX = -1, startY = -1, destX = -1, destY = -1;
        
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                arr[i][j] = (initialBoard[i][j] == '1') ? 1 : 0;
                if (initialBoard[i][j] == 's') {
                    startX = i;
                    startY = j;
                    arr[i][j] = 0;
                }
                if (initialBoard[i][j] == 'd') {
                    destX = i;
                    destY = j;
                    arr[i][j] = 0;
                }
            }
        }
        
        Queue<State> bfsQueue = new LinkedList<>();
        Set<State> visitedStates = new HashSet<>();
        
        bfsQueue.offer(new State(startX, startY, arr, 0));
        
        while (!bfsQueue.isEmpty()) {
            State current = bfsQueue.poll();
            int x = current.x;
            int y = current.y;
            int[][] cB = current.arr;
            int dP = current.dP;
            
            if (x == destX && y == destY) {
                return dP;
            }
            
            State stateIdentifier = new State(x, y, cB, dP);
            if (visitedStates.contains(stateIdentifier)) continue;
            visitedStates.add(stateIdentifier);
            
            int[][] nextBoard = plague(cB);
            
            int[][] directions = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];
                
                if (newX >= 0 && newX < gridSize && newY >= 0 && newY < gridSize && nextBoard[newX][newY] == 0) {
                    bfsQueue.offer(new State(newX, newY, nextBoard, dP + 1));
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        System.out.print(minDays(n, arr) + 1);
        sc.close();
    }

    static class State {
        int x, y;
        int[][] arr;
        int dP;

        State(int x, int y, int[][] arr, int dP) {
            this.x = x;
            this.y = y;
            this.arr = arr;
            this.dP = dP;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return x == state.x && y == state.y && Arrays.deepEquals(arr, state.arr);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(x, y);
            result = 31 * result + Arrays.deepHashCode(arr);
            return result;
        }
    }
}


