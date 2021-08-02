package leecode;

import java.util.Arrays;
//我抱有怀疑态度
public class H_index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        H_index h_index=new H_index();
        int[] cit={3,0,6,1,5};
        int[] cit1={1,3,1};
        System.out.println(h_index.hIndex(cit1));
    }
}
