package TesT.treeandgraph;

/**
 * @Author 1
 * @Date 2021/9/18
 * @Description IntelliJ IDEA
 **/
public class MinTree {
    public void prim(int[][] matrix) {
        int vertexSize = matrix.length;
        int[] lowcost = new int[vertexSize];//最小权值集合 最小时置为0
        int[] adjvex = new int[vertexSize];//放置顶点权值下标
        int min, minId, sum = 0;
        //初始化lowcost数组为matrix二维数组第一行
        for (int i = 1; i < vertexSize; i++) {
            lowcost[i] = matrix[0][i];
        }
        //获取lowcost数组中的最小权值
        for (int i = 1; i < vertexSize; i++) {
            min = Integer.MAX_VALUE;
            minId = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] < min && lowcost[j] > 0) {
                    min = lowcost[j];
                    minId = j;
                }
            }
            System.out.println(adjvex[minId] + min);
            sum += min;
            lowcost[minId] = 0;
            //遍历二维数组索引为minId的那行数组，并且与之前的lowcost数组进行比较，用较小的值替换lowcost数组中的相应值
            for (int j = 0; j < vertexSize; j++) {
                if (lowcost[j] != 0 && matrix[minId][j] < lowcost[j]) {
                    lowcost[j] = matrix[minId][j];
                    adjvex[j] = minId;
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[][] g = {{0, 1, 1, -1, 3}, {1, 0, 4, 9, 5}, {1, 4, 0, 1, 1,}, {-1, 9, 1, 6}, {3, 5, 1, 6, 0}};
        MinTree mt = new MinTree();
        mt.prim(g);
    }
}
