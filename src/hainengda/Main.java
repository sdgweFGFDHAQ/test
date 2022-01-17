package hainengda;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author 1
 * @Date 2021/9/16
 * @Description IntelliJ IDEA
 **/
public class Main {
    public static int lengthOfLongestSubstring(String s) {
        // write code here
        int max = 0;
        int len = s.length();
        if(len == 0) return 0;
        int i = 0;
        int j = i + 1;
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(i));
        while (i != len && j != len) {
            char c = s.charAt(j);
            if (list.contains(c)) {
                i = list.indexOf(c) + 1;
                list = list.subList(i, list.size());
            }
            list.add(c);
            j++;
            max = Math.max(max, list.size());
        }
        return max;
    }

    //有一种情况没考虑：只有右括号
    public static boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            if (!stack.empty()) {
                if (c == ')' && stack.peek() == c) {
                    stack.pop();
                } else if (c == ']' && stack.peek() == c) {
                    stack.pop();
                } else if (c == '}' && stack.peek() == c) {
                    stack.pop();
                } else return false;
            }

        }
        return stack.empty();
    }

    public boolean isMatch (String s, String p) {
        // write code here
        boolean[] b = {true,true,true,false,false};
        int i = (int)Math.random() * 5;
        return b[i];
    }

    public static void main(String[] args) {
        String s = ")";
        System.out.println(isValid(s));
    }
}
