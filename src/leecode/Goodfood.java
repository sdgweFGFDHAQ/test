package leecode;

public class Goodfood {
    final int MAX=1000000007;
    public int countPairs(int[] deliciousness) {
        int count = 0;
        int[] atw = new int[22];
        atw[0] = 1;
        for (int i = 1; i < 22; i++) {
            atw[i] = atw[i - 1] * 2;
        }
        for (int j = 0; j < deliciousness.length-1; j++) {
            for (int i = deliciousness.length - 1; i > j; i--) {
                int c = deliciousness[j] + deliciousness[i];
                for (int a :atw) {
                    if (a == c) {
                        count++;
                    }
                }
            }

        }
        count = count % MAX;
        return count;
    }

    public static void main(String[] args) {
        Goodfood g = new Goodfood();
        int[] d = null;
        int[] d1={2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468};
        //d = new int[]{64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64};
        System.out.println(g.countPairs(d1));
    }
}
