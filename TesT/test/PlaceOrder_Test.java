package TesT.test;

public class PlaceOrder_Test {
    //占位符%s，拼接sql,删除两个表中的数据，条件是字符串数组类型的id
    public static void formSql(String tableName, String tableName2, String... strings) {
//sql占位符 %s占位符
        String sql = "delete from %s,%s where id in (%s)";
//声明新的字符串
        String sqls = "";
//遍历字符串的参数数组

        for (String str : strings) {
//将参数数组拼接成字符串，用逗号分割
            sqls += str + ",";
        }
//拼接最后会多出个逗号，截取
        sqls = sqls.substring(0, sqls.length() - 1);
//format第一个sql参数为目标字符串，tableName,tableName2，为替换的两表的名字，sqls为删除数据的参数集合
        String s = String.format(sql, tableName, tableName2, sqls);
//输出拼接后的sql
        System.out.println(s);
    }

    public static void main(String[] args) {
//传入参数为指定表名，和参数值
        PlaceOrder_Test.formSql("user", "role", "1", "3", "5", "7", "9", "33");
    }
}
