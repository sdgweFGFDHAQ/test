package TesT.treeandgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 1
 * @Date 2021/8/25
 * @Description IntelliJ IDEA
 * 对有序无环图进行深度遍历
 **/
public class DFSwithDirectAndNoCircle {
    int[][] g;
    List<Integer> road = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int end;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        end = graph.length - 1;
        g=graph;
        road.add(0);
        dfs(0);
        return ans;
    }

    void dfs(int node) {
        if (node == end) {
            ans.add(new ArrayList<>(road));
            return;
        }
        for(int nextNode: g[node]){
            road.add(nextNode);
            dfs(nextNode);
            road.remove(road.size()-1);//达到road数组初始化的目的
        }
    }

    public static void main(String[] args) {

    }
}

class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    boolean valid = false;
    boolean[] visit;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] kv : graph) {
            edges.get(kv[0]).add(kv[1]);
        }
        visit = new boolean[n];
        dfs(start, target, graph);
        return valid;
    }
    public void dfs(int start, int target, int[][] graph) {
        visit[start] = true;
        if (valid) return;
        if (start == target) {
            valid = true;
            return;
        }
        for (int w : edges.get(start)) {
            if (!visit[w]) {
                dfs(w, target, graph);
            }
        }
    }
}

