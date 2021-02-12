package practice.algorithms.graph.medium;

import java.io.*;
import java.util.*;

public class EvenTree {

    static int bfs(int node, HashMap<Integer, ArrayList<Integer>> graph) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(node);
        int member = 1;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(1);
        visited.add(node);
        while (!deque.isEmpty()) {
            int father = deque.removeFirst();
            ArrayList<Integer> children = graph.get(father);
            if (children != null) {
                for (Integer child : children) {
                    if (visited.add(child)) {
                        member += 1;
                        deque.addLast(child);
                    }
                }
            }
        }
        return member;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < tEdges; i++) {
            String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            Integer from = Integer.parseInt(tFromTo[0]);
            Integer to = Integer.parseInt(tFromTo[1]);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int answer = 0;
        ArrayList<Integer> children = graph.get(1);
        for (Integer child : children) {
            if ((bfs(child, graph) & 1) == 0) answer += 1;
        }

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
