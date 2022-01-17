package llq360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 1
 * @Date 2021/9/2
 * @Description IntelliJ IDEA
 * 作者：keboom
 * 链接：https://www.nowcoder.com/discuss/723939?type=all&order=time&pos=&page=2&ncTraceId=&channel=-1&source_id=search_all_nctrack
 * 来源：牛客网
 * <p>
 * 长城上有连成一排的n个烽火台，每个烽火台都有士兵驻守。第i个烽火台驻守着ai个士兵，相邻峰火台的距离为1。
 * 另外，有m位将军，每位将军可以驻守一个峰火台，每个烽火台可以有多个将军驻守，将军可以影响所有距离他驻守的峰火台小于等于x的烽火台。
 * 每个烽火台的基础战斗力为士兵数，另外，每个能影响此烽火台的将军都能使这个烽火台的战斗力提升k。
 * 长城的战斗力为所有烽火台的战斗力的最小值。
 * 请问长城的最大战斗力可以是多少？
 **/

public class FHT {
    private static long[] diff = new long[200050];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long tower = scanner.nextInt();
        long general = scanner.nextInt();
        long dis = scanner.nextInt();
        long growth = scanner.nextInt();

        long[] towerFight = new long[(int) tower];
        long maxFight = Integer.MIN_VALUE;

        for (int i = 0; i < tower; i++) {
            towerFight[i] = scanner.nextInt();
            maxFight = Math.max(maxFight, towerFight[i]);
        }

        long left = 0;
        long right = maxFight + general * growth;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(towerFight, tower, mid, general, dis, growth)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(long[] towerFight, long tower, long mid, long general, long dis, long growth) {
        Arrays.fill(diff, 0);

        long sum = 0;
        long count = 0;
        for (int i = 0; i < tower; i++) {
            System.out.println(diff[i]);//
            sum += diff[i];
            System.out.println(sum);//
            if (towerFight[i] + sum < mid) {
                long tmp = (mid - towerFight[i] - sum) / growth;
                if ((mid - towerFight[i] - sum) % growth != 0) {
                    tmp++;
                }

                count += tmp;
                int i1 = (int) (i + 2 * dis + 1);
                System.out.println(i1);
                diff[(int) (i + 2 * dis + 1)] -= (tmp * growth);
                System.out.println(diff[i1]);
                sum += tmp * growth;
            }
            if (count > general) {
                return false;
            }
        }
        return true;
    }
}
