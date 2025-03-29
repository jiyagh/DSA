import java.util.*;

public class Mainnnnn {
    public static boolean point(int x, int y, List<Pair<Integer, Integer>> polygonVertices) {
        int a = polygonVertices.size();
        boolean b = false;
        for (int i = 0; i < a; ++i) {
            int x1 = polygonVertices.get(i).getKey(), y1 = polygonVertices.get(i).getValue();
            int x2 = polygonVertices.get((i + 1) % a).getKey(), y2 = polygonVertices.get((i + 1) % a).getValue();
            
            if (((y1 > y) != (y2 > y)) && (x < (x2 - x1) * (y - y1) / (double)(y2 - y1) + x1)) {
                b = !b;
            }
        }
        return b;
    }

    public static int minPress(List<Pair<Integer, Integer>> polygonVertices, int s) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        
        for (Pair<Integer, Integer> p : polygonVertices) {
            minX = Math.min(minX, p.getKey());
            maxX = Math.max(maxX, p.getKey());
            minY = Math.min(minY, p.getValue());
            maxY = Math.max(maxY, p.getValue());
        }

        Set<Pair<Integer, Integer>> coveredPoints = new HashSet<>();
        int p = 0;
        
        for (int x = minX; x <= maxX; ++x) {
            for (int y = minY; y <= maxY; ++y) {
                if (point(x, y, polygonVertices)) {
                    boolean cov = false;

                    for (int dx = 0; dx < s && !cov; ++dx) {
                        for (int dy = 0; dy < s; ++dy) {
                            if (coveredPoints.contains(new Pair<>(x + dx, y + dy))) {
                                cov = true;
                                break;
                            }
                        }
                    }

                    if (!cov) {
                        ++p;
                        for (int dx = 0; dx < s; ++dx) {
                            for (int dy = 0; dy < s; ++dy) {
                                coveredPoints.add(new Pair<>(x + dx, y + dy));
                            }
                        }
                    }
                }
            }
        }
        
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        List<Pair<Integer, Integer>> polygonVertices = new ArrayList<>();
        
        for (int i = 0; i < a; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            polygonVertices.add(new Pair<>(x, y));
        }

        int s = sc.nextInt();

        int result = minPress(polygonVertices, s);
        System.out.print(result);

        sc.close();
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) &&
                   Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}



