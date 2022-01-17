package 星环;

/**
 * @Author 1
 * @Date 2021/9/19
 * @Description IntelliJ IDEA
 **/
public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int max = 0;
//        for (int i = 1; i <= n; i++) {
//            int jump = 0;
//            jump += arr[i] * ((i & 1) == 1 ? 1 : (-1));
//            int j = i;
//            while (j < n) {
//                int isJ = jump;
//                int isW = jump;
//                if (j + jump <= n) {
//                    isJ = jump + arr[j + jump] * ((j + jump) & 1);
//                    for (int k = j + 1; k <= j + jump; k++) {
//                        isW += arr[k] * ((k & 1) == 1 ? 1 : (-1));
//                    }
//                } else {
//                    for (int k = j + 1; k <= n; k++) {
//                        isW += arr[k] * ((k & 1) == 1 ? 1 : (-1));
//                    }
//                    isJ = isW;
//                }
//                if (isW > isJ) {
//                    jump = isW;
//                    j++;
//                } else {
//                    jump = isJ;
//                    j += jump;
//                }
//            }
//            max = Math.max(max, jump);
//        }
//        System.out.println(max);

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        HashMap map = new HashMap();
//        for (int i = 0; i < n; i++) {
//            int ID = sc.nextInt();
//            int index = sc.nextInt();
//            if (map.containsKey(index)) {
//                for (int j = map.size() + 1; j > index; j--) {
//                    map.put(j, map.get(j - 1));
//                }
//            }
//            map.put(index, ID);
//        }
//        for (int i = 0; i < map.size(); i++) {
//            System.out.print(map.get(i + 1) + " ");
//        }
//        List list = new ArrayList();
//
//        list.add(2);
//        list.add(0,3);
//        list.add(1,1);
//        System.out.println(list.toString());
    }
}
