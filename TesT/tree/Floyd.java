package TesT.tree;

/**
 * @Author 1
 * @Date 2021/8/2
 * @Description IntelliJ IDEA
 **/
public class Floyd {
    public static int[][] distance;
    public static int[][] path;

    public static void floyd(int[][] graph) {
        distance = graph;
        path = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                path[i][j] = j;
            }
        }

        //每个点为中转
        for (int i = 0; i < graph.length; i++) {
            //所有入度
            for (int j = 0; j < graph.length; j++) {
                //所有出度
                for (int k = 0; k < graph[j].length; k++) {
                    //找到以i为周转站的两个点
                    if (graph[j][i] != -1 && graph[i][k] != -1) {
                        int newDistance = graph[j][i] + graph[i][k];
                        if (newDistance < graph[j][k] || graph[j][k] == -1) {
                            graph[j][k] = newDistance;
                            path[j][k] = i;
                        }
                    }

                }

            }
        }
    }

    public static void main(String[] args) {
        char[] vertices = new char[]{'A', 'B', 'C', 'D'};
        int[][] graph = new int[][]{
                {0, 2, -1, 6},
                {2, 0, 3, 2},
                {-1, 3, 0, 2},
                {6, 2, 2, 0}
        };

        floyd(graph);
        System.out.println("------distance----------");
        for (int[] ints : distance){
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("====path====");
        for (int[] ints : path) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
