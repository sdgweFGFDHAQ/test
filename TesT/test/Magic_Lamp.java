package TesT.test;

public class Magic_Lamp {
    static int count=0;
    public void one(){
        System.out.println("第"+count+"次实现愿望");
        two();
        count++;
    }
    public void two(){
        System.out.println("第"+count+"次实现愿望");
        one();
        count++;
    }

    public static void main(String[] args) {
        try {
            Magic_Lamp ml=new Magic_Lamp();
            ml.one();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
