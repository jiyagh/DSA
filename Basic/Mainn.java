import java.util.*;

public class Mainn {
    public static int eGate(String op, int i1, int i2) {
        switch (op) {
            case "AND": return i1 & i2;
            case "OR": return i1 | i2;
            case "NAND": return ~(i1 & i2) & 1; 
            case "NOR": return ~(i1 | i2) & 1;
            case "XOR": return i1 ^ i2;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        Map<String, Gate> gates = new LinkedHashMap<>();
        List<String> gateOrder = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine().trim();

            int a = line.indexOf('=');
            String gate = line.substring(0, a).trim();
            int b = line.indexOf('(', a);
            int c = line.indexOf(',', b);
            int d = line.indexOf(')', c);

            String operation = line.substring(a + 1, b).trim();
            String i1 = line.substring(b + 1, c).trim();
            String i2 = line.substring(c + 1, d).trim();

            gates.put(gate, new Gate(operation, i1, i2));
            gateOrder.add(gate);
        }

    
        int T = Integer.parseInt(sc.nextLine().trim());

        Map<String, int[]> inputs = new HashMap<>();
        int[] defaultCycle = new int[T];

        String targetGate = "";
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.split(" ").length == 1) {
                targetGate = line;
                break;
            }

            String[] parts = line.split(" ");
            String signalName = parts[0];
            int[] cycles = new int[T];
            for (int t = 0; t < T; t++) {
                cycles[t] = Integer.parseInt(parts[t + 1]);
            }
            inputs.put(signalName, cycles);
        }


        Map<String, int[]> outputs = new HashMap<>();
        for (String gate : gates.keySet()) {
            outputs.put(gate, Arrays.copyOf(defaultCycle, T));
        }

 
        for (int t = 1; t < T; t++) {
            for (String gate : gateOrder) {
                Gate g = gates.get(gate);
                String op = g.operation;
                String i1 = g.i1;
                String i2 = g.i2;

                int val1 = inputs.containsKey(i1) ? inputs.get(i1)[t - 1] : outputs.get(i1)[t - 1];
                int val2 = inputs.containsKey(i2) ? inputs.get(i2)[t - 1] : outputs.get(i2)[t - 1];

                outputs.get(gate)[t] = eGate(op, val1, val2);
            }
        }

        int[] targetOutput = outputs.get(targetGate);
        for (int t = 0; t < T; t++) {
            System.out.print(targetOutput[t] + (t == T - 1 ? "" : " "));
        }
    }

    static class Gate {
        String operation;
        String i1;
        String i2;

        Gate(String operation, String i1, String i2) {
            this.operation = operation;
            this.i1 = i1;
            this.i2 = i2;
        }
    }
}

