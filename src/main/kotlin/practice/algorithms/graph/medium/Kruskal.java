package practice.algorithms.graph.medium;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

// 题目名称是：Kruskal (MST): Really Special Subtree
// 这题没有kotlin入口，用Java8
// 方法1
// 这个就是典型的Kruskal算法，按权重排序edges，
// 然后用UnionFind连接所有的点，如果能够连接，
// 那么就加上这个边的权重，返回结果即可
// AC
public class Kruskal {
    static class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            parent[rootY] = rootX;
            return true;
        }

        public boolean checkConnect(int x, int y) {
            return find(x) == find(y);
        }
    }

    static class Edge {
        int from;
        int to;
        int weight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        Edge[] edges = new Edge[gEdges];
        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                edges[i] = new Edge();
                edges[i].from = Integer.parseInt(gFromToWeight[0]);
                edges[i].to = Integer.parseInt(gFromToWeight[1]);
                edges[i].weight = Integer.parseInt(gFromToWeight[2]);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));

        int answer = 0;
        UnionFind uf = new UnionFind(gNodes);
        for (int i = 0; i < gEdges; i++) {
            if (uf.union(edges[i].from - 1, edges[i].to - 1)) {
                answer += edges[i].weight;
            }
        }

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
