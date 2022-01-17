package TesT.use_Thread;

/**
 * @Author 1
 * @Date 2021/9/11
 * @Description IntelliJ IDEA
 **/
public class Immutable {
    /**
     * 不可变对象
     *
     * @author xuexiaolei
     * @version 2017年11月03日
     */

    private final String name;
    private final String sex;

    public Immutable(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public static void main(String[] args) {
        Immutable immutable = new Immutable("name", "1");
        System.out.println(immutable.getName());
    }
}
