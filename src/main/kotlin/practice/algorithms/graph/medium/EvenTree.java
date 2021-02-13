package practice.algorithms.graph.medium;

import java.io.*;
import java.util.Arrays;

// 方法1
// 本题没有kotlin，使用Java8
// 其实只要有树的题，一定要将注意子树的概念
// 也就是将子树看成一个整体，然后树是由多个子树构成
// 本题的子树要求的就是even就可以剪枝
// 所以我们要统计每个节点作为子树的根节点有多少节点
// 这里有个关键点就是在于root=1，也就是说树是从1开始的
// 那么最后一个子节点自然就是n，所以我们要从最后一个子节点往前计算
// 否则会形成多次计算
// 这里的编码技巧可以看到并查集的一点点影子
// AC
public class EvenTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        final int[] parent = new int[tNodes];
        final int[] sz = new int[tNodes];
        Arrays.fill(sz, 1);

        for (int i = 0; i < tEdges; i++) {
            String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int from = Integer.parseInt(tFromTo[0]) - 1;
            int to = Integer.parseInt(tFromTo[1]) - 1;
            parent[from] = to;
        }

        for (int i = tNodes - 1; i >= 0; i--) {
            sz[parent[i]] += sz[i];
        }

        int answer = 0;
        for (int i = 1; i < sz.length; i++) {
            if ((sz[i] & 1) == 0) {
                answer += 1;
            }
        }

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
