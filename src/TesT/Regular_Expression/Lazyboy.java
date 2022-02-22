package TesT.Regular_Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lazyboy {

//当正则表达式中包含能接受重复的限定符时，通常的行为是（在使整个表达式能得到匹配的前提下）匹配尽可能多的字符。
// 以这个表达式为例：a.*b，它将会匹配最长的以a开始，以b结束的字符串。如果用它来搜索aabab的话，它会匹配整个字符串aabab。
// 这被称为贪婪匹配。
//
//有时，我们更需要懒惰匹配，也就是匹配尽可能少的字符。
// 前面给出的限定符都可以被转化为懒惰匹配模式，只要在它后面加上一个问号?。这样.*?就意味着匹配任意数量的重复，但是在能使整个匹配成功的前提下使用最少的重复。

//(?=exp)也叫零宽度正预测先行断言，它断言自身出现的位置的后面能匹配表达式exp。
// 比如\b\w+(?=ing\b)，匹配以ing结尾的单词的前面部分(除了ing以外的部分)，如查找I'm singing while you're dancing.时，它会匹配sing和danc。
//
//(?<=exp)也叫零宽度正回顾后发断言，它断言自身出现的位置的前面能匹配表达式exp。
// 比如(?<=\bre)\w+\b会匹配以re开头的单词的后半部分(除了re以外的部分)，例如在查找reading a book时，它匹配ading。
    public static void test1() {
        String pc = "北京市(朝阳区)(西城区)(海淀区)";
        String s1 = ".*?(?=\\()";

        Pattern p1 = Pattern.compile(s1);
        Matcher m1 = p1.matcher(pc);
        if (m1.find()) {
            System.out.println(m1.group());
        }

    }
    public static void test2() {
        String pc = "北京市(朝阳区)(西城区)(海淀区)";
        String s2 = "(\\(.*?区\\))(\\(.*?区)";

        Pattern p2 = Pattern.compile(s2);
        Matcher m2 = p2.matcher(pc);
        if (m2.find()) {
            System.out.println(m2.group(2));
        }

    }

    public static void main(String[] args) {
        Lazyboy.test2();
    }

}
