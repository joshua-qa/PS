import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.run(in, out);
        out.close();
    }

    static class Task {
        int n, w, l, time, currWeight, currTruck;
        int[] trucks;
        Queue<Truck> bridge = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            w = in.nextInt();
            l = in.nextInt();
            trucks = new int[n];
            for (int i = 0; i < n; i++) {
                trucks[i] = in.nextInt();
            }

            do {
                if (!bridge.isEmpty()) {
                    Truck frontTruck = bridge.peek();
                    if (isArrive(frontTruck)) {
                        bridge.poll();
                        currWeight -= frontTruck.getWeight();
                    }
                }
                if (currTruck < n && currWeight + trucks[currTruck] <= l) {
                    currWeight += trucks[currTruck];
                    Truck truck = new Truck(trucks[currTruck++], time);
                    bridge.add(truck);
                }
                time++;
            } while (!bridge.isEmpty());

            out.print(time);
        }

        private boolean isArrive(Truck t) {
            return time - t.inputTime == w;
        }

        static class Truck {
            int weight;
            int inputTime;

            public Truck(int weight, int inputTime) {
                this.weight = weight;
                this.inputTime = inputTime;
            }

            public int getWeight() {
                return weight;
            }

            public int getInputTime() {
                return inputTime;
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}